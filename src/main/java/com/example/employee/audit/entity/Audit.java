package com.example.employee.audit.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "Audit",schema = "employee")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entityType;
    private Long entityId;
    private String operation;
    private String oldValue;
    private String newValue;
    @CreatedDate
    private LocalDateTime createdAt;

    @PrePersist
    protected void create(){
        createdAt=LocalDateTime.now();
    }

    public Audit() {
    }

    public Audit(Long id, String entityType, Long entityId, String operation, String oldValue, String newValue, LocalDateTime createdAt) {
        this.id = id;
        this.entityType = entityType;
        this.entityId = entityId;
        this.operation = operation;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.createdAt = createdAt;
    }

    public Audit(String entityType, Long entityId, String operation, String oldValue, String newValue) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.operation = operation;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", entityType='" + entityType + '\'' +
                ", entityId=" + entityId +
                ", operation='" + operation + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
