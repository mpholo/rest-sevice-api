package com.learning.resources;

import com.learning.api.v1.mapper.CategoryMapper;
import com.learning.api.v1.model.CategoryDTO;
import com.learning.api.v1.model.CategoryListDTO;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
@Api("category")
@Path("/categories")
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

       if(category==null) {
           throw  new BadRequestException("Id must match path parameter");
       }

       CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

       return Response.ok(categoryDTO).build();

    }

    @ApiOperation(value = "This will create new category",notes = "Add new category by specifing all required fields")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CategoryDTO categoryDTO) {

        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        categoryList.add(category);
        CategoryDTO newCategoryDTO = categoryMapper.categoryToCategoryDTO(category);

        URI location = UriBuilder.fromResource(CategoryResource.class)
                .path("/{id}")
                .resolveTemplate("id",newCategoryDTO.getId())
                .build();
        return Response.created(location).build();

    }

    @ApiOperation(value = "This will update existing category",notes = "Modify category")
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") String id,CategoryDTO categoryDTO) {

        Optional<CategoryDTO> searchedCategoryDTO = findCategory(id);

        if(!searchedCategoryDTO.isPresent()) {
            throw  new WebApplicationException("Id must match path parameter",Response.Status.BAD_REQUEST);
        }

        searchedCategoryDTO.ifPresent( c-> {

            for(int i=0;i<categoryList.size();i++) {
              if(c.getId()==categoryList.get(i).getId())
                categoryList.set(i,categoryMapper.categoryDTOToCategory(categoryDTO));
            }

                }
        );


        return Response.ok().build();

    }



    @ApiOperation(value = "This will delete category",notes = "Delete category")
    @DELETE
    @Path("/{isbn}")
    public Response deleteCategory(@PathParam("id") String id) {
        Optional<CategoryDTO> searchedCategory = findCategory(id);
        searchedCategory.ifPresent(a->{
            categoryList.remove(categoryMapper.categoryDTOToCategory(a));
        });

        return Response.ok().build();
    }

    private Optional<CategoryDTO> findCategory(@PathParam("id") String id) {
        return categoryList.stream()
                .filter(a->a.getId().equals(Long.valueOf(id)))
                .map(categoryMapper::categoryToCategoryDTO)
                .findFirst();
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
