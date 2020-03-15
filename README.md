# rest-sevice-api
This is javaee rest service with swagger

## building the project and skipping the tests all together
mvn clean install -Dmaven.test.skip=true

## build image
docker  build -t rest-service-api:2.0 .
 
## running the container
docker run -it -p 8080:8080 rest-service-api:2.0
 
## swagger url of a service
http://localhost:8080/rest-service-api/swaggerui

## service documentation json
http://localhost:8080/rest-service-api/rest/swagger.json
