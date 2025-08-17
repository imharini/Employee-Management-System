package com.secondproject.EmsBackend.service;

import com.secondproject.EmsBackend.dto.EmployeeDto;
import com.secondproject.EmsBackend.entity.Employee;
import com.secondproject.EmsBackend.exception.ResourceNotFoundException;
import com.secondproject.EmsBackend.mapper.EmployeeMapper;
import com.secondproject.EmsBackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
     private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not exist with the given id : " + employeeId));
        System.out.println("employee" + employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("employee not exist with the given id : " + employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return  EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("employee not exist with the given id : " + employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
