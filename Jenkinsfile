
node {
   stage('Preparation') { 
      git 'https://github.com/rgcogi/fleetman-webapp'
   }
   stage('Build') {
      sh "mvn package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.war'      
   }
     stage('Deploy'){
       
       withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'AWSCredentials', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
           ansiblePlaybook credentialsId: 'ssh-Credentials', installation: 'ansible-installation', playbook: 'deploy.yaml', sudoUser: null      
     }
  }
}
