pipeline {
    agent any

		 environment {        
		        // Tomcat installation details
		        TOMCAT_HOME = "C:\\Tomcat9.0"
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
					try{
						bat """
								 echo Stopping Tomcat...

								   @echo off
					                    call "%TOMCAT_HOME%\\bin\\shutdown.bat"
					                    if %errorlevel% neq 0 (
					                        echo [WARN] Tomcat may not be running or port 8005 is blocked.
					                        echo Continuing deployment anyway...
					                        exit /b 0
					                    )
                      			
								"""
								
					} catch (err) {
						 echo Tomcat not running
					}
					
                }
				
				echo 'Deployment Completed'
            }
        }
    }
}
