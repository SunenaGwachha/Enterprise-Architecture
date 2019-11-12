FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
COPY /target/*.jar paypal-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","paypal-service-0.0.1-SNAPSHOT.jar"]