package com.psj.EmployeeManagement.Controllers;

import com.psj.EmployeeManagement.Entities.Employee;
import com.psj.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/getemployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        Employee employee1 = employeeService.updateEmployee(employee,id);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        employeeService.deleleEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("user deleted successfully", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
