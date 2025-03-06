package com.first.task.service;

import com.first.task.model.Employees;
import com.first.task.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employees saveEmployee(Employees employees){
        return employeeRepo.save(employees);
    }

    public List<Employees> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Optional<Employees> getEmployeesById(Integer id){
        return employeeRepo.findById(id);
    }

    public Employees updateEmployee(Integer id, Employees updatedEmployee) {
        return employeeRepo.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setMobileNumber(updatedEmployee.getMobileNumber());
            return employeeRepo.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);

    }


}
