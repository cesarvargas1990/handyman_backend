#FROM java:8
FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="cesar.vargas@ias.com.co"
WORKDIR /myapp
COPY build/libs/handyman-0.0.1-SNAPSHOT.jar /myapp/my-app.jar
ENTRYPOINT ["java","-jar","my-app.jar"]