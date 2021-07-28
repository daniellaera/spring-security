# Spring Boot, Spring Security, PostgreSQL: JWT Authentication & Authorization example

## Configure Docker Container for PostgreSQL

Click on `docker-compose.yml` and play or run `docker compose up -d`

## Configure Spring Datasource, JPA, App properties

Open `src/main/resources/application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=123456
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.datasource.initialization-mode=always

application.jwt.secretKey=69MyGwigg5jNTpUEzWhSpQPjfHFH8k5f
application.jwt.tokenPrefix=Bearer
application.jwt.tokenExpirationAfterDays=86400000
```

## Run Spring Boot application

```
mvn spring-boot:run
```

## Run Maven Compile

```
clean package -U
```

## Run following SQL insert statements

```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
