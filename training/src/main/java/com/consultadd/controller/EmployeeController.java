package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import com.consultadd.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    //controller -> service(inside service write logic to call repository) -> repository
    //provides extra layer of security
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addemp")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    
        @PostMapping("/addemptodb")
    public String saveEmployee(@RequestBody Db db){
        return employeeService.saveEmployee(db);
    }
    
        @PostMapping("/addquestion")
    public String saveEmployee(@RequestBody Question question){
        return employeeService.saveEmployee(question);
    }

    @PutMapping("/updateemp")
    public String update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteemp")
    public String deleteEmployee(@RequestBody Employee employee){
        return employeeService.deleteEmployee(employee);
    }
}
