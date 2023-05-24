def call() {
  pipeline {
    agent {
        label "windows"
    }
    
    stages {
        stage('Clonar repositorio') {
            steps {
                git 'https://github.com/quarkusio/quarkus.git'
            }
        }
    }
}

}
