package com.example.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EmployeeResponseForDate {
    private Long employeeId;
    private String employeeName;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private LocalDate birthDate;

    public EmployeeResponseForDate() {
    }

    public EmployeeResponseForDate(Long employeeId, String employeeName, LocalDate birthDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "EmployeeResponseForDate{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
