package com.learning.resources;

import com.learning.api.v1.mapper.CategoryMapper;
import com.learning.api.v1.model.CategoryDTO;
import com.learning.api.v1.model.CategoryListDTO;
import com.learning.domain.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api("category")
@Path("category")
public class CategoryResource {

    @Inject
    private CategoryMapper categoryMapper;

    List<Category> categoryList;

    public CategoryResource() {
        this.categoryList = initData();
    }

    @ApiOperation(value = "This will get list of categories",notes = "The categories of different kinds of food")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {

        List<CategoryDTO> categoryDTOList= categoryList.stream()
                .map(category -> {
                    CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
                    return  categoryDTO;
                }).collect(Collectors.toList());

        CategoryListDTO categories = new  CategoryListDTO(categoryDTOList);

        return Response.ok(categories).build();
    }


    @ApiOperation(value = "This will get one category of food",notes = "The category food specified")
    @GET
    @Path("/{name}")
    public Response getCategory(@PathParam("name") String name) {
       Category category = categoryList.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst().orElse(null);
       CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

       return Response.ok(categoryDTO).build();

    }


    private List<Category> initData() {
        Category fruits = new Category();
        fruits.setId(1L);
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setId(2L);
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setId(3L);
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setId(4L);
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setId(5L);
        nuts.setName("Nuts");

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(fruits);
        categoryList.add(dried);
        categoryList.add(fresh);
        categoryList.add(exotic);
        categoryList.add(nuts);
        return categoryList;
    }

}
