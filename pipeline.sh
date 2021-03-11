#stop Container
docker stop eureka-server
docker stop zuul
docker stop greeting-microservice
docker stop greetings-telegram

#delete old images from docker
docker rmi eureka-server:0.0.1-SNAPSHOT
docker rmi zuul:0.0.1-SNAPSHOT
docker rmi greeting-microservice:0.0.1-SNAPSHOT
docker rmi greetings-telegram:0.0.1-SNAPSHOT

cd eureka
mvn clean install
docker build --rm -t eureka-server:0.0.1-SNAPSHOT .
cd ..
cd zuul
mvn clean install
docker build --rm -t zuul:0.0.1-SNAPSHOT .
cd ..
cd greeting-microservice
mvn clean install
docker build --rm -t greeting-microservice:0.0.1-SNAPSHOT .
cd ..
cd greetings-telegram
mvn clean install
docker build --rm -t greetings-telegram:0.0.1-SNAPSHOT .
cd ..
docker-compose up -d  