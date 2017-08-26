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
def say = { println it }

        docker.withRegistry("https://registry.hub.docker.com", 'docker-registry-login', say)
        app.push()
    }

    stage("deploy"){
        echo "deploying to aws_ass2"
    }
    
}