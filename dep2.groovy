pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: 'C000X000B027', description: 'pkg version')
    }
    stages {
        stage('Sync CI script') {
            steps {
                sleep 5
                echo "done"
            }
        }
        stage('Down pkg') {
            steps {
                sleep 5
                echo "done"
            }
        }
        stage("Cases") {
            matrix {
                axes {
                    axis {
                        name 'ARCH'
                        values 'X86', 'ARM'
                    }
                    axis {
                        name 'SCENE'
                        values 'install', 'upgrade'
                    }
                    axis {
                        name 'MODE'
                        values 'SINGLE', 'CLUSTER'
                    }
                }
                stages {
                    stage("CALL") {
                        steps {
                            script {
                                stage("${SCENE}_${ARCH}_${MODE}") {
                                    build job: "dep_${SCENE}", parameters: [
                                            string(name: 'VERSION', value: "${VERSION}"),
                                            string(name: 'ARCH', value: "${ARCH}"),
                                            string(name: 'MODE', value: "${MODE}")
                                    ]
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}