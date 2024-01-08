FROM openjdk:11
COPY todo-app/config.yml /opt/dropwizard/
COPY todo-app/target/todo-app-1.0-SNAPSHOT.jar /opt/dropwizard/
EXPOSE 8080
WORKDIR /opt/dropwizard
CMD ["java", "-jar" ,"/opt/dropwizard/todo-app-1.0-SNAPSHOT.jar", "server", "/opt/dropwizard/config.yml"]
