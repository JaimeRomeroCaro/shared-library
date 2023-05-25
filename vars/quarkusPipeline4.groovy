def call() {
    node {
        // Descargar el código fuente de la rama master de Quarkus desde GitHub
        checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/quarkusio/quarkus']]]

        // Modificar la versión en el archivo pom.xml
        sh 'sed -i \'s/999-SNAPSHOT/999/\' pom.xml'
    }
}

