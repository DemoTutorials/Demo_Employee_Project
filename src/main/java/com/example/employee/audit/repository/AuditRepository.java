package com.example.employee.audit.repository;

import com.example.employee.audit.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit,Long> {
}
