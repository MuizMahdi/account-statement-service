# Statement Service
A service for fetching users accounts statements

## Running The Application

#### Note: According to the requirements, the default months range for retrieving statements is set to 3 months back, which will not retrieve any results as all statements are many years old, to get some results, you can change the DEFAULT_STATEMENTS_MONTHS_RANGE constant found in StatementConstants.java

### 1. Using Maven
Make sure that you have JDK 17 and Maven, then simply run:
```bash
mvn clean install
mvn spring-boot:run
```


### 2. Using Docker
#### A. By building and running the container from the dockerfile
Make sure that you have docker installed on your machine, then run from the application root:
```bash
docker build image -t statement-service .
```
That will build the image, and then to run the container:

```bash
docker run statement-service -p 8080:8080
```

#### B. By using docker compose (along with SonarQube)
Make sure that you have docker and docker compose installed on your machine, then run from the application root:
```bash
docker compose -f .build/docker-compose.yml up
```


## Running The Tests
Make sure that you have JDK 17 and Maven, then simply run:
```bash
mvn clean install
mvn test
```


## Swagger 3 and OpenAPI
You can access the Swagger dashboard after running the application from
`http://localhost:8080/swagger-ui/index.html`
