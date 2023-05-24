def call() {
    pipeline {
        agent any

        stages {
            stage('Descargar código fuente') {
                steps {
                    git branch: 'master', url: 'https://github.com/quarkusio/quarkus'
                }
            }

            stage('Modificar versión') {
                steps {
                    script {
                        def pomFile = readFile('pom.xml')
                        pomFile = pomFile.replace('999-SNAPSHOT', '999')
                        writeFile file: 'pom.xml', text: pomFile
                    }
                }
            }

            // Agrega etapas adicionales según tus necesidades

            stage('Compilar y construir') {
                steps {
                    // Ejecuta aquí los comandos para compilar y construir tu proyecto Quarkus
                }
            }
        }
    }
}
