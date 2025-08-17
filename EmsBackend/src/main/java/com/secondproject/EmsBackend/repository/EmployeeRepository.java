package com.secondproject.EmsBackend.repository;

import com.secondproject.EmsBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
