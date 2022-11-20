FROM openjdk:17
COPY target/crm-0.0.1-SNAPSHOT.jar crm.jar
ENTRYPOINT ["java","-jar","/crm.jar"]
EXPOSE 8080
