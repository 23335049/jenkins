pipeline {
    agent any
    stages {
        stage('print build id') {
            steps {
                echo "${env.JENKINS_URL}"
            }
        }
    }
}