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
 * Description: collect rpm package metadata, which mainly needed  by Preamble parts
 */
package org.openeulerproject.jpackage.meta;

import org.apache.maven.model.License;
import org.apache.maven.model.Model;
import org.openeulerproject.jpackage.model.AbstractModelVisitor;

public class RpmBasicInfoVisitor extends AbstractModelVisitor {

    private String name = "";

    private String version = "";

    private String license = "";

    private String url = "";

    private String buildArch = "noarch";

    private String description = "";

    @Override
    public void visitProject( Model model ) {
        name = model.getName();
        version = model.getVersion();
        url = model.getUrl();
    }

    @Override
    public void visitLicense( License lic ) {
        license = lic.getName();
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getLicense() {
        return license;
    }

    public String getUrl() {
        return url;
    }

    public String getBuildArch() {
        return buildArch;
    }

    public String getDescription() {
        return description;
    }
}
