# Spring service with Netflix & Docker to Kubernetes

This project will show how to migrate from Spring & Netflix stack to Spring & Kubernetes

## Cassandra
Official Cassandra Docker image is used: https://hub.docker.com/_/cassandra/ 
(tested against `3.11.3` version)

### Local
To run application:

 1. Go to `spring-netflix-docker/snd-players` and execute
```
./gradlew clean build
```
 2. Go to `spring-netflix-docker` and execute
```
docker-compose up -d
```
This will create new Docker network and set up Cassandra node with schema upload.

REST API available for:
* `snd-players` service -> http://192.168.100.110:8090/api/v1/snd-players

#### Notes
* During startup the `snd-players` might be restarting multiple times for some time - this is due to missing schema - this will be applied by `db-cassandra-load-keyspace` container
* To build project you need Gradle `5.2` and Java 11

