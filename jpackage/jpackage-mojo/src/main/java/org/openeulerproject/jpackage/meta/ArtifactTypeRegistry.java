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
package org.openeulerproject.jpackage.meta;

import org.fedoraproject.xmvn.artifact.Artifact;
import org.fedoraproject.xmvn.artifact.DefaultArtifact;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

final class ArtifactTypeRegistry {
    private static final ArtifactTypeRegistry DEFAULT_REGISTRY = new ArtifactTypeRegistry();

    private final Map<String, String> extensions = new LinkedHashMap<>();

    private final Map<String, String> classifiers = new LinkedHashMap<>();

    private void addStereotype(String type, String extension, String classifier ) {
        extensions.put( type, extension );
        classifiers.put( type, classifier );
    }

    private ArtifactTypeRegistry() {
        try ( InputStream xmlStream = ArtifactTypeRegistry.class.getResourceAsStream( "/stereotypes.xml" ) )
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse( xmlStream );
            NodeList stereotypes = doc.getElementsByTagName( "stereotype" );
            for ( int i = 0; i < stereotypes.getLength(); i++ )
            {
                Element stereotype = (Element) stereotypes.item( i );
                String type = stereotype.getAttribute( "type" );
                String extension = stereotype.getAttribute( "extension" );
                String classifier = stereotype.getAttribute( "classifier" );
                addStereotype( type, extension, classifier );
            }
        }
        catch ( ParserConfigurationException | IOException | SAXException ex )
        {
            throw new RuntimeException( "Couldnt load resource 'stereotypes.xml'", ex );
        }
    }

    public static ArtifactTypeRegistry getDefaultRegistry() {
        return DEFAULT_REGISTRY;
    }

    public Artifact createTypedArtifact(String groupId, String artifactId, String type, String customClassifier,
                                        String version ) {
        if ( type == null || extensions.get( type ) == null )
            return new DefaultArtifact( groupId, artifactId, type, customClassifier, version );

        String classifier =
            customClassifier == null || customClassifier.isEmpty() ? classifiers.get( type ) : customClassifier;
        return new DefaultArtifact( groupId, artifactId, extensions.get( type ), classifier, version );
    }
}
