pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/danieloliveiraqa/javaSeleniumCucumberJunitWeb.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
