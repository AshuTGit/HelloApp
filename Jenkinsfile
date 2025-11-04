pipeline {
    agent any

    environment {
        // Jenkins tools
        MAVEN_HOME = tool 'Maven'
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"

        // Tomcat config
        TOMCAT_HOME = "C:\\Tomcat9.0"
        DEPLOY_PATH = "${TOMCAT_HOME}\\webapps"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                echo "Building the project with Maven..."
                bat 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo "Deploying WAR file to Tomcat..."
                bat """
                    del /Q "%DEPLOY_PATH%\\HelloApp.war"
                    copy /Y "target\\HelloApp.war" "%DEPLOY_PATH%"
                """
            }
        }

        stage('Restart Tomcat') {
            steps {
                echo "Restarting Tomcat..."
                bat """
                    call "%TOMCAT_HOME%\\bin\\shutdown.bat"
                    timeout /t 5
                    call "%TOMCAT_HOME%\\bin\\startup.bat"
                """
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "Verifying deployment..."
                bat 'curl http://localhost:8080/HelloApp || echo "Service not responding"'
            }
        }
    }

    post {
        success {
            echo "✅ Build and deployment successful!"
        }
        failure {
            echo "❌ Build or deployment failed!"
        }
    }
}
