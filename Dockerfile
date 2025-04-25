# ===== STAGE 1: BUILD =====
FROM gradle:7.4.2-jdk11 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# ===== STAGE 2: RUNTIME =====
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]