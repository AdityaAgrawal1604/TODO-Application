# SimpleTodo

How to start the SimpleTodo application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/todo-app-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Create a config.yml file containing the configurations:

```yaml
logging:
  level: INFO
  loggers:
    my.learning: DEBUG

database:
  driverClass: com.mysql.cj.jdbc.Driver
  user: YOUR_USER_NAME
  password: YOUR_PASSWORD
  url: "jdbc:mysql://localhost:3306/DATABASE_NAME?useSSL=false&allowPublicKeyRetrieval=true"
  properties:
    hibernate.dialect: org.hibernate.dialect.MySQLDialect
    hibernate.hbm2ddl.auto: update
```
