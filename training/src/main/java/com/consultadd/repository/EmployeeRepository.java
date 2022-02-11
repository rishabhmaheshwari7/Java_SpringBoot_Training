package com.consultadd.repository;

import com.consultadd.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    @Query("select e from Employee e where e.city = :city")
    List<Employee> findAllByCity(String city);
}
