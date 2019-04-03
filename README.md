#Docker API Demo

This is a (junk) demo spring boot application that can be run inside a docker
container

#Docker Compose
To start docker compose use "docker-compose up -d"

#Pact Broker
Pact broker url - http://localhost:8090

##API Endpoint 
The baseurl of api endpoints is http://localhost:8082

#Swagger
Swagger endpoint is http://localhost:8082/swagger-ui.html

#Kafka
Kafka installation is also copied under the container folder
To read from the console consumer use the below command
kafka-console-consumer --bootstrap-server localhost:9092 --topic kafka_example --from-beginning 

#JMS Queue
JMS Admin Console - http://localhost:8161

