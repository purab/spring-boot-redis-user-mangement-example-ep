

### api urls
http://localhost:8080/v1/users
### documentation
1. http://localhost:8080/v1/system-info
2. http://localhost:8080/v3/api-docs
3. http://localhost:8080/swagger-ui.html
4. http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config


### after management setting api url
1. http://localhost:9090/actuator/health
2. http://localhost:9090/actuator/openapi
3. http://localhost:9090/actuator/swaggerui


### Spring Profiles
####How to run using a profile?
```mvn spring-boot:run -DskipTests -Dspring-boot.run.profiles={Profile-Name}```

e.g. For Dev

```mvn spring-boot:run -DskipTests -Dspring-boot.run.profiles={Profile-Name}```

e.g. Different Port

```mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080 mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8090```

### For redis server use following commands (Ref:https://www.baeldung.com/spring-data-redis-properties)
```
docker pull redis
docker run --name saggu.uk -p 6379:6379 -d redis
```