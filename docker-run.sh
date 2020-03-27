mvn clean install -Dmaven.test.skip=true

docker  build -t rest-service-api:2.0 .

docker run -it -p 8080:8080 rest-service-api:2.0