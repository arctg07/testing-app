FROM openjdk:17-oracle
WORKDIR /src
COPY . .
RUN ./mvnw clean package -DskipTests
ENV PORT=8080
EXPOSE $PORT
ENTRYPOINT ["java", "-jar", "target/testing-app.jar"]
