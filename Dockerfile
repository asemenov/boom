FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} boom.jar
ENTRYPOINT ["java","-jar","/boom.jar"]