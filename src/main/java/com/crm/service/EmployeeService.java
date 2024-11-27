package com.crm.service;

import com.crm.entity.Employee;
import com.crm.exception.ResourceNotFound;
import com.crm.payload.EmployeeDto;
import com.crm.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }



    public EmployeeDto mapToDto(Employee employee)
    {
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

        return employeeDto;
    }

    public Employee mapToEntity(EmployeeDto employeeDto)
    {
        Employee employee = modelMapper.map(employeeDto,Employee.class);

        return employee;
    }


    public EmployeeDto addEmployee(EmployeeDto dto) {

        Employee emp = mapToEntity(dto);

        Employee employee = employeeRepository.save(emp);
        return mapToDto(employee);
    }

    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(long id, EmployeeDto dto) {

        Employee emp = mapToEntity(dto);
        emp.setId(id);
        Employee updatedEmployee = employeeRepository.save(emp);
        return mapToDto(updatedEmployee);


    }

    public List<EmployeeDto> gelAllEmployees(int pageSize, int pageNo) {

        Pageable page = PageRequest.of(pageSize, pageNo);
        Page<Employee> all = employeeRepository.findAll(page);
        List<Employee> employees = all.getContent();
        List<EmployeeDto> dto = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());

        return dto;

    }

    public EmployeeDto getEmployeeById(long empId)
    {
        Employee employee =  employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFound("Employee Not Found with id "+empId)
        );



        return mapToDto(employee);

    }
}
