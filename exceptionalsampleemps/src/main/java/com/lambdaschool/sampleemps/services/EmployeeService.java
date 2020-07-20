package com.lambdaschool.sampleemps.services;

import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;

import java.util.List;

public interface EmployeeService
{
    Employee findEmployeeById(long employeeid);
    List<Employee> findAllEmployees();

    List<Employee> findEmployeeNameContaining(String subname);

    List<Employee> findEmployeeEmailContaining(String subemail);

    Employee save(Employee employee);

    List<EmpNameCountJobs> getEmpNameCountJobs();

    Employee update(Employee employee, long employeeid);
}
