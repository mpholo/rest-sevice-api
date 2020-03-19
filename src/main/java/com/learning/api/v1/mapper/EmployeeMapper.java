package com.learning.api.v1.mapper;

import com.learning.api.v1.model.EmployeeDTO;
import com.learning.domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO EmployeeToEmployeeDTO(Employee employee);
    Employee EmployeeDTOToEmployee(EmployeeDTO employee);
}
