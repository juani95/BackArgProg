FROM amazoncorretto:11-alpine-jdk
MAINTAINER JuanIgnacioFrascarelli
COPY target/backend-0.0.1-SNAPSHOT juani-back.jar
ENTRYPOINT ["java","-jar","/juani-back.jar"]