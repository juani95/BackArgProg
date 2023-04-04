FROM amazoncorretto:11-alpine-jdk
MAINTAINER JuaniFrascarelli
COPY target/backend-0.0.1-SNAPSHOT.jar juani-back.jar
ENTRYPOINT ["java","-jar","/juani-back.jar"]