package com.learning.services;

import com.learning.api.v1.mapper.EmployeeMapper;
import com.learning.api.v1.model.EmployeeDTO;
import com.learning.api.v1.model.EmployeeListDTO;
import com.learning.domain.Employee;
import com.learning.repository.EmployeeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EmployeeServiceImpl implements EmployeeService {

   private  EmployeeListDTO employeeListDTO;

    @Inject
    EmployeeMapper employeeMapper;
    @Inject
    EmployeeRepository employeeRepository;


    public EmployeeListDTO allEmployees() {
       List<EmployeeDTO> employeeDTOS= employeeRepository.getEmployeeList()
           .stream().map(employeeMapper::EmployeeToEmployeeDTO)
               .collect(Collectors.toList());

       EmployeeListDTO employeeListDTO = new EmployeeListDTO(employeeDTOS);

       return employeeListDTO;
    }

    public EmployeeDTO getEmployee(Long id) {
          return employeeMapper.EmployeeToEmployeeDTO(findEmployee(id));
    }

    public EmployeeDTO saveEmployeeByDTO(Long id,EmployeeDTO employeeDTO) {

         Employee employee = findEmployee(id);
        if(employee!=null) {
            employee = employeeMapper.EmployeeDTOToEmployee(employeeDTO);
            Long employeeId = employee.getId();
            for(int i=0;i<employeeRepository.getEmployeeList().size();i++)
            {
                if(employeeRepository.getEmployeeList().get(i).getId().equals(id)) {
                    employeeRepository.getEmployeeList().set(i,employeeMapper.EmployeeDTOToEmployee(employeeDTO));
                    break;
                }
            }
           return employeeDTO;
        } else {
            Employee newEmployee =employeeMapper.EmployeeDTOToEmployee(employeeDTO);
            employeeRepository.getEmployeeList().add(employeeMapper.EmployeeDTOToEmployee(employeeDTO));
            return  employeeDTO;
        }

    }

    public boolean deleteEmployeeById(Long id) {
        Employee employee =findEmployee(id);
        if(employee!=null) {
            employeeRepository.getEmployeeList().remove(employee);
            return true;
        }
        return  false;

    }

    public EmployeeDTO patchEmployee(Long id,EmployeeDTO employeeDTO) {
        Employee employee = findEmployee(id);
        if(employee!=null) {
            if(employeeDTO.getFirstName()!=null) {
               employee.setFirstName(employeeDTO.getFirstName());
            }
            if(employeeDTO.getLastName()!=null) {
                employee.setLastName(employeeDTO.getLastName());
            }
        }

        return employeeMapper.EmployeeToEmployeeDTO(employee);
    }

    private Employee findEmployee(Long id) {
        return employeeRepository.getEmployeeList()
                .stream()
                .filter(employee-> employee.getId().equals(id))
                .findFirst().orElse(null);

    }


}
