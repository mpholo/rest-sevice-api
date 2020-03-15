FROM jboss/wildfly

COPY target/rest-service-api.war  /opt/jboss/wildfly/standalone/deployments/
