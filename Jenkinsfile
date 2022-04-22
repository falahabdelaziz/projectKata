 pipeline {

     agent any

     tools {
         maven 'maven'
     }

     parameters {
         choice(
             name: "credentialsId",
             choices: "82c5b39e-a100-4a9a-9404-5eb71844697d\n3c1d719d-fcd1-4b9d-8e11-46a7d815a87b",
             description: "Git credential"
         )
     }

     stages {
         stage('Clone code')
         {
             steps{
                 git credentialsId: "${params.credentialsId}", url: 'https://github.com/falahabdelaziz/projectKata.git'
             }
         }

         stage('Build code')
         {
             steps {
                 sh "mvn -Dmaven.test.skip=true clean package"
             }
         }
         stage('Analyse code')
         {
             steps {
                 withSonarQubeEnv("sonar-7") {
                     sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin'
                 }
             }
         }

         stage('Docker')
         {
             parallel {
                 stage('Remove container')
                 {
                     steps{
                         sh 'docker stop socleKataCompte || true && docker rm socleKataCompte || true '
                     }
                 }
                 stage('Build image')
                 {
                     steps{
                         script {
                             def app = docker.build "localhost:8081/socleKataCompte"
                             app.push()
                         }
                     }
                 }
             }
         }

         stage ('Run docker image')
         {
             steps{
                 script {
                     docker.image("localhost:8081/socleKataCompte").run('-m 512MB -p 9007:9007 -h socleKataCompte  --name socleKataCompte')
                 }
             }
         }

     }
 }