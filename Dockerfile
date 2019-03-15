# fetch basic image
FROM maven:3.6.0-jdk-11

# application placed into /opt/app
RUN mkdir -p /opt/app
WORKDIR /opt/app

# Add the jar file to the directory
ADD target/DockerApiDemo-1.0.0.jar .

#local application port
EXPOSE 8085

# Tell docker on how to start the spring boot application
ENTRYPOINT ["java","-jar","DockerApiDemo-1.0.0.jar"]

