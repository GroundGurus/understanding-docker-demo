FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/simple-db-1.0-SNAPSHOT.jar /app/simpledb.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/simpledb.jar"]