def call() {
  pipeline {
    agent {
        label "windows"
    }
    
    stages {
        stage('Clonar repositorio') {
            steps {
                git clone 'https://github.com/quarkusio/quarkus.git'
            }
        }
    }
}

}
