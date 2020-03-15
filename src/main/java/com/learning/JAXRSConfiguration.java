package com.learning;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/rest")
public class JAXRSConfiguration extends Application {

    public JAXRSConfiguration() {
        //swagger JAX-RS JSON Generation BEGINS
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-servce-api/rest");
        beanConfig.setResourcePackage("com.learning");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan();
        //swagger JAX-RS JSON generation ENDS
    }


}
