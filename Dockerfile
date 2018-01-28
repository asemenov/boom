FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG EXECUTABLE_FILE
ADD ${EXECUTABLE_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]