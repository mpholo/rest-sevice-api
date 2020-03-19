package com.learning.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("EmployeeDTO fields and data types")
public class EmployeeDTO {

    @ApiModelProperty(value = "Id",required = true,example = "1",readOnly = true)
    Long Id;
    @ApiModelProperty(value = "First name of employee",required = true,example = "Tshepo")
    String firstName;
    @ApiModelProperty(value = "Last name of employee",required = true,example = "Dikekeng")
    String LastName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
