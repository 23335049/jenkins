pipeline {
    agent any
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
                        values 'X86', 'ARM', 'VM-X86'
                    }
                    axis {
                        name 'SCENE'
                        values 'INSTALL', 'UPGRADE'
                    }
                    axis {
                        name 'MODE'
                        values 'SINGLE', 'CLUSTER'
                    }
                }
                stages {
                    stage("${SCENE}") {
                        steps {
                            sleep 5
                            echo "done"
                        }
                    }
                }
            }
        }
    }
}