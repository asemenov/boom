FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG EXECUTABLE_FILE
ADD ${EXECUTABLE_FILE} application.war
ENTRYPOINT ["java","-jar","/application.war"]