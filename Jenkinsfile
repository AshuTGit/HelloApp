pipeline {
    agent any

		 environment {        
		        // Tomcat installation details
		        TOMCAT_HOME = "C:Tomcat9.0"
		        DEPLOY_PATH = "${TOMCAT_HOME}\\webapps"
		    }

	
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
                echo 'Deployment strated'
				
				script {
					bat """
					    echo Current workspace: %WORKSPACE%
					    dir "%WORKSPACE%\\HelloApp\\target"
					    echo DEPLOY_PATH: %DEPLOY_PATH%
					"""
					
                   
                }
				
				echo 'Deployment Completed'
            }
        }
    }
}
