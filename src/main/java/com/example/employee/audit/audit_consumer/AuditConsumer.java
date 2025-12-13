package com.example.employee.audit.audit_consumer;

import com.example.employee.audit.dto.AuditEvent;
import com.example.employee.audit.entity.Audit;
import com.example.employee.audit.repository.AuditRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AuditConsumer {

    private final AuditRepository auditRepository;

    public AuditConsumer(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @KafkaListener(topics = "emp-topic",groupId = "emp-group")
    public void consumeMessage(AuditEvent auditEvent){
        Audit audit=new Audit(auditEvent.getEntityType(),auditEvent.getEntityId(),auditEvent.getOperation(),auditEvent.getOldValue(),auditEvent.getNewValue());
        auditRepository.save(audit);
    }
}
