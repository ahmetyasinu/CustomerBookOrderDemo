FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV MYSQL_IP={MYSQL_IP}
ENTRYPOINT ["java","-jar","/app.jar"]
