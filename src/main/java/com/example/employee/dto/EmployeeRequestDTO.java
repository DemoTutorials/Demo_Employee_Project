package com.example.employee.dto;

import com.example.employee.enums.BloodGroup;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeRequestDTO {
    private String employeeName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy")
    private LocalDate birthDate;
    private BigDecimal salary;
    private String permanentAddress;
    private BloodGroup bloodGroup;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(String employeeName, String email, LocalDate birthDate, BigDecimal salary, String permanentAddress, BloodGroup bloodGroup) {
        this.employeeName = employeeName;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
        this.permanentAddress = permanentAddress;
        this.bloodGroup = bloodGroup;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "EmployeeRequestDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", bloodGroup=" + bloodGroup +
                '}';
    }
}
