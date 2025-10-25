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
            }
        }
   
        stage('Deployment') {
            steps {
                echo 'Deployment Completed'
            }
        }
    }
}
