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
 * Description: collect rpm build dependencies
 */
package org.openeulerproject.jpackage.meta;

import org.apache.maven.model.*;
import org.codehaus.plexus.util.StringUtils;
import org.fedoraproject.xmvn.artifact.Artifact;
import org.fedoraproject.xmvn.artifact.DefaultArtifact;
import org.openeulerproject.jpackage.model.AbstractModelVisitor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class BuildDependencyVisitor extends AbstractModelVisitor {
    private static final List<String> BUILD_SCOPES = Arrays.asList( null, "compile", "provided", "test", "runtime" );

    private static final List<String> RUNTIME_SCOPES = Arrays.asList( null, "compile", "runtime" );

    private final Function<InputLocation, Boolean> isExternalLocation;

    private final Set<Artifact> artifacts = new LinkedHashSet<>();

    public BuildDependencyVisitor(Function<InputLocation, Boolean> isExternalLocation ) {
        this.isExternalLocation = isExternalLocation;
    }

    public Set<Artifact> getArtifacts() {
        return Set.copyOf( artifacts );
    }

    private boolean isExternal( InputLocation location ) {
        return location == null || isExternalLocation.apply( location );
    }

    @Override
    public void visitParent( Parent parent ) {
        artifacts.add( new DefaultArtifact( parent.getGroupId(), parent.getArtifactId(), "pom", parent.getVersion() ) );
    }

    @Override
    public void visitDependency( Dependency dependency ) {
        if ( isExternal( dependency.getLocation( "" ) ) )
            return;
        if ( !BUILD_SCOPES.contains( dependency.getScope() ) )
            return;

        artifacts.add( ArtifactTypeRegistry.getDefaultRegistry().createTypedArtifact( dependency.getGroupId(),
                                                                                      dependency.getArtifactId(),
                                                                                      dependency.getType(),
                                                                                      dependency.getClassifier(),
                                                                                      dependency.getVersion() ) );
    }

    @Override
    public void visitBuildExtension( Extension extension ) {
        artifacts.add( new DefaultArtifact( extension.getGroupId(), extension.getArtifactId(),
                                            extension.getVersion() ) );
    }

    @Override
    public void visitBuildPlugin( Plugin plugin ) {
        if ( isExternal( plugin.getLocation( "" ) ) )
            return;

        String groupId = plugin.getGroupId();
        String artifactId = plugin.getArtifactId();
        String version = plugin.getVersion();
        if ( StringUtils.isEmpty( groupId ) )
            groupId = "org.apache.maven.plugins";
        if ( StringUtils.isEmpty( version ) )
            version = Artifact.DEFAULT_VERSION;

        Artifact pluginArtifact = new DefaultArtifact( groupId, artifactId, version );
        artifacts.add( pluginArtifact );
    }

    @Override
    public void visitBuildPluginDependency( Dependency dependency ) {
        if ( isExternal( dependency.getLocation( "" ) ) )
            return;
        if ( !RUNTIME_SCOPES.contains( dependency.getScope() ) )
            return;

        artifacts.add( ArtifactTypeRegistry.getDefaultRegistry().createTypedArtifact( dependency.getGroupId(),
                                                                                      dependency.getArtifactId(),
                                                                                      dependency.getType(),
                                                                                      dependency.getClassifier(),
                                                                                      dependency.getVersion() ) );
    }
}
