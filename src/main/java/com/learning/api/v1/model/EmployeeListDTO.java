package com.learning.api.v1.model;

import java.util.List;

public class EmployeeListDTO {

    List<EmployeeDTO> employees;

    public EmployeeListDTO(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
