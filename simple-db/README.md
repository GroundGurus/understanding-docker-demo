# simple-db
A simple Spring Boot application that connects to a database setup in Docker

# Development
To build the project:<br/>
```
mvn clean install
```

To build the docker image:<br/>
```
mvn dockerfile:build
```

Run PostgreSQL on Docker:<br/>
```
docker-compose -f specs/postgres.yml up -d
```

Run the main class from the IDE (SimpleDBApplication)

# Deploy to Docker
Edit application.yml and un-comment the one pointing to simple-postgresql, then comment the one pointing to localhost
```
url: jdbc:postgresql://simple-postgresql:5432/simpledb
#url: jdbc:postgresql://localhost:5432/simpledb
```

To build the project:<br/>
```
mvn clean install
```

To build the docker image:<br/>
```
mvn dockerfile:build
```

Run the Spring Boot App and PostgreSQL on Docker:<br/>
```
docker-compose -f specs/app.yml up -d
```