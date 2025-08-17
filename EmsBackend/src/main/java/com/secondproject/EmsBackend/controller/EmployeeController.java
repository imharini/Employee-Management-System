package com.secondproject.EmsBackend.controller;


import com.secondproject.EmsBackend.dto.EmployeeDto;
import com.secondproject.EmsBackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    // build add employee rest api
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savesEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savesEmployee, HttpStatus.CREATED);
    }

    // build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // build get all employee rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    //build update employee api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    //build delete employee rest api
     @DeleteMapping("{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

}
