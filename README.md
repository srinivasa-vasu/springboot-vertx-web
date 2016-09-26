# springboot-vertx-web

This example shows how you can embed Vert.x in SpringBoot and also guide you on deploying this to openshift 3.x

So now you can add all the goodness of Vert.x to your SpringBoot applications

The end result is more or less the same as using Vert.x without SpringBoot:

* There is a similar amount of code and boilerplate (both very little)
* Both Vert.x and SpringBoot create executable fat jars (The Vert.x jar is considerable smaller than the SpringBoot one though)
* The SpringBoot version seems a bit slower to startup than the Vert.x version

Fat JAR

* To build the "fat jar"

    mvn package

* To run the fat jar:
    
    java -jar target/springboot-example-1.2.4.RELEASE.jar
    
Openshift
* Create a new project through openshift CLI or Web Console
* Create a new app with wildfly:10.0 as the builder image with this repo as the source so that openshift does S2I to create the application docker image

CLI

    oc new-project jee --display-name='spring-vertx'
    oc project jee
    oc new-app wildfly:10.0~https://github.com/srinivasa-vasu/springboot-vertx-web.git
    
This triggers a S2I build, pushes to IS, launches a pod, wraps it with a service and route. To verify the output once the pod is up, click the route link followed by springboot-vertx-web-1.0/
