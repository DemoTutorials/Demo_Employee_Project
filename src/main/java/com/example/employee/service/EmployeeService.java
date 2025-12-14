package com.example.employee.service;

import com.example.employee.dto.*;
import com.example.employee.enums.BloodGroup;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
 EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);
 List<EmployeeResponseForGetAll> getAll();
 EmployeeResponseDTO getById(Long id);
 void deleteById(Long id);
 EmployeeResponseDTO update(Long id, EmployeeRequestDTO employeeRequestDTO);
 EmployeeResponseDTO updatePatch(Long id, Map<String, Object> updates);
 EmployeeResponseForGetAll getByNameAndEmail(String name, String email);
 List<EmployeeResponseForGetAll> getByNameOrEmail(String name, String email);
 List<EmployeeResponseForGetAll> getBySalaryBetween(String startingSalary, String endingSalary);
 List<EmployeeResponseForGetAll> getByNameLike(String name);
 List<EmployeeResponseForGetAll> getByName(String name);
 List<EmployeeResponseForGetAll> getByNameIgnoreCase(String name);
 List<EmployeeResponseForGetAll> getByNameContaining(String name);
 List<EmployeeResponseForGetAll> getTop3ByOrderByEmployeeNameDesc();
 List<EmployeeResponseForGetAll> getFirst3ByOrderByEmployeeNameDesc();
 List<EmployeeResponseForGetAll> getAllByOrderByEmployeeNameDesc();
 List<EmployeeResponseForDate> getByBirthDateBefore(String birthDate);
 List<EmployeeResponseForDate> getByBirthDateAfter(String birthDate);
 List<EmployeeResponseForBloodGroup> getDistinctByBloodGroup(BloodGroup bloodGroup);
 List<EmployeeResponseForGetAll> getByNameIn(String name);
 List<EmployeeResponseForGetAll> getByNameNotIn(String name);
 List<EmployeeResponseForGetAll> getByBirthDateIn(String birthDate);
 List<EmployeeResponseForGetAll> getByBirthDateNotIn(String birthDate);
 List<EmployeeResponseForGetAll> getBySalaryIn(String salary);
 List<EmployeeResponseForGetAll> getBySalaryNotIn(String salary);
 EmployeeResponseDTO createAudit(EmployeeRequestDTO employeeRequestDTO);
 EmployeeResponseDTO updateAudit(Long id, EmployeeRequestDTO employeeRequestDTO);
 void DeleteByIdForAudit(Long id);
 EmployeeResponseDTO updatePatchAudit(Long id, Map<String, Object> updates);
 FileDTO uploadFile(Long id, MultipartFile file);
 EmployeeWithFileResponseDTO createEmpWithFile(EmployeeWithFileRequestDTO employeeWithFileRequestDTO);
}
