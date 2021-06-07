package com.AlbertAbuav.Test05.controllers;

import com.AlbertAbuav.Test05.beans.Employee;
import com.AlbertAbuav.Test05.beans.Job;
import com.AlbertAbuav.Test05.services.CompanyService;
import com.AlbertAbuav.Test05.wrappers.EmployeeList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Company")  //==>  http://localhost:8080/Company
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("employees")  //==>  http://localhost:8080/Company/employees
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        companyService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED); // Return 201 (created)
    }

    @GetMapping("employees/{id}") //==>  http://localhost:8080/Company/employees/3
    public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(companyService.getEmployeeById(id), HttpStatus.OK); //==> Return body + 200
    }

    @GetMapping("employees")  //==>  http://localhost:8080/Company/employees
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(new EmployeeList(companyService.getAllEmployees()), HttpStatus.OK); //==> Return List + 200
    }

    @GetMapping("employees/by_name")  //==>  http://localhost:8080/Company/employees/by_name
    public ResponseEntity<?> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<>(new EmployeeList(companyService.getEmployeesByName(name)), HttpStatus.OK); //==> Return List + 200
    }

}
