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

					 dir('HelloApp/target'){
						echo "Copying WAR to webapps..."
						
							
							bat """
								 echo Stopping Tomcat...
                      			%CATALINA_HOME%\\bin\\shutdown.bat || echo Tomcat not running
							    echo Current workspace: %WORKSPACE%
							    dir "%WORKSPACE%\\HelloApp\\target"
							    echo DEPLOY_PATH: %DEPLOY_PATH%
		
								copy /Y "*.war" %DEPLOY_PATH%\\

								echo Starting Tomcat...
                       			${TOMCAT_HOME}\\bin\\startup.bat
							"""
					 }
                   
                }
				
				echo 'Deployment Completed'
            }
        }
    }
}
