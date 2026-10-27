# Table of Contents

- [Basic Source Control / Git Operations](#basic-source-control--git-operations)
  - [Git](#git)
    - [git init](#git-init)
    - [git add](#git-add)
    - [git commit](#git-commit)
      - [Git Staging Directory (Index)](#git-staging-directory-index)
    - [git status](#git-status)
    - [git config](#git-config)
    - [git remote](#git-remote)
    - [git clone](#git-clone)
    - [git fetch](#git-fetch)
    - [git pull](#git-pull)
    - [git push](#git-push)
    - [git stash](#git-stash)
      - [Store current work with untracked files](#store-current-work-with-untracked-files)
      - [Bring stashed work back to the working directory](#bring-stashed-work-back-to-the-working-directory)
    - [git revert](#git-revert)
    - [git log](#git-log)
  - [Source Control Branching](#source-control-branching)
    - [git branch](#git-branch)
    - [git checkout](#git-checkout)
    - [git merge](#git-merge)
    - [git rebase](#git-rebase)
    - [Git: Merge vs Rebase](#git-merge-vs-rebase)
      - [Merge:](#merge)
      - [Rebase:](#rebase)
      - [git rebase -i](#git-rebase--i)
    - [git reset question](#git-reset-question)
    - [Create a Branch](#create-a-branch)
    - [git switch](#git-switch)
    - [git checkout:](#git-checkout)
    - ["Cherry-picking Does Not Maintain the Connection"](#cherry-picking-does-not-maintain-the-connection)
  - [Source Control Branching Strategies](#source-control-branching-strategies)
    - [Git Flow](#git-flow)
    - [GitHub Flow](#github-flow)
    - [Feature Branching](#feature-branching)
  - [Creating build and release piplines (Jenkins / GitLab CI / GitHub Actions)](#creating-build-and-release-piplines-jenkins--gitlab-ci--github-actions)
    - [What is a Build and Release Pipeline?](#what-is-a-build-and-release-pipeline)
    - [Creating Pipelines in Jenkins](#creating-pipelines-in-jenkins)
      - [What is Jenkins CI/CD Pipeline?](#what-is-jenkins-cicd-pipeline)
    - [Creating Pipelines in GitLab CI](#creating-pipelines-in-gitlab-ci)
      - [Primary Terminologies](#primary-terminologies)
    - [Creating Pipelines in GitHub Actions](#creating-pipelines-in-github-actions)
      - [Actions](#actions)
      - [Runners](#runners)
    - [GitHub Actions Features:](#github-actions-features)
  - [GitHub, GitLab, and Jenkins](#github-gitlab-and-jenkins)


#  Basic Source Control / Git Operations
## Git
Git is a distributed version control system widely used for tracking changes in code during software development. 

### git init
- The command git init is used to create an empty Git repository. 
- After the git init command is used, a .git folder is created in the directory with some subdirectories.

### git add
- Add command is used after checking the status of the files, to add those files to the staging area.
- Before running the **commit** command, "git add" is used to add any new or modified files.
- Moves changes from the **working** directory to the **staging** area. This gives you the opportunity to prepare a snapshot before committing it to the official history.

### git commit
- The commit command makes sure that the changes are saved to the local repository.
- The command `git commit –m <message>` allows you to describe everyone and help them understand what has happened.

#### Git Staging Directory (Index)
When working with Git, the staging area (also called the index) is a space where changes to files are prepared before they are committed to the repository. 
- Untracked/Modified Files: When you modify files or create new ones in your working directory, Git is aware of the changes but doesn't immediately include them in any commits.
- Staging Changes: To include specific changes in your next commit, you need to move them into the staging area using the git add command. The staging area acts like a preview of what will be committed.
- Commit: Once you’re satisfied with the changes you've staged, you can use git commit to save them to the Git repository.

### git status
- The git status command tells the current state of the repository.
- The command provides the **current working branch**. If the files are in the staging area, but not committed, it will be shown by the git status. Also, if there are no changes, it will show the message no changes to commit, working directory clean.

### git config
- The git config command is used **initially to configure** the user.name and user.email. This specifies what email id and username will be used from a local repository.
- When git config is used with --global flag, it writes the settings to all repositories on the computer.

### git remote 
- The git remote command is used to create, view, and delete connections to other repositories. 
- The connections here are not like direct links into other repositories, but as **bookmarks** that serve as convenient names to be used as a reference.
`git remote add origin <address>`

### git clone
- The git clone command is used to create a local working copy of an existing remote repository.
- The command downloads the remote repository to the computer. It is equivalent to the Git init command when working with a remote repository.
`git clone <remote_URL>`

### git fetch
- Fetching downloads a branch from another repository, along with all of its associated commits and files. But, it doesn't try to integrate anything into your local repository. This gives you a chance to **inspect** changes **before merging them** with your project.
- git pull combines git fetch and git merge in one step. It fetches changes from the remote and immediately merges them into your current branch.

Fetch Workflow:
```plaintext
   Remote Repo:   A---B---C---D
   Local Repo:    A---B
```
After Fetch:
```
  Local Repo:    A---B  (origin/main -> C---D)
```
### git pull 
- The git pull command is used to **fetch** and **merge** changes from the remote repository to the local repository.
- The command "git pull origin master" copies all the files from the master branch of the remote repository to the local repository.
`git pull <branch_name> <remote URL>`


- Quick and easy way to bring your branch up-to-date with the remote.
- One-step process.
- Can result in conflicts or unexpected changes if you haven’t reviewed the fetched commits.
- Less **control** compared to fetch and manual merging.
Pull Workflow:
```plaintext
   Remote Repo:   A---B---C---D
   Local Repo:    A---B
```
After Pull:
``` 
   Local Repo:    A---B---C---D
```

### git push
- The command git push is used to **transfer** the commits or **pushing** the content from the local repository to the remote repository.
- The command is used after a local repository has been modified, and the modifications are to be shared with the remote team members.
`git push -u origin master`

### git stash
- The git stash command takes your modified tracked files and saves it on a **pile of incomplete changes** that you can reapply at any time. To go back to work, you can use the stash pop.
- The git stash command will help a developer switch branches to work on something else without committing to incomplete work.
#### Store current work with untracked files
  `git stash -u`

#### Bring stashed work back to the working directory
  `git stash pop`

### git revert
- Undoes a committed snapshot. When you discover a faulty commit, reverting is a safe and easy way to completely remove it from the code base.

### git log
- The git log command shows the **order of the commit history** for a repository.
- The command helps in understanding the state of the current branch by showing the commits that lead to this state.


## Source Control Branching

### git branch
- The git branch command is used to **determine** what branch the local repository is on.
- The command enables adding and deleting a branch.

### git checkout
- The git checkout command is used to switch branches, whenever the work is to be started on a different branch.
- The command works on three separate entities: files, commits, and branches.

### git merge
- The git merge command is used to **integrate** the branches together. The command combines the changes from one branch to another branch. 
- It is used to merge the changes in the staging branch to the stable branch.

### git rebase
- Rebasing lets you move branches around, which helps you avoid unnecessary merge commits. The resulting linear history is often much easier to understand and explore.


### Git: Merge vs Rebase
Consider what happens when you start working on a new feature in a dedicated branch, then another team member updates the main branch with new commits. This results in a forked history, which should be familiar to anyone who has used Git as a collaboration tool.
```plaintext
main:   A---B---C---D
               \
feature:        E---F
```

#### Merge:
Merging is a way to combine changes from two branches. It creates a new commit that ties both histories together.

Workflow:
- Start with feature branch and main branch.
- You finish working on feature and want to integrate it into main.
- Use git merge feature while on main, if you want to incorporate your feature commits into main branch.
  -  `git checkout main`
  -  `git merge main feature`
- This creates a merge commit, preserving the history of both branches.

```plaintext
main:   A---B---C---D---M
               \       /
feature:        E---F
```
- Merging is nice because it’s a **non-destructive** operation. The existing branches are not changed in any way. This avoids all of the potential pitfalls of rebasing
- Maintains a **complete** history.
- Simple, **straightforward**.
- Useful for tracking how and when features were integrated.

- Can create messy histories with many merge commits.
  
####  Rebase:
Rebasing moves or “rebases” commits from one branch to another, applying them one by one to a new base.

Workflow:
- Start with feature branch and main branch.
- Instead of merging, rebase feature on top of main using git rebase main while on feature.
  - `git checkout feature`
  - `git rebase main`
This rewrites the history of feature to appear as if it branched from the latest commit on main.

```
main:   A---B---C---D
feature:   A---B---C---D---E'---F'
```
- The major benefit of rebasing is that you get a much cleaner project history.
- Creates a **cleaner** history, as no merge commits are added.
- Useful for keeping **linear** history.
- Can be risky when used on shared branches, as it rewrites history.
- If not done carefully, it can lead to lost commits.

#### git rebase -i
- The -i flag is used to begin an interactive rebasing session. This provides all the benefits of a normal rebase, but gives you the opportunity to **add, edit, or delete** commits along the way.

### git reset question
- Undoes changes to files in the working directory. Resetting lets you clean up or completely remove changes that **have not been pushed** to a public repository.
- Branching is a critical feature of Git, allowing multiple versions of a project to be developed simultaneously.

### Create a Branch
Create a new branch: To create a new branch in Git, you can use the git branch command.
`git branch <branch-name>`

- This will create a new branch but will not switch you to it.
- Create and switch to a new branch: You can create a branch and switch to it in one step by using the git checkout or git switch command.
`git checkout -b <branch-name>
- This creates a new branch and switches to it.
- Branching allows you to create a separate line of development, isolated from the main codebase.

### git switch
Switch to an existing branch
```
git switch <branch-name>
```

If you want to create a new branch and switch to it:
```
git switch -c <branch-name>
```
To quickly switch back to the previous branch you were on, you can use:
```
git switch -
```
- Does not modify files or change paths.
- The git switch command lets you navigate between branches without affecting the working directory.
- The working directory in Git refers to the local files and folders on your system that reflect the current state of a project.


### git checkout:

- Used for both switching branches and checking out files from the working directory.
- Can be error-prone as it mixes different functionalities.
```
git checkout <branch> – Switch to a branch.
git checkout <file> – Checkout specific files from the index.
```
Key Difference:
- git switch is a focused command introduced to simplify branch switching.
- git checkout is more general-purpose, handling both branch switching and file restoration, but can be more complex and less safe to use for beginners.

### "Cherry-picking Does Not Maintain the Connection"
- Cherry-picking involves applying specific commits from one branch to another. While this brings person's commits onto main, it doesn't retain the original history and context of those commits (like the fact that they were developed on a separate feature branch and possibly dependent on other changes).

- If Person's cherry-picks commits F and G from his branch onto main, these commits will be added to main, but they will lack the original context of where they came from (i.e., Person's branch). They will appear as new, standalone commits in the history of main without any indication of the feature branch or the original merge commit.

- Rebasing rewrites history but keeps the commits cleaner, without merge commits.
- Merging keeps the history as-is, including the merge commits.
- Cherry-picking is a more manual approach to applying specific changes but can result in loss of context and history.

When you rebase, Git does not literally move or modify existing commits. Instead, it creates new commits based on the changes in your original commits, but these new commits are placed on top of the target branch (in your case, the updated main branch).
For example, if you have a branch with two commits (F and G), and then you rebase those commits onto the latest main branch, Git will:
- Start from the current main branch.
- Take the changes introduced by F and G.
- Apply those changes as new commits on top of main.
- Even though the content of the commits (F and G) remains the same, their commit IDs (hashes) and timestamps will change, because they are now new commits that Git considers as "rebased."


## Source Control Branching Strategies
Branching strategy determines how team approaches code branching. There are 2 different branching patterns: long-lived and short-lived.
- Long-lived branches are used for big, complex projects where teams work on features separately for a longer time, often weeks or more. This approach is good for feature isolation, where each feature is developed independently without frequent integration.
- Short-lived branches are used for smaller, quicker features that need to be integrated within a few days. This approach fits well with continuous integration, where developers regularly merge updates to keep the codebase up to date and avoid long delays between integrations.



### Git Flow
Git Flow is a robust branching strategy, ideal for projects with a well-defined release cycle. It was designed by Vincent Driessen and has separate branches for different stages of development.

Key Branches in Git Flow:
- Main Branch (main or master): This is the production branch. The code here should always be deployable.
- Develop Branch (develop): This is the integration branch where features are merged. It reflects the latest work ready for testing.
- Feature Branches: Each new feature is developed in its own branch, usually created off develop.
- Release Branches: Once the develop branch has enough features for a release, a release branch is created. Final changes, like bug fixes or minor improvements, are made here before merging into main and develop.
- Hotfix Branches: If a critical bug(small to be called hot fix) is found in production, a hotfix branch is created from main, fixed, and merged back into both main and develop.

Workflow:
- Start from develop to create a feature branch.
- Once the feature is complete, merge it back into develop.
- When develop is ready for release, create a release branch.
- After final testing, the release branch is merged into both main and develop.
- For hotfixes, create a hotfix branch from main, fix the issue, and merge it into main and develop.

Diagram:

```plaintext
main:        A---B---------------G---H
               \             /
release:       C-------------/ 
               \
develop:        D---E---F-----------/
                   \        / 
feature-1:          X---Y
feature-2:              Z---W
```
In Git Flow, bug fixes are typically handled in the following ways:
- If the bug is found during active development: The bug fix is merged into the develop branch, as this branch is where new features and fixes are integrated before a release.
- If the bug is found during a release preparation: The bug fix is merged into the release branch directly. After the release is finalized, the release branch (with the bug fix) is merged back into both the develop and main branches.

- Advantages:
  - Clear separation of stable production code and ongoing development.
  - Well-suited for large projects with scheduled releases.
  - Allows for simultaneous development of features and bug fixes.

- Disadvantages:
  - Complex to manage, especially for smaller teams or continuous delivery setups.
  - Can result in a lot of branches.

### GitHub Flow
GitHub Flow is a simpler branching strategy designed for continuous integration and continuous delivery (CI/CD). It works well for smaller projects or teams where code is deployed frequently (e.g., multiple times a day).

Key Principles:
- Main Branch (main): The main branch always holds the production-ready code.
- Feature Branches: New features or fixes are developed in feature branches, created off main.
- Pull Requests (PRs): Once the work in a feature branch is ready, a pull request is made to merge the branch back into main.
- Deployment: After a successful code review, the feature is merged into main and immediately deployable.

Workflow:
- Create a feature branch from main.
- Develop the feature.
- Open a pull request for the feature branch to main.
- After review and approval, merge the feature branch into main.
- Optionally deploy the code after merging.

```plaintext
main:        A---B---C---D---E
                \       \    \
feature-1:       X-------/    
feature-2:               Y----Z
```

- Advantages:
  - Simpler than Git Flow.
  - Encourages frequent, smaller deployments.
  - Works well with CI/CD.

- Disadvantages:
  - Not ideal for projects with complex release management or multiple environments.
  - Can lead to more frequent merge conflicts, especially with larger teams.


### Feature Branching
Feature Branching is a strategy where each new feature or bug fix is developed in its own branch. This branch is only merged into the main branch when the feature is fully complete and tested. It can be used as part of both Git Flow and GitHub Flow strategies.

Key Concepts:
- Feature Branches: Branches created for developing new features or fixing bugs.
- Main or Develop Branch: A stable branch where feature branches are merged after development and **testing**.
- Pull Requests: Commonly used for code reviews and discussion before merging into the main branch.

Workflow:
- Create a feature branch from the main or develop branch.
- Develop the feature on the feature branch.
- When the feature is complete, create a pull request to merge the feature branch into the main or develop branch.
- Merge the feature branch after review and testing.

```plaintext
main:        A---B---C---D
              \
feature-1:     X---Y---Z
```
- Advantages:
  - Isolated development prevents unstable code from affecting the main branch.
  - Encourages clear and manageable feature development.

- Disadvantages:
  - Can result in long-lived feature branches if features take too long to complete.
  - If branches diverge too much, merging can become complicated.


## Creating build and release piplines (Jenkins / GitLab CI / GitHub Actions)

### What is a Build and Release Pipeline?
A build pipeline automates the steps required to compile, test, and package code into a deployable artifact. A release pipeline is the process of deploying this artifact into different environments (development, QA, production, etc.). These pipelines are essential for Continuous Integration (CI) and Continuous Delivery (CD), ensuring that every change is automatically built, tested, and delivered to production.

- Continuous Integration (CI): Developers frequently integrate code into a shared repository, and automated tests run to detect errors early.
- Continuous Delivery (CD): Code is automatically deployed to production after it passes all tests.
- Stages: Each pipeline consists of multiple stages like build, test, package, and deploy.
- Jobs: A job is a set of tasks within a stage that the pipeline executes.
- Triggers: Pipelines can be triggered by events like code commits, pull requests, or scheduled times.

### Creating Pipelines in Jenkins
- Jenkins is a tool that is used for automation. It is mainly an open-source server that allows all the developers to build, test and deploy software. It is written in Java and runs on java only. By using Jenkins we can make a continuous integration of projects(jobs) or end-to-endpoint automation. 

- Jenkins facilitates the automation of several stages of the software development lifecycle, including application development, testing, and deployment. Operating within servlet containers like Apache Tomcat, the technology is server-based. Continuous delivery (CD) and integration (CI) pipelines can be created and managed with Jenkins. The **development, testing, and deployment** of software applications are automated using CI/CD pipelines. You will be able to release software more regularly and with fewer problems if you do this.

#### What is Jenkins CI/CD Pipeline?
1. Test code
2. Build Application
3. Push Repository
4. Deploy to Server

- Master-Slave Architecture: Jenkins has a master node (which controls job execution) and one or more slave nodes (which perform the jobs).
- Jenkinsfile: Defines the CI/CD pipeline as code and contains the stages and steps.

```groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                sh 'scp target/*.jar user@server:/app'
            }
        }
    }
}
```
- Steps Breakdown:
  - Agent: Specifies where the pipeline will run (on any available agent).
  - Stages: Defines steps for building, testing, and deploying the app.
  - Deploy: Uses scp to copy the build artifact to a server.

- Jenkins Features:
  - Plugins: Jenkins has a **rich ecosystem of plugins** for integrating with other tools (Docker, Kubernetes, etc.).
  - Declarative Pipeline: Jenkinsfile is written using **declarative syntax** for better readability.
  - Visualization: Jenkins provides a **graphical view** of pipeline execution and logs.

### Creating Pipelines in GitLab CI
GitLab arises as a complete arrangement that coordinates version control, issue tracking, continuous integration/continuous deployment (CI/Cd), and collaboration tools into a single platform, empowering teams to deal with their whole DevOps lifecycle seamlessly.

GitLab isn’t simply a Git repository manager; it’s a complete DevOps platform that enables development teams to cooperate productively, automate repetitive tasks, and deliver software quicker and with better quality, whether you’re a little startup, an enormous enterprise, or an open-source project, GitLab gives the tools and infrastructure expected to deal with the start to finish software development process really.

- GitLab CI uses a YAML configuration file (.gitlab-ci.yml) stored in the repository, defining the stages and jobs.
- Runners: GitLab CI executes jobs using runners, which can be shared or project-specific.

#### Primary Terminologies
- Issue Tracking: GitLab incorporates a **built-in issue global positioning system** that empowers groups to create, assign, prioritize, and track issues, bugs, feature requests, and different tasks related to a task. This component works with compelling correspondence and cooperation among colleagues.
- Wiki: GitLab gives a wiki feature where teams can record project-related data, rules, strategies, and other significant documentation, wikis act as a concentrated information base for project-related documentation, open to all colleagues.
- GitLab **Runners**: are agents responsible for executing CI/CD jobs characterized in pipelines. Runners can be divided between tasks or well-defined for an undertaking and can run positions on different stages and conditions, like Linux, Windows, macOS, and Docker containers.
- Groups and Projects: GitLab arranges vaults into groups and projects, allowing teams to manage access control and permissions at various levels. Groups can contain various projects, working with collaboration and resource dividing between related projects inside an organization or group.


```yaml
stages:
  - build
  - test
  - deploy

build_job:
  stage: build
  script:
    - echo "Building the project"
    - mvn clean install

test_job:
  stage: test
  script:
    - echo "Running tests"
    - mvn test

deploy_job:
  stage: deploy
  script:
    - echo "Deploying to production"
    - scp target/*.jar user@server:/app
  only:
    - master
```
- Steps Breakdown:
  - Stages: build, test, and deploy define the pipeline's sequence.
  - Jobs: Each stage has a job (build_job, test_job, deploy_job), which includes a script to run.
  - Only: only: master ensures that deployment happens only on the master branch.

- GitLab CI Features:
  - Parallel Execution: Jobs can run in **parallel**, speeding up the pipeline.
  - **Cache** & Artifacts: Caches are used to save dependencies, and artifacts are used to pass build outputs between stages.
  - Auto DevOps: GitLab provides **built-in automation** to build, test, and deploy apps based on your project’s stack.

### Creating Pipelines in GitHub Actions
GitHub Actions is a CI/CD (Continuous Integration/ Continuous Deployment) platform for automating the builds, test, and deployment process. Using GitHub actions, we can build and test every pull request in the repository using workflows, or push the merged pull requests to production with workflows. GitHub Actions allows you to conduct processes in response to the events in your repository. For example, anytime someone files a new issue in your repository, you may execute a process to automatically add the required labels or if someone sends a pull request to your repository, then the automated workflows built by you can check if the pull request is eligible for merging into the main code or not. 


- GitHub Actions uses workflows defined in .github/workflows/ directory. A workflow is triggered by events like pull requests or push events.
- Runners: Workflows run on GitHub-hosted or self-hosted runners.

```yaml
name: CI/CD Pipeline

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v2
      - name: Set up Java
        uses: actions/setup-java@v1
        with:
          java-version: '11'
      - name: Build with Maven
        run: mvn clean install

  test:
    runs-on: ubuntu-latest
    needs: build
    steps:
      - name: Run unit tests
        run: mvn test

  deploy:
    runs-on: ubuntu-latest
    needs: test
    steps:
      - name: Deploy to production
        run: scp target/*.jar user@server:/app
```
- Steps Breakdown:
  - on: push triggers the pipeline when code is pushed to the main branch.
  - jobs: build, test, and deploy represent different jobs.
  - needs: Specifies job dependencies, ensuring deploy runs only after test is successful.

#### Actions
An action is a reusable piece of code or script that performs a specific task within a GitHub Actions workflow. Actions can handle common tasks like building, testing, or deploying code.

- Purpose: They help reduce code duplication by allowing you to encapsulate commonly performed operations. Instead of writing the same code repeatedly in your workflows, you can call an action to perform that task.

- Examples:
  - Grabbing the repository code from GitHub.
  - Setting up the build environment (e.g., installing dependencies).
  - Configuring cloud provider credentials for deployment.
```yaml
name: CI

on:
  push:
    branches:
      - main

jobs:
  greet:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Run Hello Action
        uses: ./.github/actions/hello-action  # Path to the action
        with:
          user: 'GitHub User'  # Passing input to the action
```

#### Runners
Runners are the servers or virtual machines that execute the jobs defined in your GitHub Actions workflows. Each workflow run is processed by a runner.
- Execution: When a workflow is triggered, a runner runs the job defined in the workflow, executing the steps in sequence. Each runner can handle only one job at a time.
- Types:
  - Hosted Runners: GitHub provides hosted runners that come preconfigured with popular operating systems (Ubuntu Linux, Windows, macOS). Each job runs in a fresh virtual machine.
  - Self-Hosted Runners: Users can set up their own runners to meet specific needs, such as using a different operating system or hardware configuration.

### GitHub Actions Features:
- **Reusable** Workflows: You can define reusable workflows and call them in different repositories.
- Marketplace Actions: You can use pre-built actions from the GitHub Marketplace.
- Integration with GitHub: Tight integration with GitHub repositories makes GitHub Actions convenient for CI/CD.

## GitHub, GitLab, and Jenkins
| Feature                              | GitHub                                    | GitLab                                    | Jenkins                                   |
|--------------------------------------|-------------------------------------------|-------------------------------------------|-------------------------------------------|
| **Primary Purpose**                  | Source code hosting, collaboration, and CI/CD | Source code hosting, collaboration, and CI/CD | CI/CD and automation server                |
| **CI/CD Support**                    | Built-in GitHub Actions                   | Built-in GitLab CI/CD                      | Supports CI/CD with extensive plugins      |
| **Source Code Management**           | Yes, with Git and GitHub repositories     | Yes, with Git and GitLab repositories     | No, relies on integration with Git servers |
| **Runner/Agent Configuration**       | GitHub-hosted or self-hosted runners      | GitLab-hosted or self-hosted runners      | Self-hosted agents (nodes) required        |
| **Built-in Issue Tracking**          | Yes, GitHub Issues                        | Yes, GitLab Issues                        | No, requires integration with external tools |
| **Container Registry**               | GitHub Packages                           | Built-in Docker container registry        | Not built-in, requires plugins             |
| **Security Features**                | Code scanning, secret scanning, dependabot | SAST, DAST, secret detection, dependency scanning | Varies by plugins used                    |
| **Pipeline as Code**                 | Supports YAML-based workflows (GitHub Actions) | Supports YAML-based `.gitlab-ci.yml`      | Supports declarative and scripted pipelines (Jenkinsfile) |
| **Extensibility**                    | GitHub Marketplace for Actions            | GitLab integrations and custom scripts    | Extensive plugin ecosystem                 |
| **Open Source Availability**         | Proprietary, but public repositories are free | Open source Community Edition available   | Open source                               |
| **Self-Hosting**                     | GitHub Enterprise                         | GitLab Community and Enterprise Editions  | Yes, fully self-hosted                    |
| **Ease of Setup**                    | Easy, minimal configuration for GitHub Actions | Easy with GitLab’s built-in CI/CD        | Requires manual setup and configuration   |
| **Community and Support**            | Large community, extensive documentation  | Large community, extensive documentation  | Large community, extensive plugin support  |
| **User Interface**                   | Modern, user-friendly                     | Modern, user-friendly                     | Less modern, may require customization    |
