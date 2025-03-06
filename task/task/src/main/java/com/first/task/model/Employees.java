package com.first.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "please enter name")
    private String name;
    @Column
    @Max(value = 60, message = "Age should not be greater than 60")
    @Min(value = 18, message = "Age should be greater than 18 ")
    private int age;
    @Column
    @NotBlank(message = "must be filled")
    private String department;

    @Email(message = "Invalid Email Id")
    @NotBlank(message = "please enter emailId")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Consist of 10 digits")
    private String mobileNumber;

    public Employees(){

    }
    public Employees( String name, int age, String department, String email, String mobileNumber){
        super();
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
