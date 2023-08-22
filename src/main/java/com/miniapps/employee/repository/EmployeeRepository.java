package com.miniapps.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniapps.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByNik(String nik);

    Boolean existsByNik(String nik);

    List<Employee> findByNameContaining(String name);
}
