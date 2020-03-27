package com.learning.resources;

import com.learning.api.v1.mapper.CarMapper;
import com.learning.api.v1.model.CarDTO;
import com.learning.api.v1.model.CarListDTO;
import com.learning.api.v1.model.CategoryDTO;
import com.learning.domain.Car;
import com.learning.domain.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Api("car")
@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {


    @Inject
    CarMapper carMapper;

//    @ApiOperation(value = "This will get list of cars",notes = "The cars of different kinds of food")
    @GET
    public Response getCars() {

//        List<CategoryDTO> categoryDTOList= categoryList.stream()
//                .map(category -> {
//                    CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
//                    return  categoryDTO;
//                }).collect(Collectors.toList());
//
//        CategoryListDTO categories = new  CategoryListDTO(categoryDTOList);

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();
        cars.add(car1);
        cars.add(car2);

       List<CarDTO> carListDTO = cars.stream()
               .map(carMapper::carToCarDTO)
               .collect(Collectors.toList());

       CarListDTO carListDTO1 = new CarListDTO(carListDTO);


        return Response.ok(carListDTO1).build();
    }


    @ApiOperation(value = "This will get list of cars",notes = "The cars of different kinds of food")
    @GET
    @Path("/{id}")
    public Response getCar(@PathParam("id") Long id) {




        CarDTO car1 = new CarDTO();



        return Response.ok(car1).build();
    }


    @ApiOperation(value = "This will create new category",notes = "Add new category by specifing all required fields")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(CarDTO carDTO) {



        URI location = UriBuilder.fromResource(CategoryResource.class)
                .path("/{id}")
                .resolveTemplate("id",carDTO.getMake())
                .build();
        return Response.created(location).build();

    }





}
