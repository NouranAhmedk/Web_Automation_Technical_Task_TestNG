// Declarative Pipeline for Web_Automation_Technical_Task_TestNG
// Maven + TestNG + Selenium + Allure
pipeline {
    agent any

    parameters {
        // Switch between the two TestNG suites defined in pom.xml profiles.
        choice(name: 'SUITE', choices: ['smoke', 'regression'], description: 'Which TestNG suite to run')
    }

    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }

    stages {
        stage('Checkout') {
            steps {
                deleteDir() // start from a clean workspace so no stale project is built
                git url: 'https://github.com/NouranAhmedk/Web_Automation_Technical_Task_TestNG.git',
                    branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                // Run the selected suite. isUnix() picks the right shell so it works on
                // both Windows and Linux agents.
                script {
                    def mvn = "mvn clean test -P ${params.SUITE} -Dmaven.test.failure.ignore=true"
                    if (isUnix()) {
                        sh mvn
                    } else {
                        bat mvn
                    }
                }
            }
        }
    }

    post {
        always {
            // Publish TestNG results (Surefire writes JUnit-compatible XML).
            junit '**/target/surefire-reports/**/TEST-*.xml'

            // Allure report (requires the "Allure" Jenkins plugin).
            allure includeProperties: false, results: [[path: 'allure-results']]

            // Keep failure/pass screenshots as build artifacts.
            archiveArtifacts artifacts: 'Screenshots/**', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed — check the test report and screenshots.'
        }
    }
}
