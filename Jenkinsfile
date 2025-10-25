pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
                echo 'Code checkout completed'
            }
        }
    
        stage('Build') {
            steps {
               echo '========== Building Maven Project =========='
                bat 'mvn clean install -Dmaven.test.skip=true'
            }
        }
   
        stage('Deployment') {
            steps {
                echo 'Deployment Completed'
            }
        }
    }
}
