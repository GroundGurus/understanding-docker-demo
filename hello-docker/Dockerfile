FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/hello-docker-1.0-SNAPSHOT.jar /app/hello-docker.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/hello-docker.jar"]