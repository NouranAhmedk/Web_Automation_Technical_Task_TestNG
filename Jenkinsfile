// Declarative Pipeline
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/NouranAhmedk/Web_Automation_Technical_Task_TestNG.git'

                // run only ONE — pick by OS
                bat 'mvn test -P smoke'      // Windows
                // sh 'mvn test -P smoke'    // Linux/Mac
            }
        }
    }
    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}
