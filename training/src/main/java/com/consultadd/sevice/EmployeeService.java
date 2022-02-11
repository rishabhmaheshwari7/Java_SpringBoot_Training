package com.consultadd.sevice;


import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "Couldn't Save data, ID Already Exists";
        }
        else{
            employeeRepository.save(employee);
            return "Employee details saved Successfully..!!";
        }
    }

    public String deleteEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.deleteById(employee.getId());
            return "Deleted employee Details Successfully";
        }
        else{
            return "ID does not exist check again!!";
        }
    }

    public String updateEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.save(employee);
            return "Update done";
        }
        else{
            return "Not updated, ID does not exist";
        }
    }


    public List<Employee> findAllByCity(String city){
        return employeeRepository.findAllByCity(city);
    }


}
