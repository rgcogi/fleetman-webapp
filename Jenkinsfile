
node {
   stage('Preparation') { 
      git 'https://github.com/rgcogi/fleetman-webapp'
   }
   stage('Build') {
      sh "mvn package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'      
   }
}
