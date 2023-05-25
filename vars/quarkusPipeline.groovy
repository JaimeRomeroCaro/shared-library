def call() {
    pipeline {
        agent any

        stages {
            stage('Descargar código fuente') {
                steps {
                    bat """
                        dir
                        git clone https://github.com/quarkusio/quarkus.git
                    """
                }
            }

            stage('Modificar versión en pom.xml') {
                steps {
                    script {
                        def pomFile = readFile('pom.xml')
                        pomFile = pomFile.replace('999-SNAPSHOT', '999')
                        writeFile file: 'pom.xml', text: pomFile
                    }
                }
            }


            stage('Compilar y construir') {
                steps {
                    bat 'mvn clean install'
                }
            }
        }
    }
}
