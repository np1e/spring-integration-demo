## Get started

You need Java 11 to run this application.

Install dependencies and build the project using the Gradle wrapper:
```shell
./gradlew build
```
Run the Spring Boot application:
```shell
./gradlew bootRun
```
Now you can browse to `localhost:8080/order` and use the demo application. 
## Properties

You need to add at the three properties to the `application.properties` file:
```
scpi.auth.username
scpi.auth.password
scpi.leadform.endpoint
```