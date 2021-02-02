/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * licensed under the Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *      http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 * PURPOSE.
 * See the Mulan PSL v2 for more details.
 * Author: rita_dong
 * Create: 2021-01-01
 */
package org.openeulerproject.jpackage.mojo;

import com.alibaba.fastjson.JSON;
import org.apache.maven.lifecycle.mapping.Lifecycle;
import org.apache.maven.lifecycle.mapping.LifecycleMapping;
import org.apache.maven.lifecycle.mapping.LifecycleMojo;
import org.apache.maven.lifecycle.mapping.LifecyclePhase;

import org.apache.maven.model.Model;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.codehaus.plexus.logging.Logger;
import org.eclipse.aether.artifact.ArtifactTypeRegistry;
import org.fedoraproject.xmvn.artifact.Artifact;
import org.fedoraproject.xmvn.artifact.DefaultArtifact;
import org.openeulerproject.jpackage.meta.BuildDependencyVisitor;
import org.openeulerproject.jpackage.meta.RpmBasicInfoVisitor;
import org.openeulerproject.jpackage.meta.RpmMetaInfo;
import org.openeulerproject.jpackage.model.ModelProcessor;
import org.openeulerproject.jpackage.model.impl.DefaultModelProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Goal which touches a timestamp file.
 *
 * @author  rita_dong
 */
@Mojo(name = "buildmetadata", aggregator = true, requiresDependencyResolution = ResolutionScope.NONE)
public class BuildMetadataMojo extends AbstractMojo {

    private static class NamespacedArtifact
    {
        String namespace;

        Artifact artifact;

        public NamespacedArtifact( String namespace, Artifact artifact )
        {
            this.namespace = namespace != null ? namespace : "";
            this.artifact = artifact;
        }

        @Override
        public int hashCode()
        {
            return artifact.hashCode() ^ namespace.hashCode();
        }

        @Override
        public boolean equals( Object rhs )
        {
            NamespacedArtifact other = (NamespacedArtifact) rhs;
            return namespace.equals( other.namespace ) && artifact.equals( other.artifact );
        }
    }


    @Component
    private Logger logger;

    @Component
    private PlexusContainer container;

    private final ModelProcessor modelProcessor = new DefaultModelProcessor();

    private Set<Artifact> commonDeps = new LinkedHashSet<>();

//    @Parameter( defaultValue = "xmvn.builddep.skip" )
//    private boolean skip;

    @Parameter (defaultValue = "${reactorProjects}", readonly = true, required = true)
    private List<MavenProject> reactorProjects;

    public BuildMetadataMojo() {
        try (InputStream xmlStream = ArtifactTypeRegistry.class.getResourceAsStream("/common-deps")) {
            DocumentBuilder xmlBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = xmlBuilder.parse(xmlStream);
            NodeList dependencies = doc.getElementsByTagName("dependency");
            for (int i = 0; i < dependencies.getLength(); i++) {
                Element dependency = (Element)dependencies.item(i);
                String groupId = dependency.getAttribute("groupId");
                String artifactId = dependency.getAttribute("artifactId");
                commonDeps.add(new DefaultArtifact(groupId, artifactId));
            }
        } catch (IOException |ParserConfigurationException | SAXException ex ) {
            throw new RuntimeException("Couldn't load resource common-deps", ex);
        }

    }

    public void execute() throws MojoExecutionException {
        getLog().info("Hello BuildMetadataMojo");
//        if ( skip ) {
//            logger.info( "Skipping buiddep: xmvn.builddep.skip property was set" );
//            return;
//        }

        Set<Artifact> artifacts = new LinkedHashSet<>();
        Set<Artifact> lifecycleArtifacts = new LinkedHashSet<>();
        for (MavenProject project: reactorProjects) {
            artifacts.addAll(getModelDependencies(project.getModel()));
            addLifecycleDependencies(lifecycleArtifacts, project);
        }

        artifacts.removeIf(dep -> commonDeps.contains(dep.setVersion(Artifact.DEFAULT_VERSION)));
        lifecycleArtifacts.removeIf(dep -> commonDeps.contains(dep));

        // TODO xmvn-mojo中BuilddepMojo，暂没理解含义
        Set<NamespacedArtifact> deps = new LinkedHashSet<>();
//        for ( String[] resolution : resolutions )
//        {
//            if ( resolution == null )
//                continue;
//
//            Artifact artifact = new DefaultArtifact( resolution[0] );
//            Artifact versionlessArtifact = artifact.setVersion( Artifact.DEFAULT_VERSION );
//            String compatVersion = resolution[1];
//            String namespace = resolution[2];
//
//            if ( artifacts.contains( artifact ) || lifecycleArtifacts.contains( versionlessArtifact ) )
//            {
//                deps.add( new NamespacedArtifact( namespace, artifact.setVersion( compatVersion ) ) );
//            }
//        }

        RpmMetaInfo rpmMetaInfo = new RpmMetaInfo();
        if (!deps.isEmpty()) {
            for (NamespacedArtifact ar: deps) {
                rpmMetaInfo.addDependency(ar.artifact);
            }
        }

        RpmBasicInfoVisitor basicInfoVisitor = new RpmBasicInfoVisitor();
        // TODO 多个project是打多个package么？暂时先打一个package
        MavenProject project = reactorProjects.get(1);
        modelProcessor.processModel(project.getModel(), basicInfoVisitor);
        rpmMetaInfo.setName(basicInfoVisitor.getName());
        rpmMetaInfo.setVersion(basicInfoVisitor.getVersion());
        rpmMetaInfo.setLicense(basicInfoVisitor.getLicense());
        rpmMetaInfo.setUrl(basicInfoVisitor.getUrl());
        rpmMetaInfo.setBuildArch(basicInfoVisitor.getBuildArch());
        rpmMetaInfo.setDescription(basicInfoVisitor.getDescription());

        //write RpmMetaInfo to local file
        serializeRpmMetaInfo(rpmMetaInfo);

    }

    private void serializeRpmMetaInfo(RpmMetaInfo rpmMetaInfo) throws MojoExecutionException {
        Path path = Paths.get(".jpackage-buildmetadata");
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            String rpmMetaInfoStr = JSON.toJSONString(rpmMetaInfo);
            writer.write(rpmMetaInfoStr);
        } catch (IOException e) {
            throw new MojoExecutionException( "Unable to write buildmetadata file", e );
        }
    }

    private void addLifecycleDependencies(Set<Artifact> artifacts, MavenProject project) throws MojoExecutionException {
        Lifecycle defaultLifecycle = getDefaultLifecycle(project);
        if (defaultLifecycle == null) {
            return;
        }

        for (LifecyclePhase phase: defaultLifecycle.getLifecyclePhases().values()) {
            if (phase.getMojos() == null) {
                continue;
            }

            for (LifecycleMojo mojo: phase.getMojos()) {
                // Goal can be in one of three formats (per MojoDescriptorCreator):
                // - (1) groupId:artifactId:version:goal
                // - (2) groupId:artifactId:goal
                // - (3) prefix:goal
                //
                // We don't care about version (currently, plugins can't have compat versions), so we can just parse
                // plugin groupId and artifactId from string in formats (1) and (2), ignoring goals in format (3).
                // Format with prefix is rarely (if ever) used and therefore not supported by XMvn. If needed, support
                // for that format can be implemented with help of PluginPrefixResolver.
                //
                String[] goalCoords = mojo.getGoal().split( ":" );
                if ( goalCoords.length >= 3 )
                {
                    artifacts.add( new DefaultArtifact( goalCoords[0], goalCoords[1] ) );
                }
            }
        }

    }

    private Lifecycle getDefaultLifecycle(MavenProject project) throws MojoExecutionException {
        ClassRealm projectRealm = project.getClassRealm();
        if (projectRealm == null) {
            projectRealm = container.getContainerRealm();
        }

        ClassRealm oldLookupRealm = container.setLookupRealm(projectRealm);
        ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(projectRealm);

        try {
            return container.lookup(LifecycleMapping.class, project.getPackaging()).getLifecycles().get("default");
        } catch (ComponentLookupException e) {
            throw new MojoExecutionException( "Unable to get lifecycle for project " + project.getId(), e );

        } finally {
            container.setLookupRealm(oldLookupRealm);
            Thread.currentThread().setContextClassLoader(oldClassLoader);
        }

    }


    private Set<Artifact> getModelDependencies(Model model) {
        BuildDependencyVisitor visitor = new BuildDependencyVisitor(location -> {

            return !reactorProjects.stream() //
                    .map( project -> project.getModel().getLocation( "" ).getSource().getModelId() ) //
                    .filter( modelId -> modelId.equals( location.getSource().getModelId() ) ) //
                    .findAny().isPresent();
        });

        modelProcessor.processModel(model, visitor);
        return visitor.getArtifacts();
    }

}
