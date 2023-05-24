def call() {
pipeline {
    agent any
    
    stages {
        stage('Descargar código fuente') {
            steps {
                git branch: 'master', url: 'https://github.com/quarkusio/quarkus'
            }
        }
        
        stage('Modificar versión en pom.xml') {
            steps {
                bat """
                    cd quarkus
                    sed -i 's/999-SNAPSHOT/999/g' pom.xml
                """
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
