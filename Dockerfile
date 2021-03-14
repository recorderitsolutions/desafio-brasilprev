FROM maven:latest as builder
WORKDIR /app
COPY . /app
RUN mvn clean package

FROM openjdk:8u121-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/desafio-brasilprev-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTIONS -jar app.jar"]