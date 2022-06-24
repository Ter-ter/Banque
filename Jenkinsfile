pipeline {
    agent any

    //tools {
        // Install the Maven version configured as "M3" and add it to the path.
        //maven "M3"
    //}

    stages {
        stage('Git') {
            steps {
                // Get some code from a GitHub repository
                sh "pwd"
                sh "sshpass -v -p \"root\" ssh -v -o \"StrictHostKeyChecking=no\" root@172.25.1.27 'rm -rvf /mnt/www/html/test/'"
                sh "git clone https://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@github.com/Ter-ter/Hello-jenkins.git temp" //clone dans /var/lib/jenkins/worksapce/temp
                sh "mv -n temp/* ." //deplace le git dans /var/lib/jenkins/workspace/test
                sh "rm -rf temp"

                // Run Maven on a Unix agent.
                
                
                // To run Maven on a Windows agent, use
                //dir('Jenkins') {
                //    bat "mvn -Dmaven.test.failure.ignore=true clean"
                //}
                
            }
        }
    }
}
