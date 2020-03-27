package com.learning.resources;

import com.learning.api.v1.model.EmployeeDTO;
import com.learning.api.v1.model.EmployeeListDTO;
import com.learning.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Employees")
@Path("/employees")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;



    @GET
    @ApiOperation(value="All Employees",notes= "This is a list of all employees in Billing")
     public Response employees() {
        EmployeeListDTO employeeListDTO =employeeService.allEmployees();
        return Response.ok(employeeListDTO).build();

    }

    @GET
    @Path("/{id}")
    @ApiOperation(value="Specific Employees",notes= "Search specific employee in Billing")
    public  Response employee(@PathParam("id") String id) {
        EmployeeDTO employeeDTO=employeeService.getEmployee(Long.valueOf(id));
        return  Response.ok(employeeDTO).build();
    }


    @DELETE
    @Path("/{id}")
    @ApiOperation(value="Specific Employees",notes= "Search specific employee in Billing")
    public  Response deleteEmployee(@PathParam("id") String id) {
       boolean status=employeeService.deleteEmployeeById(Long.valueOf(id));
        if(!status)
        {
            throw new BadRequestException("Employee with id "+id+" does not exists");
        }
        return  Response.ok().build();
    }


    @POST
    @ApiOperation(value="Specific Employees",notes= "Search specific employee in Billing")
    public  Response createEmployee(EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployeeDTO =employeeService.saveEmployeeByDTO(0L,employeeDTO);

        return  Response.ok(employeeDTO).build();
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value="update specific Employees",notes= "Search specific employee in Billing and update details")
    public  Response updateEmployee(@PathParam("id") String id,EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployeeDTO=employeeService.saveEmployeeByDTO(Long.valueOf(id),employeeDTO);
        return  Response.ok(updatedEmployeeDTO).build();
    }

    @PATCH
    @Path("/{id}")
    @ApiOperation(value="update specific Employees",notes= "Search specific employee in Billing and update details")
    public Response patchEmployee(@PathParam("id") String id,EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployeeDTO = employeeService.patchEmployee(Long.valueOf(id),employeeDTO);
        return Response.ok(updatedEmployeeDTO).build();

    }







}
