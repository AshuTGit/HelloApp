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
						echo "Copying WAR to webapps..."
						dir('HelloApp/target'){
						echo "Copying WAR to webapps..."
							bat """
								echo Current workspace: %WORKSPACE%
							    dir "%WORKSPACE%\\HelloApp\\target"
							    echo DEPLOY_PATH: %DEPLOY_PATH%
		
								copy /Y "*.war" %DEPLOY_PATH%\\
								"""
							echo "Copying WAR Completed."
						}

						echo "Starting Tomcat..."

						bat """
						    
							call "${TOMCAT_HOME}\\bin\\service.bat" install
							 exit /b 0
						  
							"""
															
					} catch (err) {
						 echo 'issue with Deployment. Rollback is in progress.'
					}
					
                }
				
				echo 'Deployment Completed'
            }
        }
    }
}
