pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh 'cd mini-apps-employee'
                sh 'mvn test'
            }
        }
    }
}