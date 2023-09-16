FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim AS runtime
WORKDIR /app
COPY --from=build /app/target/netflix-api-0.0.1-SNAPSHOT.jar demo.jar
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/netflix-api-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
