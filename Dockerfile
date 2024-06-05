FROM openjdk:22
WORKDIR /app
COPY --from=build /target/spring-rest-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
