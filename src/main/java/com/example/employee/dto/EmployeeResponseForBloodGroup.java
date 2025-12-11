package com.example.employee.dto;

import com.example.employee.enums.BloodGroup;

public class EmployeeResponseForBloodGroup {
    private Long employeeId;
    private String employeeName;
    private BloodGroup bloodGroup;

    public EmployeeResponseForBloodGroup() {
    }

    public EmployeeResponseForBloodGroup(Long employeeId, String employeeName, BloodGroup bloodGroup) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.bloodGroup = bloodGroup;
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

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "EmployeeResponseForBloodGroup{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", bloodGroup=" + bloodGroup +
                '}';
    }
}
