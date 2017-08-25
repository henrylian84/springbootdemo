node {
    stage("clone repo"){
        echo "clone repo"
        checkout scm
    }

    stage("compile"){
        echo "compiling the source code"

        sh 'gradle clean build'

    }

    stage("build docker"){
        echo "building docker"
        def app = docker.build("henrylian/springbootdemo:${env.BUILD_NUMBER}")
        docker.withRegistry("https://registry.hub.docker.com", "docker-registry-login")
        app.push()
    }

    stage("deploy"){
        echo "deploying to aws_ass2"
    }
    
}