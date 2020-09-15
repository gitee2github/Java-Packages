# Java-Packages

## Description

This repository serves as the entry point repository for the Java SIG and is used as a repository for the openEuler community's Java packaging-related code, macros, tools, and guidelines. In addition, we identify packages to be maintained in the following categories.

1. Java build tool ontology packages, such as `maven` `gradle` `ant` and so on. 
2. Java build tool-related derivative packages, such as `maven_local` and so on. 
3. Java packages on which above Java build tool depends. 
4. Java packages, and the Java packages on which they depend.
5. Java packages, and the specialized packages on which they depend (specifically to support the Java software).

## Software Architecture

n/a

## Installation

n/a

## Instructions

n/a

## Contribution

You are welcome to participate in the discussion of the issues and contribute to the PR.

### Basic Procedure

1.  Fork the repository
2.  Create Feat_xxx branch
3.  Commit your code
4.  Create Pull Request

### Git and RP Guider

1. https://gitee.com/openeuler/community/blob/master/zh/contributors/Gitee-workflow.md
2. https://gitee.com/openeuler/community/blob/master/zh/contributors/pull-request.md
3. https://gitee.com/openeuler/community/blob/master/zh/sig-infrastructure/command.md
4. https://gitee.com/openeuler/community/blob/master/zh/contributors/pull-requests.md

### Notes on software packaging pull request checking

1. Check whether the automatic check program is passed, if not, it is not allowed to merge;
2. Understand the function of software and evaluate whether it belongs to Java-Packages, that is, it conforms to the scope of software that needs to be maintained in the above introduction. In case of doubt, you can discuss with other maintainers before deciding whether to allow merging;
3. Note if there are special codes in the spec file, such as "fedora" or "rhel" information, click [here] [suspected_spec] to view the relevant issue, in case of this type of issue please confirm with the pr committers before deciding whether to allow merging.

### Learning materials

1. [RPM Documentation][rpm_doc]
2. [Check scripts for information such as URL and source in spec file, check scripts for license file][spec_check_file]

[rpm_doc]: http://rpm.org/documentation
[suspected_spec]: https://gitee.com/openeuler/Java-Packages/issues/I1UL4S?from=project-issue
[spec_check_file]: https://gitee.com/openeuler/Java-Packages/attach_files


