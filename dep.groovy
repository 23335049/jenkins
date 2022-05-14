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
        stage('Install Upgrade') {
            parallel {
                stage("Install") {
                    matrix {
                        axes {
                            axis {
                                name 'ARCH'
                                values 'X86', 'ARM', 'VM-X86'
                            }
                            axis {
                                name 'MODE'
                                values 'SINGLE', 'CLUSTER'
                            }
                        }
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
                stage("Upgrade") {
                    matrix {
                        axes {
                            axis {
                                name 'ARCH'
                                values 'X86', 'ARM'
                            }
                            axis {
                                name 'MODE'
                                values 'SINGLE', 'CLUSTER'
                            }
                        }
                        stages {
                            stage("upload install pkg") {
                                steps {
                                    sleep 5
                                    echo "done"
                                }
                            }
                            stage("rollback") {
                                steps {
                                    sleep 5
                                    echo "done"
                                }
                            }
                            stage("backup") {
                                steps {
                                    sleep 5
                                    echo "done"
                                }
                            }
                            stage("upgrade") {
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
    }
}