package com.crm.controller;


import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto)
    {
        EmployeeDto Dto = employeeService.addEmployee(dto);

        return new ResponseEntity<>(Dto, HttpStatus.CREATED);


    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam long id)
    {
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>("Employee is deleted by id "+id,HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam long id,@RequestBody EmployeeDto dto)
    {
        EmployeeDto employeeDto = employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(
            @RequestParam(name="pageSize" ,required = false,defaultValue = "3") int pageSize,
            @RequestParam(name="pageNo" ,required = false,defaultValue = "0") int pageNo
    )
    {
        List<EmployeeDto> employeeDro = employeeService.gelAllEmployees(pageSize,pageNo);

        return new ResponseEntity<>(employeeDro, HttpStatus.OK);
    }

    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long empId)
    {

       EmployeeDto dto = employeeService.getEmployeeById(empId);

       return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
