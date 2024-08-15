package com.example.jwt_example.controller;

import com.example.jwt_example.model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee(10, "Mirzohid", 23),
            new Employee(11, "Kamron", 43)
    ));

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @PostMapping("/emp/add")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
