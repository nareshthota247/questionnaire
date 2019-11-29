pipeline {
    agent any
    
    stages {
        stage("Git clone") {
            steps {
                //git clone  
                deleteDir()
                echo 'Clone the latest code from the code-base'
                sh 'git clone https://github.com/nareshthota247/questionnaire.git'       
            }
            
        }
        stage("Testcases") {
            steps {
                //Execute testcases 
                echo 'Execute test cases'
                dir("questionnaire"){
                    sh 'mvn clean test' 
                }               
            }
            
        }
        stage("Maven Build") {
            steps {
                echo 'Execute Maven Build'
                dir("questionnaire"){
                    sh 'mvn clean package'
                }
            }
            
        }
        stage("Docker Build") {            
            steps {
                echo 'Execute Docker Build'
                dir("questionnaire"){
                    sh "docker build -t questionnaire:\"${env.BUILD_NUMBER}\" . "
                    //sh 'docker push'
                    echo "Check the Docker image"
                    sh 'docker images'
                }
            }
            
        }
        stage("Deployment") {
            steps {
                dir("questionnaire"){
                    sh "docker run -d -p 89:8082 questionnaire:\"${env.BUILD_NUMBER}\""
                }
            }            
        }
      
    }//end stages
}