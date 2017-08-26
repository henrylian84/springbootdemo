node {
    stage("clone repo"){
        echo "clone repo"
        checkout scm
    }

    stage("compile"){
        echo "compiling the source code"
        if (isUnix()) {
            sh './gradlew clean build'
            } else {
            bat './gradlew.bat clean build'
         }
    }

    stage("build docker"){
        echo "building docker"
        def app = docker.build("henrylian/springbootdemo:${env.BUILD_NUMBER}")
        //push to docker hub
        docker.withRegistry("https://docker.io", 'docker-registry-login', {})
        //sh 'aws ecr get-login --no-include-email --region us-west-2'

        //docker.withRegistry("721560409748.dkr.ecr.us-east-1.amazonaws.com/henrylian", null, {})

        app.push()
    }

    stage("deploy"){
        echo "deploying to aws_ass2"
    }
    
}