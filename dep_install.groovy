pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: 'xxxxx', description: '版本')
        choice(name: 'ARCH', choices: ['X86', 'ARM'], description: 'CPU架构')
        choice(name: 'MODE', choices: ['SINGLE', 'CLUSTER'], description: '组网模式')
    }
    stages {
        stages {
            stage("upload install pkg") {
                steps {
                    sleep 5
                    echo "done"
                }
            }
            stage("uninstall") {
                steps {
                    sleep 5
                    echo "done"
                }
            }
            stage("install") {
                steps {
                    sleep 5
                    echo "done"
                }
            }
        }
    }
}