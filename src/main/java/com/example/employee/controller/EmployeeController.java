package com.example.employee.controller;

import com.example.employee.dto.EmployeeRequestDTO;
import com.example.employee.dto.EmployeeResponseDTO;
import com.example.employee.dto.EmployeeResponseForGetAll;
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
}
