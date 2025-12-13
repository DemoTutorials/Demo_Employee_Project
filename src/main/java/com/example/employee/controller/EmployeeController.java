package com.example.employee.controller;

import com.example.employee.dto.*;
import com.example.employee.enums.BloodGroup;
import com.example.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.create(employeeRequestDTO));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(id,employeeRequestDTO));
    }

    // UPDATE SPECIFIC FIELD
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updatePatch(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updatePatch(id,updates));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<EmployeeResponseForGetAll>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    // REST APIs

    // AND
    @GetMapping("/{name}/{email}")
    public ResponseEntity<EmployeeResponseForGetAll> getByNameAndEmail(@PathVariable String name, @PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameAndEmail(name,email));
    }

    // OR
    @GetMapping("/getByNameOrEmail/{name}/{email}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameOrEmail(@PathVariable String name, @PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameOrEmail(name,email));
    }

    // BETWEEN
    @GetMapping("/getBySalaryBetween/{startingSalary}/{endingSalary}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getBySalaryBetween(@PathVariable String startingSalary, @PathVariable String endingSalary){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalaryBetween(startingSalary,endingSalary));
    }

    // LIKE
    @GetMapping("/getByNameLike/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameLike(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameLike(name));
    }

    // SELECT BY NAME
    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByName(name));
    }

    // SELECT BY NAME IGNORE CASE --> Case-Insensitive
    @GetMapping("/getByNameIgnoreCase/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameIgnoreCase(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameIgnoreCase(name));
    }

    // SELECT BY NAME CONTAINING
    @GetMapping("/getByNameContaining/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameContaining(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameContaining(name));
    }

    // GET TOP 3 ORDER BY NAME DESC
    @GetMapping("/getTop3ByOrderByEmployeeNameDesc")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getTop3ByOrderByEmployeeNameDesc(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getTop3ByOrderByEmployeeNameDesc());
    }

    // GET First 3 ORDER BY NAME DESC
    @GetMapping("/getFirst3ByOrderByEmployeeNameDesc")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getFirst3ByOrderByEmployeeNameDesc(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getFirst3ByOrderByEmployeeNameDesc());
    }

    // GET ALL ORDER BY NAME DESC
    @GetMapping("/getAllByOrderByEmployeeNameDesc")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getAllByOrderByEmployeeNameDesc(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllByOrderByEmployeeNameDesc());
    }

    // GET BY BIRTHDATE BEFORE
    @GetMapping("/getByBirthDateBefore/{birthDate}")
    public ResponseEntity<List<EmployeeResponseForDate>> getByBirthDateBefore(@PathVariable String birthDate){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByBirthDateBefore(birthDate));
    }

    // GET BY BIRTHDATE AFTER
    @GetMapping("/getByBirthDateAfter/{birthDate}")
    public ResponseEntity<List<EmployeeResponseForDate>> getByBirthDateAfter(@PathVariable String birthDate){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByBirthDateAfter(birthDate));
    }

    // GET BY DISTINCT BLOOD-GROUP
    @GetMapping("/getDistinctByBloodGroup/{bloodGroup}")
    public ResponseEntity<List<EmployeeResponseForBloodGroup>> getDistinctByBloodGroup(@PathVariable BloodGroup bloodGroup){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getDistinctByBloodGroup(bloodGroup));
    }

    // IN
    @GetMapping("/getByNameIn/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameIn(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameIn(name));
    }

    // Not-IN
    @GetMapping("/getByNameNotIn/{name}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByNameNotIn(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByNameNotIn(name));
    }

    // IN
    @GetMapping("/getByBirthDateIn/{birthDate}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByBirthDateIn(@PathVariable String birthDate){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByBirthDateIn(birthDate));
    }

    // NOT-IN
    @GetMapping("/getByBirthDateNotIn/{birthDate}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getByBirthDateNotIn(@PathVariable String birthDate){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByBirthDateNotIn(birthDate));
    }

    // IN
    @GetMapping("/getBySalaryIn/{salary}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getBySalaryIn(@PathVariable String salary){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalaryIn(salary));
    }

    // Not-IN
    @GetMapping("/getBySalaryNotIn/{salary}")
    public ResponseEntity<List<EmployeeResponseForGetAll>> getBySalaryNotIn(@PathVariable String salary){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalaryNotIn(salary));
    }

    // Audit

    // CREATE-AUDIT
    @PostMapping("/createAudit")
    public ResponseEntity<EmployeeResponseDTO> createAudit(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createAudit(employeeRequestDTO));
    }

    // UPDATE-AUDIT
    @PutMapping("/updateAudit/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateAudit(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateAudit(id,employeeRequestDTO));
    }

    // UPDATE & AUDIT SPECIFIC FIELD
    @PatchMapping("/PatchAudit/{id}")
    public ResponseEntity<EmployeeResponseDTO> updatePatchAudit(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updatePatchAudit(id,updates));
    }

    // DELETE-AUDIT
    @DeleteMapping("/DeleteByIdForAudit/{id}")
    public ResponseEntity<Void> DeleteByIdForAudit(@PathVariable Long id){
        employeeService.DeleteByIdForAudit(id);
        return ResponseEntity.noContent().build();
    }
}
