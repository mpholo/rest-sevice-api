package com.learning.repository;

import com.learning.domain.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmployeeRepository {

    List<Employee> employeeList;

    public EmployeeRepository() {

        loadEmployees();

    }

    private void loadEmployees() {

        Employee employee1 = new Employee(1L,"Mpholo","Leboea");
        Employee employee2 = new Employee(2L,"Tebogo","Kgofelo");
        Employee employee3 = new Employee(3L,"Nare","Hopane");
        Employee employee4 = new Employee(4L,"Sabelo","Simelane");
        Employee employee5 = new Employee(5L,"Ashok","Agrawal");
        Employee employee6 = new Employee(6L,"Mongezi","Dlamini");
        Employee employee7 = new Employee(7L,"Mnguni","Ziyanda");
        Employee employee8 = new Employee(8L,"Bushy","Netshidaulu");
        Employee employee9 = new Employee(9L,"Thembalakhe","Ngcongo");

       employeeList =new ArrayList<>( Arrays.asList(employee1,employee2,employee3,
                                                    employee4,employee5,employee6,
                                                    employee7,employee8,employee9));

    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
