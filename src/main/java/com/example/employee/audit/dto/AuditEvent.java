package com.example.employee.audit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditEvent {
    private String entityType;
    private Long entityId;
    private String operation;
    private String oldValue;
    private String newValue;

    public AuditEvent() {
    }

    public AuditEvent(String entityType, Long entityId, String operation, String oldValue, String newValue) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.operation = operation;
        this.oldValue = oldValue;
        this.newValue = newValue;
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

    @Override
    public String toString() {
        return "AuditEvent{" +
                "entityType='" + entityType + '\'' +
                ", entityId=" + entityId +
                ", operation='" + operation + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}
