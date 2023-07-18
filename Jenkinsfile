pipeline {
    agent any

    parameters {
        string defaultValue: 'main', name: 'BRANCH', trim: true
        string defaultValue: 'https://github.com/ajjankowski/BDD-Selenium-Cucumber.git', name: 'GITURL', trim: true
    }

    stages {
        stage('Git checkout') {
            steps {
                git branch: '${BRANCH}', url: '${GITURL}'
                echo "Repository checked on ${BRANCH} branch from ${GITURL}"
            }
        }
        stage('Run tests') {
            steps {
                echo 'Running tests stage'
                script {
                    try {
                    bat "mvn clean test"
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        echo 'Test execution failed but continuing to next stage'
                    }
                }
                echo 'Tests completed'
            }
        }
        stage('Build report') {
            steps {
                echo 'Building report'
                cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                echo "Report build"
            }
        }
    }
}
