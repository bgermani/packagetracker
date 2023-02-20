FROM openjdk:17-jdk-alpine

COPY target/packagetracker-0.0.1-SNAPSHOT.jar /opt/lib/

ENTRYPOINT ["java"]
CMD ["-Dspring.profiles.active=docker","-jar","/opt/lib/packagetracker-0.0.1-SNAPSHOT.jar"]
