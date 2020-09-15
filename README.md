# Java Packages

## 介绍

该仓库作为 Java SIG 的入口仓库，用于存放 openEuler 社区 Java 打包相关代码、宏、工具，以及指引文档。此外，我们明确需要维护的软件包分为如下几类：

1. Java 构建工具本体软件包，例如 `maven` `gradle` `ant` 等。
2. Java 构建工具相关衍生软件包，例如 `maven_local` 等。
3. Java 构建工具所依赖的 Java 软件包。
4. Java 软件包，及其所依赖的 Java 软件包。
5. Java 软件包，及其所依赖的专用软件包（专门用于支撑该 Java 软件）。


## 软件架构

暂无


## 安装教程

暂无

## 使用说明

暂无

## 参与贡献

欢迎参与 issue 的讨论和贡献相关 PR。

### 基本过程
1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

### Git 和 PR 指南

1. https://gitee.com/openeuler/community/blob/master/zh/contributors/Gitee-workflow.md
2. https://gitee.com/openeuler/community/blob/master/zh/contributors/pull-request.md
3. https://gitee.com/openeuler/community/blob/master/zh/sig-infrastructure/command.md
4. https://gitee.com/openeuler/community/blob/master/zh/contributors/pull-requests.md

### 软件包提交PR审核注意事项

1. 检查门禁程序是否通过，不通过则不允许合并；
2. 了解软件包作用，评估是否应属于Java-Packages，即符合上述介绍中明确需要维护的软件包范围，如遇疑问，可与其他maintainer讨论软件包归属后再决定是否允许合并；
3. 注意spec文件中是否存在特殊代码，如"fedora"或"rhel"等信息，可点击[这里][suspected_spec]查看相关issue，如遇此类问题请先与提交者确认后再决定是否允许合并。

### 学习资料

1. [RPM Documentation][rpm_doc]
2. [spec文件中URL与source等check脚本，license文件check脚本][spec_check_file]

[rpm_doc](http://rpm.org/documentation)
[suspected_spec](https://gitee.com/openeuler/Java-Packages/issues/I1UL4S?from=project-issue)
[spec_check_file](https://gitee.com/openeuler/Java-Packages/attach_files)

