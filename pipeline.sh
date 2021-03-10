cd eureka
docker build --rm -t eureka:0.0.1-SNAPSHOT .
cd ..
cd zuul
docker build --rm -t zuul:0.0.1-SNAPSHOT .
cd ..
cd greeting-microservice
docker build --rm -t greeting-microservice:0.0.1-SNAPSHOT .
cd ..
docker-compose up -d  