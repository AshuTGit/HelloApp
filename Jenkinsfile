pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
               echo 'Checking out code from Git...'
                git branch: 'master', url: 'https://github.com/AshuTGit/HelloApp.git'
            }
        }
    
        stage('Build') {
            steps {
               echo '========== Building Maven Project =========='
                bat 'cd HelloApp'
                 dir('HelloApp') {
                      bat 'mvn clean install -Dmaven.test.skip=true'
                 }
               
            }
        }
   
        stage('Deployment') {
            steps {
                echo 'Deployment Started'

               deploy adapters: [tomcat9(credentialsId: 'tomcat_credential_id', path: '', url: 'http://localhost:8081/')], contextPath: null, war: '**/*.war'

                echo 'Deployment Completed'
            }
        }
    }
}
