pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: 'xxxxx', description: 'pkg version')
        choice(name: 'ARCH', choices: ['X86', 'ARM'], description: 'CPU ARCH')
        choice(name: 'MODE', choices: ['SINGLE', 'CLUSTER'], description: 'HOST MODE')
    }
    stages {
        stage("upload install pkg") {
            steps {
                sleep 5
                echo "upload ${VERSION}: ${ARCH}_${MODE} pkg success"
            }
        }
        stage("uninstall") {
            steps {
                sleep 5
                echo "uninstall before pkg success"
            }
        }
        stage("install") {
            steps {
                sleep 5
                echo "install ${VERSION}: ${ARCH}_${MODE} pkg success"
            }
        }
    }
}