# Spring Boot lorem service API

This is a small Spring-Boot application with minimum logs push to Elastic search and kibanafor evaluation purpose assigned by Zenith Technologies Dubai 

## Requirements
 * Java 17
 * Maven
 
## Docker Build
The application has been built and packaged in a Docker container and published to dockerhub


## How To

#### Clean and Build
```
mvn clean package
```

#### Docker Build
```
docker build -t spring-boot-lorem-poc:latest .
```
#### Docker Tag
```
docker tag spring-boot-lorem-poc:latest sajjadqureshi1988/zenith-repo:latest 
```
#### Docker Push
We have used local docker login and its latest tag is publically available on docker for use 
```
docker push sajjadqureshi1988/zenith-repo:latest 
```