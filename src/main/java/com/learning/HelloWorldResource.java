package com.learning;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Api("hello")
@Path("hello")
public class HelloWorldResource {

//    http://localhost:8080/rest-service-api/rest/hello

    @ApiOperation(value = "This will get list of messages",notes = "There are some notes about API.")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld() {


        Map<String, String> response = new HashMap<String, String>();
        response.put("Message 1","Hello World from Mpholo 1 Leboea");
        response.put("Message 2","Hello World from Mpholo 2 Leboea");
        response.put("Message 3","Hello World from Mpholo 3 Leboea");



        return Response.ok(response).build();
    }
}
