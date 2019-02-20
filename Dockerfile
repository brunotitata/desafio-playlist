FROM openjdk:8-jre-alpine
MAINTAINER br.com.ifood
RUN mkdir /app
COPY target/ifood-test-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
ENTRYPOINT exec java -jar ifood-test-0.0.1-SNAPSHOT.jar