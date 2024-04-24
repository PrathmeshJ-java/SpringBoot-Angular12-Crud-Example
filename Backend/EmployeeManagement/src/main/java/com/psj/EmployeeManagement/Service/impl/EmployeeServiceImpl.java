package com.psj.EmployeeManagement.Service.impl;

import com.psj.EmployeeManagement.Entities.Employee;
import com.psj.EmployeeManagement.Exceptions.ResourceNotFoundException;
import com.psj.EmployeeManagement.Repositories.EmployeeRopository;
import com.psj.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRopository employeeRopository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRopository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee existingEmployee = employeeRopository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id :"+id));
        if(existingEmployee != null){
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            return employeeRopository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRopository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRopository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id :"+id));
    }

    @Override
    public void deleleEmployee(Integer id) {
        Employee employee = employeeRopository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id :"+id));
        employeeRopository.delete(employee);
    }
}
