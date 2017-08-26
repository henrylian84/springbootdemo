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
        //def app = docker.build("springbootdemo:${env.BUILD_NUMBER}")
        def app = docker.build("henrylian/springbootdemo:${env.BUILD_NUMBER}")
        //docker registry is not required if you have logged in docker login command.

        //aws cli login
        //sh 'aws ecr get-login --no-include-email --region us-west-2'
        //docker.withRegistry('https://721560409748.dkr.ecr.us-west-2.amazonaws.com','ecr:us-west-2:ecr-credential'){
        //    app.push("${env.BUILD_NUMBER}")
        //}
        docker.withRegistry('https://registry.hub.docker.com', 'docker-registry-login'){

        }
        app.push();

    }

    stage("deploy"){
        echo "deploying to aws_ass2"
    }
    
}