package com.example.employee.repository;

import com.example.employee.entity.Employee;
import com.example.employee.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmployeeNameAndEmail(String name, String email);
    List<Employee> findByEmployeeNameOrEmail(String name, String email);
    List<Employee> findBySalaryBetween(String startingSalary, String endingSalary);
    List<Employee> findByEmployeeNameLike(String name);
    List<Employee> findByEmployeeName(String name);
    List<Employee> findByEmployeeNameIgnoreCase(String name);
    List<Employee> findByEmployeeNameContaining(String name);
    List<Employee> findTop3ByOrderByEmployeeNameDesc();
    List<Employee> findFirst3ByOrderByEmployeeNameDesc();
    List<Employee> findAllByOrderByEmployeeNameDesc();
    List<Employee> findByBirthDateBefore(LocalDate birthDate);
    List<Employee> findByBirthDateAfter(LocalDate birthDate);
    List<Employee> findDistinctByBloodGroup(BloodGroup bloodGroup);
    List<Employee> findByEmployeeNameIn(List<String> names);
    List<Employee> findByEmployeeNameNotIn(List<String> names);
    List<Employee> findByBirthDateIn(List<LocalDate> dates);
    List<Employee> findByBirthDateNotIn(List<LocalDate> dates);
    List<Employee> findBySalaryIn(List<BigDecimal> salary);
    List<Employee> findBySalaryNotIn(List<BigDecimal> salary);
}
