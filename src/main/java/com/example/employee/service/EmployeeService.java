package com.example.employee.service;

import com.example.employee.dto.EmployeeRequestDTO;
import com.example.employee.dto.EmployeeResponseDTO;
import com.example.employee.dto.EmployeeResponseForGetAll;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
 EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);
 List<EmployeeResponseForGetAll> getAll();
 EmployeeResponseDTO getById(Long id);
 void deleteById(Long id);
 EmployeeResponseDTO update(Long id, EmployeeRequestDTO employeeRequestDTO);
 EmployeeResponseDTO updatePatch(Long id, Map<String, Object> updates);
}
