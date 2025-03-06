package com.first.task.controller;

import com.first.task.model.Employees;
import com.first.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "http:localhost:3001")
    @PostMapping
    public Employees saveEmployee(@RequestBody Employees employees){
        return employeeService.saveEmployee(employees);
    }

    @CrossOrigin(origins = "http:localhost:3001")
    @GetMapping
    public List<Employees> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @CrossOrigin(origins = "http:localhost:3001")
    @GetMapping("{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Integer id) {
        Optional<Employees> employee = employeeService.getEmployeesById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http:localhost:3001")
    @PutMapping("{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Integer id, @RequestBody Employees updatedEmployee) {
        try {
            Employees updatedEmployees = employeeService.updateEmployee(id, updatedEmployee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http:localhost:3001")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }


}
