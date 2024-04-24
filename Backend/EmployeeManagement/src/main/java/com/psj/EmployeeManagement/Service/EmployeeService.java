package com.psj.EmployeeManagement.Service;

import com.psj.EmployeeManagement.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(Employee employee, Integer id);

    public List<Employee> getEmployees();

    public Employee getEmployee(Integer id);

    public void deleleEmployee(Integer id);
}
