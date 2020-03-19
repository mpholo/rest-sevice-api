package com.learning.services;

import com.learning.api.v1.model.EmployeeDTO;
import com.learning.api.v1.model.EmployeeListDTO;

public interface EmployeeService  {

    EmployeeDTO saveEmployeeByDTO(Long id, EmployeeDTO employeeDTO);
    EmployeeListDTO allEmployees();
    EmployeeDTO getEmployee(Long id);
    boolean deleteEmployeeById(Long id);
    EmployeeDTO patchEmployee(Long id,EmployeeDTO employeeDTO);


}
