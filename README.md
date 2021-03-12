# microservicios
Prueba de creacion de microservicios con Eureka, Zuul y Spring Boot

Guia a seguir para la creacion de microservicios:

https://www.adictosaltrabajo.com/2020/12/22/como-crear-y-desplegar-microservicios-con-spring-boot-spring-cloud-netflix-y-docker/
spring initializr: https://start.spring.io
Es necesario un servidor Eureka donde se publican los microservicios
Premisa: proyecto mavenizado y dockenizado
Es necesario un servicio Zuul que implementa un patron de API Gateway.
luego creamos el microservicio

Paso a dockenizacion
crear los Dockerfile.yml en cada uno de los proyectos
Crear el docker-compose.yml
Generar las imagenes docker de cada uno de los proyectos
docker build --rm -t eureka-server:0.0.1-SNAPSHOT .


levantar el docker-compose
he creado un pipeline que realiza todo el proceso de creacion de imagenes y despliegue del contenedor

