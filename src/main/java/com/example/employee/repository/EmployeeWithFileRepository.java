package com.example.employee.repository;
import com.example.employee.entity.EmployeeWithFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeWithFileRepository extends JpaRepository<EmployeeWithFile,Long> {

}
