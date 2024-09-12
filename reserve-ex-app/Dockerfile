# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . /app
RUN ./gradlew :reserve-ex-app:build

# Runtime stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/reserve-ex-app/build/libs/reserve-ex-app-0.0.1-SNAPSHOT.jar /app/reserve-app.jar
EXPOSE 8081
CMD ["java", "-Dspring.profiles.active=dev", "-jar", "reserve-app.jar"]