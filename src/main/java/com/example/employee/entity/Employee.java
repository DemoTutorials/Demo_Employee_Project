package com.example.employee.entity;

import com.example.employee.encryption_configuration.encryption_converters.EncryptedLocalDateConverter;
import com.example.employee.encryption_configuration.encryption_converters.EncryptedStringConverter;
import com.example.employee.enums.BloodGroup;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "emp",schema = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "name",nullable = false)
    private String employeeName;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Convert(converter = EncryptedLocalDateConverter.class)
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name = "salary",nullable = false)
    private BigDecimal salary;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "permanent_address",nullable = false)
    private String permanentAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group",nullable = false)
    private BloodGroup bloodGroup;

    @CreatedDate
    @Column(name = "created_datetime")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_datetime")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void create(){
        createdAt=LocalDateTime.now();
    }

    @PreUpdate
    protected void update(){
        updatedAt=LocalDateTime.now();
    }

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String email, LocalDate birthDate, BigDecimal salary, String permanentAddress, BloodGroup bloodGroup, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
        this.permanentAddress = permanentAddress;
        this.bloodGroup = bloodGroup;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", bloodGroup=" + bloodGroup +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
