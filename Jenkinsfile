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
                echo 'Deployment strated'
				
				script {
				
					
                    def warFile = findFiles(glob: 'HelloApp/target/*.war')[0].path
                    bat """
                        echo Stopping Tomcat...
                        %CATALINA_HOME%\\bin\\shutdown.bat || echo Tomcat not running

                        echo Copying WAR to webapps...
                        copy /Y "${warFile}" "${DEPLOY_PATH}\\HelloApp.war"

                        echo Starting Tomcat...
                        ${TOMCAT_HOME}\\bin\\startup.bat
                    """
                }
				
				echo 'Deployment Completed'
            }
        }
    }
}
