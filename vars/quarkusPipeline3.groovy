def call() {
  pipeline {
    agent any
    
    stages {
        stage('Clonar repositorio') {
            steps {
                git 'https://github.com/quarkusio/quarkus.git'
            }
        }
    }
}

}
