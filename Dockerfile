FROM maven:3.5.3-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/shipping-rate-0.0.1-SNAPSHOT.jar /usr/local/lib/shipping-rate.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Xms512m","-Xms2048m","/usr/local/lib/shipping-rate.jar"]
