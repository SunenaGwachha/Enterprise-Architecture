FROM openjdk:8
ADD target/miniproject-0.0.1-SNAPSHOT.jar miniproject-0.0.1-SNAPSHOT.jar

COPY /src/main/resources/users.csv /Mini_project-001/src/main/resources/users.csv

EXPOSE 8085
ENTRYPOINT ["java","-jar","miniproject-0.0.1-SNAPSHOT.jar"]