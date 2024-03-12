FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/demo.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]