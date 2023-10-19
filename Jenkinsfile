pipeline {
    agent any // Vous pouvez spécifier l'agent en fonction de votre environnement

  tools{
    maven "maven"
  }     
    stages {
        
         stage('git clone') {
             
            steps {
                script {
                    slackSend message: "start pipeline"
                    git branch: 'master', url: 'https://github.com/SoulaimakH/pipline_Sprinboot.git'
                }
            }
        }
        
        
        stage('maven install') {
            steps {
                 sh "mvn clean install"

            }
        }

      
          stage('build docker file'){
         steps{
             
                 
         //sh "docker logout fatmal"
         //sh "docker build -t mydockerimage ."
         //sh "docker run mydockerimage"
           sh "docker compose build"
           sh "docker compose up -d"
                       
            slackSend message: "successfull staging"       
              
         } 
        }
        
  stage('Push to DockerHub') {
            steps {
                dir('build') {
                    //sh "docker tag build-astronot fatmal/getting-started"
                    //sh "docker push fatmal/getting-started"
                    sh "docker login -u fatmal -p 'dckr_pat_8vM_F2qqZk_PUK-nauBIaXxJ1V8'"
                    sh "docker tag build-astronot fatmal/jenkinstest:latest"
                    sh "docker push fatmal/jenkinstest:latest"
                    }
                    slackSend message: "jenkinstest image is pushed"   
                }
            }
            
            stage('Ansible') {
      steps {
          sh"ls"
          
          ansiblePlaybook  installation: 'ansible', inventory: 'Iventory', playbook: 'playbook.yml'
          
          sh "echo 'fin'"
      //  sh '''
        //  ansible --version
          //ansible-playbook --version
          //ansible-galaxy --version
        //'''
         slackSend message: "pipline is successfully executed"   
      }
    }
            
        

        
    }
    
}
