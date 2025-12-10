package com.example.employee.dto;

public class EmployeeResponseForGetAll {
    private Long employeeId;
    private String employeeName;

    public EmployeeResponseForGetAll() {
    }

    public EmployeeResponseForGetAll(Long employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
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

    @Override
    public String toString() {
        return "EmployeeResponseForGetAll{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
