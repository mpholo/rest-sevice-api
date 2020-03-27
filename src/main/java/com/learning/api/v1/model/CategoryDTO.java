package com.learning.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@ApiModel("CategoryDTO fields and data types")
public class CategoryDTO {

//    @ApiModelProperty(value="Id",required = true,example = "1",readOnly = true)
    private Long id;
//    @ApiModelProperty(value="Name of Category",required = true,example = "Dairy")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
