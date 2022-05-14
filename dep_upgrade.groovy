pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: 'xxxxx', description: 'pkg version')
        choice(name: 'ARCH', choices: ['X86', 'ARM'], description: 'CPU ARCH')
        choice(name: 'MODE', choices: ['SINGLE', 'CLUSTER'], description: 'HOST MODE')
    }
    stages {
        stage("upload upgrade pkg") {
            steps {
                sleep 5
                echo "upload ${VERSION}: ${ARCH}_${MODE} pkg success"
            }
        }
        stage("rollback") {
            steps {
                sleep 5
                echo "rollback before pkg success"
            }
        }
        stage("backup") {
            steps {
                sleep 5
                echo "backup before pkg success"
            }
        }
        stage("upgrade") {
            steps {
                sleep 5
                echo "upgrade ${VERSION}: ${ARCH}_${MODE} pkg success"
            }
        }
    }
}