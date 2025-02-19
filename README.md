# Study_TestContainer_SpringBoot
Study TestContainer in SpringBoot

In this study, I created a DB using `PostgresSQL` in my local env using `Docker` container.

I created a `Spring Boot` project which access the DB.

I test both `JDBC Template` and `JDBC Client` for accessing DB.

Finally, I created an integration test using `JUnit5` and `TestContainer`

## To start up a PostgresSQL Container
  1. First, you need to install `Docker`

  2. Create a volume for your DB
  
  `docker volume create mysqlVol-1`

  3. Start a PostgresSQL container

  `docker run --name some-postgres -p 5432:5432 -v postgresVol-1:/var/lib/postgresql/data -e POSTGRES_PASSWORD=password -d postgres:17.3`

## To create schema in DB
  1. The schema file is located in src/main/resources/schema.sql

  2. Execute in your DB

  I was manually execute the schema.sql using VS Code and Database Client extentsion.

## To package and run
  1. execute maven package command

  `./mvnw package`

  2. run using java command

  `java -jar target/studyspringdbaccess-0.0.1-SNAPSHOT.jar

## About testcontainer

  In my experience, most companies will have their DB and App Server installed in different server.

  In this study, I created a PostgresSQL container to simulated a DB located in different server.

  And our Spring Boot project will connect to it when it run.

  However, we want to avoid data pollution from our test case. So testcontainer will be our solution.

  I setup testcontainer in our test case and dynamically config applicatoin properties to use the PostgresSQL test container rather than the DB in local env.

## Reference

  Offical guide from testcontainer 1
  
  https://testcontainers.com/guides/getting-started-with-testcontainers-for-java/

  Offical guide from testcontainer 2
  
  https://testcontainers.com/guides/testing-spring-boot-rest-api-using-testcontainers/

  Testcontainers – From Zero to Hero. By ‪@MarcoCodes
  
  https://www.youtube.com/watch?v=v3eQCIWLYOw

  Spring Boot ❤️ Testcontainers by Iván López
  
  https://www.youtube.com/watch?v=TAI4ZiKMcfY

  Spring Boot testing: Zero to Hero by Daniel Garnier-Moiroux
  
  https://www.youtube.com/watch?v=u5foQULTxHM
