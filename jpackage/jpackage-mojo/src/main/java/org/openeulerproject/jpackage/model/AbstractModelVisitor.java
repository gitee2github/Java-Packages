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
package org.openeulerproject.jpackage.model;

import org.apache.maven.model.*;

public class AbstractModelVisitor
    implements ModelVisitor
{
    @Override
    public Build replaceBuild( Build build )
    {
        return build;
    }

    @Override
    public Extension replaceBuildExtension( Extension extension )
    {
        return extension;
    }

    @Override
    public String replaceBuildFilter(String filter )
    {
        return filter;
    }

    @Override
    public Plugin replaceBuildPlugin( Plugin plugin )
    {
        return plugin;
    }

    @Override
    public Dependency replaceBuildPluginDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceBuildPluginDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public PluginExecution replaceBuildPluginExecution( PluginExecution execution )
    {
        return execution;
    }

    @Override
    public String replaceBuildPluginExecutionGoal(String goal )
    {
        return goal;
    }

    @Override
    public PluginManagement replaceBuildPluginManagement( PluginManagement pluginManagement )
    {
        return pluginManagement;
    }

    @Override
    public Plugin replaceBuildPluginManagementPlugin( Plugin plugin )
    {
        return plugin;
    }

    @Override
    public Dependency replaceBuildPluginManagementPluginDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceBuildPluginManagementPluginDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public PluginExecution replaceBuildPluginManagementPluginExecution( PluginExecution execution )
    {
        return execution;
    }

    @Override
    public String replaceBuildPluginManagementPluginExecutionGoal(String goal )
    {
        return goal;
    }

    @Override
    public Resource replaceBuildResource( Resource resource )
    {
        return resource;
    }

    @Override
    public String replaceBuildResourceExclude(String exclude )
    {
        return exclude;
    }

    @Override
    public String replaceBuildResourceInclude(String include )
    {
        return include;
    }

    @Override
    public Resource replaceBuildTestResource( Resource testResource )
    {
        return testResource;
    }

    @Override
    public String replaceBuildTestResourceExclude(String exclude )
    {
        return exclude;
    }

    @Override
    public String replaceBuildTestResourceInclude(String include )
    {
        return include;
    }

    @Override
    public CiManagement replaceCiManagement( CiManagement ciManagement )
    {
        return ciManagement;
    }

    @Override
    public Notifier replaceCiManagementNotifier( Notifier notifier )
    {
        return notifier;
    }

    @Override
    public String replaceCiManagementNotifierConfiguration(String configurationElementKey,
                                                           String configurationElementValue )
    {
        return configurationElementValue;
    }

    @Override
    public Contributor replaceContributor( Contributor contributor )
    {
        return contributor;
    }

    @Override
    public String replaceContributorProperty(String propertyKey, String propertyValue )
    {
        return propertyValue;
    }

    @Override
    public String replaceContributorRole(String role )
    {
        return role;
    }

    @Override
    public Dependency replaceDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public DependencyManagement replaceDependencyManagement( DependencyManagement dependencyManagement )
    {
        return dependencyManagement;
    }

    @Override
    public Dependency replaceDependencyManagementDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceDependencyManagementDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public Developer replaceDeveloper( Developer developer )
    {
        return developer;
    }

    @Override
    public String replaceDeveloperProperty(String propertyKey, String propertyValue )
    {
        return propertyValue;
    }

    @Override
    public String replaceDeveloperRole(String role )
    {
        return role;
    }

    @Override
    public DistributionManagement replaceDistributionManagement( DistributionManagement distributionManagement )
    {
        return distributionManagement;
    }

    @Override
    public Relocation replaceDistributionManagementRelocation( Relocation relocation )
    {
        return relocation;
    }

    @Override
    public DeploymentRepository replaceDistributionManagementRepository( DeploymentRepository repository )
    {
        return repository;
    }

    @Override
    public RepositoryPolicy replaceDistributionManagementRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceDistributionManagementRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public Site replaceDistributionManagementSite( Site site )
    {
        return site;
    }

    @Override
    public DeploymentRepository replaceDistributionManagementSnapshotRepository( DeploymentRepository snapshotRepository )
    {
        return snapshotRepository;
    }

    @Override
    public RepositoryPolicy replaceDistributionManagementSnapshotRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceDistributionManagementSnapshotRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public IssueManagement replaceIssueManagement( IssueManagement issueManagement )
    {
        return issueManagement;
    }

    @Override
    public License replaceLicense( License license )
    {
        return license;
    }

    @Override
    public MailingList replaceMailingList( MailingList mailingList )
    {
        return mailingList;
    }

    @Override
    public String replaceMailingListOtherArchive(String otherArchive )
    {
        return otherArchive;
    }

    @Override
    public String replaceModule(String module )
    {
        return module;
    }

    @Override
    public Organization replaceOrganization( Organization organization )
    {
        return organization;
    }

    @Override
    public Parent replaceParent( Parent parent )
    {
        return parent;
    }

    @Override
    public Repository replacePluginRepository( Repository pluginRepository )
    {
        return pluginRepository;
    }

    @Override
    public RepositoryPolicy replacePluginRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replacePluginRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public Prerequisites replacePrerequisite( Prerequisites prerequisites )
    {
        return prerequisites;
    }

    @Override
    public Profile replaceProfile( Profile profile )
    {
        return profile;
    }

    @Override
    public Activation replaceProfileActivation( Activation activation )
    {
        return activation;
    }

    @Override
    public ActivationFile replaceProfileActivationFile( ActivationFile file )
    {
        return file;
    }

    @Override
    public ActivationOS replaceProfileActivationO( ActivationOS os )
    {
        return os;
    }

    @Override
    public ActivationProperty replaceProfileActivationProperty( ActivationProperty property )
    {
        return property;
    }

    @Override
    public BuildBase replaceProfileBuild( BuildBase build )
    {
        return build;
    }

    @Override
    public String replaceProfileBuildFilter(String filter )
    {
        return filter;
    }

    @Override
    public Plugin replaceProfileBuildPlugin( Plugin plugin )
    {
        return plugin;
    }

    @Override
    public Dependency replaceProfileBuildPluginDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceProfileBuildPluginDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public PluginExecution replaceProfileBuildPluginExecution( PluginExecution execution )
    {
        return execution;
    }

    @Override
    public String replaceProfileBuildPluginExecutionGoal(String goal )
    {
        return goal;
    }

    @Override
    public PluginManagement replaceProfileBuildPluginManagement( PluginManagement pluginManagement )
    {
        return pluginManagement;
    }

    @Override
    public Plugin replaceProfileBuildPluginManagementPlugin( Plugin plugin )
    {
        return plugin;
    }

    @Override
    public Dependency replaceProfileBuildPluginManagementPluginDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceProfileBuildPluginManagementPluginDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public PluginExecution replaceProfileBuildPluginManagementPluginExecution( PluginExecution execution )
    {
        return execution;
    }

    @Override
    public String replaceProfileBuildPluginManagementPluginExecutionGoal(String goal )
    {
        return goal;
    }

    @Override
    public Resource replaceProfileBuildResource( Resource resource )
    {
        return resource;
    }

    @Override
    public String replaceProfileBuildResourceExclude(String exclude )
    {
        return exclude;
    }

    @Override
    public String replaceProfileBuildResourceInclude(String include )
    {
        return include;
    }

    @Override
    public Resource replaceProfileBuildTestResource( Resource testResource )
    {
        return testResource;
    }

    @Override
    public String replaceProfileBuildTestResourceExclude(String exclude )
    {
        return exclude;
    }

    @Override
    public String replaceProfileBuildTestResourceInclude(String include )
    {
        return include;
    }

    @Override
    public Dependency replaceProfileDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceProfileDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public DependencyManagement replaceProfileDependencyManagement( DependencyManagement dependencyManagement )
    {
        return dependencyManagement;
    }

    @Override
    public Dependency replaceProfileDependencyManagementDependency( Dependency dependency )
    {
        return dependency;
    }

    @Override
    public Exclusion replaceProfileDependencyManagementDependencyExclusion( Exclusion exclusion )
    {
        return exclusion;
    }

    @Override
    public DistributionManagement replaceProfileDistributionManagement( DistributionManagement distributionManagement )
    {
        return distributionManagement;
    }

    @Override
    public Relocation replaceProfileDistributionManagementRelocation( Relocation relocation )
    {
        return relocation;
    }

    @Override
    public DeploymentRepository replaceProfileDistributionManagementRepository( DeploymentRepository repository )
    {
        return repository;
    }

    @Override
    public RepositoryPolicy replaceProfileDistributionManagementRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceProfileDistributionManagementRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public Site replaceProfileDistributionManagementSite( Site site )
    {
        return site;
    }

    @Override
    public DeploymentRepository replaceProfileDistributionManagementSnapshotRepository( DeploymentRepository snapshotRepository )
    {
        return snapshotRepository;
    }

    @Override
    public RepositoryPolicy replaceProfileDistributionManagementSnapshotRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceProfileDistributionManagementSnapshotRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public String replaceProfileModule(String module )
    {
        return module;
    }

    @Override
    public Repository replaceProfilePluginRepository( Repository pluginRepository )
    {
        return pluginRepository;
    }

    @Override
    public RepositoryPolicy replaceProfilePluginRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceProfilePluginRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public String replaceProfileProperty(String propertyKey, String propertyValue )
    {
        return propertyValue;
    }

    @Override
    public Reporting replaceProfileReporting( Reporting reporting )
    {
        return reporting;
    }

    @Override
    public ReportPlugin replaceProfileReportingPlugin( ReportPlugin plugin )
    {
        return plugin;
    }

    @Override
    public ReportSet replaceProfileReportingPluginReportSet( ReportSet reportSet )
    {
        return reportSet;
    }

    @Override
    public String replaceProfileReportingPluginReportSetReport(String report )
    {
        return report;
    }

    @Override
    public Repository replaceProfileRepository( Repository repository )
    {
        return repository;
    }

    @Override
    public RepositoryPolicy replaceProfileRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceProfileRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public String replaceProperty(String propertyKey, String propertyValue )
    {
        return propertyValue;
    }

    @Override
    public Reporting replaceReporting( Reporting reporting )
    {
        return reporting;
    }

    @Override
    public ReportPlugin replaceReportingPlugin( ReportPlugin plugin )
    {
        return plugin;
    }

    @Override
    public ReportSet replaceReportingPluginReportSet( ReportSet reportSet )
    {
        return reportSet;
    }

    @Override
    public String replaceReportingPluginReportSetReport(String report )
    {
        return report;
    }

    @Override
    public Repository replaceRepository( Repository repository )
    {
        return repository;
    }

    @Override
    public RepositoryPolicy replaceRepositoryRelease( RepositoryPolicy releases )
    {
        return releases;
    }

    @Override
    public RepositoryPolicy replaceRepositorySnapshot( RepositoryPolicy snapshots )
    {
        return snapshots;
    }

    @Override
    public Scm replaceScm( Scm scm )
    {
        return scm;
    }

    @Override
    public void visitBuild( Build build )
    {
    }

    @Override
    public void visitBuildExtension( Extension extension )
    {
    }

    @Override
    public void visitBuildFilter( String filter )
    {
    }

    @Override
    public void visitBuildPlugin( Plugin plugin )
    {
    }

    @Override
    public void visitBuildPluginDependency( Dependency dependency )
    {
    }

    @Override
    public void visitBuildPluginDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitBuildPluginExecution( PluginExecution execution )
    {
    }

    @Override
    public void visitBuildPluginExecutionGoal( String goal )
    {
    }

    @Override
    public void visitBuildPluginManagement( PluginManagement pluginManagement )
    {
    }

    @Override
    public void visitBuildPluginManagementPlugin( Plugin plugin )
    {
    }

    @Override
    public void visitBuildPluginManagementPluginDependency( Dependency dependency )
    {
    }

    @Override
    public void visitBuildPluginManagementPluginDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitBuildPluginManagementPluginExecution( PluginExecution execution )
    {
    }

    @Override
    public void visitBuildPluginManagementPluginExecutionGoal( String goal )
    {
    }

    @Override
    public void visitBuildResource( Resource resource )
    {
    }

    @Override
    public void visitBuildResourceExclude( String exclude )
    {
    }

    @Override
    public void visitBuildResourceInclude( String include )
    {
    }

    @Override
    public void visitBuildTestResource( Resource testResource )
    {
    }

    @Override
    public void visitBuildTestResourceExclude( String exclude )
    {
    }

    @Override
    public void visitBuildTestResourceInclude( String include )
    {
    }

    @Override
    public void visitCiManagement( CiManagement ciManagement )
    {
    }

    @Override
    public void visitCiManagementNotifier( Notifier notifier )
    {
    }

    @Override
    public void visitCiManagementNotifierConfiguration( String configurationElementKey,
                                                        String configurationElementValue )
    {
    }

    @Override
    public void visitContributor( Contributor contributor )
    {
    }

    @Override
    public void visitContributorProperty(String propertyKey, String propertyValue )
    {
    }

    @Override
    public void visitContributorRole( String role )
    {
    }

    @Override
    public void visitDependency( Dependency dependency )
    {
    }

    @Override
    public void visitDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitDependencyManagement( DependencyManagement dependencyManagement )
    {
    }

    @Override
    public void visitDependencyManagementDependency( Dependency dependency )
    {
    }

    @Override
    public void visitDependencyManagementDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitDeveloper( Developer developer )
    {
    }

    @Override
    public void visitDeveloperProperty(String propertyKey, String propertyValue )
    {
    }

    @Override
    public void visitDeveloperRole( String role )
    {
    }

    @Override
    public void visitDistributionManagement( DistributionManagement distributionManagement )
    {
    }

    @Override
    public void visitDistributionManagementRelocation( Relocation relocation )
    {
    }

    @Override
    public void visitDistributionManagementRepository( DeploymentRepository repository )
    {
    }

    @Override
    public void visitDistributionManagementRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitDistributionManagementRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitDistributionManagementSite( Site site )
    {
    }

    @Override
    public void visitDistributionManagementSnapshotRepository( DeploymentRepository snapshotRepository )
    {
    }

    @Override
    public void visitDistributionManagementSnapshotRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitDistributionManagementSnapshotRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitIssueManagement( IssueManagement issueManagement )
    {
    }

    @Override
    public void visitLicense( License license )
    {
    }

    @Override
    public void visitMailingList( MailingList mailingList )
    {
    }

    @Override
    public void visitMailingListOtherArchive( String otherArchive )
    {
    }

    @Override
    public void visitModule( String module )
    {
    }

    @Override
    public void visitOrganization( Organization organization )
    {
    }

    @Override
    public void visitParent( Parent parent )
    {
    }

    @Override
    public void visitPluginRepository( Repository pluginRepository )
    {
    }

    @Override
    public void visitPluginRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitPluginRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitPrerequisite( Prerequisites prerequisites )
    {
    }

    @Override
    public void visitProfile( Profile profile )
    {
    }

    @Override
    public void visitProfileActivation( Activation activation )
    {
    }

    @Override
    public void visitProfileActivationFile( ActivationFile file )
    {
    }

    @Override
    public void visitProfileActivationO( ActivationOS os )
    {
    }

    @Override
    public void visitProfileActivationProperty( ActivationProperty property )
    {
    }

    @Override
    public void visitProfileBuild( BuildBase build )
    {
    }

    @Override
    public void visitProfileBuildFilter( String filter )
    {
    }

    @Override
    public void visitProfileBuildPlugin( Plugin plugin )
    {
    }

    @Override
    public void visitProfileBuildPluginDependency( Dependency dependency )
    {
    }

    @Override
    public void visitProfileBuildPluginDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitProfileBuildPluginExecution( PluginExecution execution )
    {
    }

    @Override
    public void visitProfileBuildPluginExecutionGoal( String goal )
    {
    }

    @Override
    public void visitProfileBuildPluginManagement( PluginManagement pluginManagement )
    {
    }

    @Override
    public void visitProfileBuildPluginManagementPlugin( Plugin plugin )
    {
    }

    @Override
    public void visitProfileBuildPluginManagementPluginDependency( Dependency dependency )
    {
    }

    @Override
    public void visitProfileBuildPluginManagementPluginDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitProfileBuildPluginManagementPluginExecution( PluginExecution execution )
    {
    }

    @Override
    public void visitProfileBuildPluginManagementPluginExecutionGoal( String goal )
    {
    }

    @Override
    public void visitProfileBuildResource( Resource resource )
    {
    }

    @Override
    public void visitProfileBuildResourceExclude( String exclude )
    {
    }

    @Override
    public void visitProfileBuildResourceInclude( String include )
    {
    }

    @Override
    public void visitProfileBuildTestResource( Resource testResource )
    {
    }

    @Override
    public void visitProfileBuildTestResourceExclude( String exclude )
    {
    }

    @Override
    public void visitProfileBuildTestResourceInclude( String include )
    {
    }

    @Override
    public void visitProfileDependency( Dependency dependency )
    {
    }

    @Override
    public void visitProfileDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitProfileDependencyManagement( DependencyManagement dependencyManagement )
    {
    }

    @Override
    public void visitProfileDependencyManagementDependency( Dependency dependency )
    {
    }

    @Override
    public void visitProfileDependencyManagementDependencyExclusion( Exclusion exclusion )
    {
    }

    @Override
    public void visitProfileDistributionManagement( DistributionManagement distributionManagement )
    {
    }

    @Override
    public void visitProfileDistributionManagementRelocation( Relocation relocation )
    {
    }

    @Override
    public void visitProfileDistributionManagementRepository( DeploymentRepository repository )
    {
    }

    @Override
    public void visitProfileDistributionManagementRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitProfileDistributionManagementRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitProfileDistributionManagementSite( Site site )
    {
    }

    @Override
    public void visitProfileDistributionManagementSnapshotRepository( DeploymentRepository snapshotRepository )
    {
    }

    @Override
    public void visitProfileDistributionManagementSnapshotRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitProfileDistributionManagementSnapshotRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitProfileModule( String module )
    {
    }

    @Override
    public void visitProfilePluginRepository( Repository pluginRepository )
    {
    }

    @Override
    public void visitProfilePluginRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitProfilePluginRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitProfileProperty(String propertyKey, String propertyValue )
    {
    }

    @Override
    public void visitProfileReporting( Reporting reporting )
    {
    }

    @Override
    public void visitProfileReportingPlugin( ReportPlugin plugin )
    {
    }

    @Override
    public void visitProfileReportingPluginReportSet( ReportSet reportSet )
    {
    }

    @Override
    public void visitProfileReportingPluginReportSetReport( String report )
    {
    }

    @Override
    public void visitProfileRepository( Repository repository )
    {
    }

    @Override
    public void visitProfileRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitProfileRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitProject( Model model )
    {
    }

    @Override
    public void visitProperty(String propertyKey, String propertyValue )
    {
    }

    @Override
    public void visitReporting( Reporting reporting )
    {
    }

    @Override
    public void visitReportingPlugin( ReportPlugin plugin )
    {
    }

    @Override
    public void visitReportingPluginReportSet( ReportSet reportSet )
    {
    }

    @Override
    public void visitReportingPluginReportSetReport( String report )
    {
    }

    @Override
    public void visitRepository( Repository repository )
    {
    }

    @Override
    public void visitRepositoryRelease( RepositoryPolicy releases )
    {
    }

    @Override
    public void visitRepositorySnapshot( RepositoryPolicy snapshots )
    {
    }

    @Override
    public void visitScm( Scm scm )
    {
    }
}
