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
 * Description: RPM package meta info
 */
package org.openeulerproject.jpackage.meta;

import org.fedoraproject.xmvn.artifact.Artifact;

import java.util.ArrayList;
import java.util.List;

public class RpmMetaInfo {

    private String name;

    private String version;

    private String license;

    private String url;

    private String buildArch = "noarch";

    private String description;

    private List<Artifact> dependencies = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBuildArch() {
        return buildArch;
    }

    public void setBuildArch(String buildArch) {
        this.buildArch = buildArch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Artifact> getDependency() {
        return dependencies;
    }

    public void addDependency(Artifact dependency) {
        this.dependencies.add(dependency);
    }

}
