pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh 'ls'
                // sh 'cd mini-apps-employee'
                sh 'mvn test'
            }
        }
    }
}