package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeRequestDTO;
import com.example.employee.dto.EmployeeResponseDTO;
import com.example.employee.dto.EmployeeResponseForGetAll;
import com.example.employee.entity.Employee;
import com.example.employee.enums.BloodGroup;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        Employee newEmployee = employeeRepository.save(employee);
        return modelMapper.map(newEmployee, EmployeeResponseDTO.class);
    }

    @Override
    public List<EmployeeResponseForGetAll> getAll() {
        List<Employee> listOfEmployees = employeeRepository.findAll();
        List<EmployeeResponseForGetAll> list = listOfEmployees.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public EmployeeResponseDTO getById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee Not Found with Id" + id));
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        boolean existsById = employeeRepository.existsById(id);
        if(!existsById){
            throw new RuntimeException("Employee Not found By ID"+id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee Not Found By ID" + id));
        modelMapper.map(employeeRequestDTO,employee);
        Employee newEmployee = employeeRepository.save(employee);
        return modelMapper.map(newEmployee, EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO updatePatch(Long id, Map<String, Object> updates) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee Not Found By ID" + id));
        updates.forEach((field,value)->{
            switch(field){
                case "employeeName":employee.setEmployeeName((String) value);
                break;
                case "email":employee.setEmail((String) value);
                break;
                case "birthDate":
                    if(value instanceof String){
                        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                        employee.setBirthDate(LocalDate.parse((String) value,dateTimeFormatter));
                    }
                    break;
                case "salary":
                    if(value instanceof Double){
                        employee.setSalary(BigDecimal.valueOf((Double) value));
                    }
                    break;
                case "permanentAddress":employee.setPermanentAddress((String) value);
                    break;
                case "bloodGroup":
                    if(value instanceof String){
                        employee.setBloodGroup(BloodGroup.valueOf((String) value));
                    }else if(value instanceof BloodGroup){
                        employee.setBloodGroup((BloodGroup) value);
                    }
                    break;
                default:
                    throw new RuntimeException("Field is Not Supported");
            }
        });
        Employee newEmployee = employeeRepository.save(employee);
        return modelMapper.map(newEmployee, EmployeeResponseDTO.class);
    }
}
