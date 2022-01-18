FROM adoptopenjdk/openjdk11:alpine-jre
#LABEL mantainer="nuel.net"
ADD target/restfulapi-docker-demo.jar restfulapi-docker-demo.jar
ENTRYPOINT ["java", "-jar", "restfulapi-docker-demo.jar"]