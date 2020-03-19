package com.learning;

import com.learning.resources.CategoryResource;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//http://localhost:8080/rest-service-api/rest/swagger.json

//@ApplicationPath("rest")
public class JAXRSConfiguration extends Application
{


    public JAXRSConfiguration() {
//        swagger JAX-RS JSON Generation BEGINS
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-service-api/rest");
        beanConfig.setResourcePackage("com.learning.resources");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan();

        //swagger JAX-RS JSON generation ENDS


    }

    @Override
    public Set<Class<?>>  getClasses() {
        HashSet<Class<?>> set = new HashSet<>();

//        set.add(HelloWorldResource.class);
        set.add(CategoryResource.class);

        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return set;
    }
}
