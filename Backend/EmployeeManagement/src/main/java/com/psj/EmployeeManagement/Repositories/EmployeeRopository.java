package com.psj.EmployeeManagement.Repositories;

import com.psj.EmployeeManagement.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRopository extends JpaRepository<Employee, Integer> {
}
