# hello-docker

A spring boot application that runs a simple rest that returns a hello message

To build the project:<br/>
```
mvn clean install
```

To build the docker image:<br/>
```
mvn dockerfile:build
```

To run built image in a docker container:<br/>
```
docker run -p 8080:8080 hello-docker:v1 hello 
```

Be greeted:<br/>
```
curl http://localhost:8080/hello
```
