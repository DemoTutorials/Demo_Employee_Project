package com.example.employee.service.impl;

import com.example.employee.dto.*;
import com.example.employee.entity.Employee;
import com.example.employee.enums.BloodGroup;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


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

    @Override
    public EmployeeResponseForGetAll getByNameAndEmail(String name, String email) {
        Employee employee = employeeRepository.findByEmployeeNameAndEmail(name, email).orElseThrow(() -> new IllegalArgumentException("Employee Not Found with NAME & EMAIL" + name + " " + email+" "));
        return modelMapper.map(employee, EmployeeResponseForGetAll.class);
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameOrEmail(String name, String email) {
        List<Employee> employeeNameOrEmail = employeeRepository.findByEmployeeNameOrEmail(name, email);
        List<EmployeeResponseForGetAll> NewEmployeeNameOrEmail = employeeNameOrEmail.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return NewEmployeeNameOrEmail;
    }

    @Override
    public List<EmployeeResponseForGetAll> getBySalaryBetween(String startingSalary, String endingSalary) {
        List<Employee> bySalaryBetween = employeeRepository.findBySalaryBetween(startingSalary, endingSalary);
        List<EmployeeResponseForGetAll> list = bySalaryBetween.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameLike(String name) {
        List<Employee> byEmployeeNameLike = employeeRepository.findByEmployeeNameLike(name);
        List<EmployeeResponseForGetAll> list = byEmployeeNameLike.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByName(String name) {
        List<Employee> byEmployeeName = employeeRepository.findByEmployeeName(name);
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameIgnoreCase(String name) {
        List<Employee> byEmployeeName = employeeRepository.findByEmployeeNameIgnoreCase(name);
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameContaining(String name) {
        List<Employee> byEmployeeName = employeeRepository.findByEmployeeNameContaining(name);
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getTop3ByOrderByEmployeeNameDesc() {
        List<Employee> byEmployeeName = employeeRepository.findTop3ByOrderByEmployeeNameDesc();
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getFirst3ByOrderByEmployeeNameDesc() {
        List<Employee> byEmployeeName = employeeRepository.findFirst3ByOrderByEmployeeNameDesc();
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getAllByOrderByEmployeeNameDesc() {
        List<Employee> byEmployeeName = employeeRepository.findAllByOrderByEmployeeNameDesc();
        List<EmployeeResponseForGetAll> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForDate> getByBirthDateBefore(String birthDate) {
        LocalDate date = LocalDate.parse(birthDate);
        List<Employee> byEmployeeName = employeeRepository.findByBirthDateBefore(date);
        List<EmployeeResponseForDate> list = byEmployeeName.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForDate.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForDate> getByBirthDateAfter(String birthDate) {
        LocalDate date = LocalDate.parse(birthDate);
        List<Employee> byBirthDateAfter = employeeRepository.findByBirthDateAfter(date);
        List<EmployeeResponseForDate> list = byBirthDateAfter.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForDate.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForBloodGroup> getDistinctByBloodGroup(BloodGroup bloodGroup) {
        List<Employee> byDistinctBloodGroup = employeeRepository.findDistinctByBloodGroup(bloodGroup);
        List<EmployeeResponseForBloodGroup> list= byDistinctBloodGroup.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForBloodGroup.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameIn(String name) {
        List<String> names = Arrays.asList(name.split(",")).stream().toList();
        List<Employee> byEmployeeNameIn = employeeRepository.findByEmployeeNameIn(names);
        List<EmployeeResponseForGetAll> list = byEmployeeNameIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByNameNotIn(String name) {
        List<String> names = Arrays.asList(name.split(",")).stream().toList();
        List<Employee> byEmployeeNameIn = employeeRepository.findByEmployeeNameNotIn(names);
        List<EmployeeResponseForGetAll> list = byEmployeeNameIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByBirthDateIn(String birthDate) {
        List<LocalDate> dates = Arrays.asList(birthDate.split(",")).stream().map(LocalDate::parse).toList();
        List<Employee> byBirthDateIn = employeeRepository.findByBirthDateIn(dates);
        List<EmployeeResponseForGetAll> list = byBirthDateIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getByBirthDateNotIn(String birthDate) {
        List<LocalDate> dates = Arrays.asList(birthDate.split(",")).stream().map(LocalDate::parse).toList();
        List<Employee> byBirthDateIn = employeeRepository.findByBirthDateNotIn(dates);
        List<EmployeeResponseForGetAll> list = byBirthDateIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getBySalaryIn(String salary) {
        List<BigDecimal> salarys = Arrays.asList(salary.split(",")).stream().map(BigDecimal::new).toList();
        List<Employee> bySalaryIn = employeeRepository.findBySalaryIn(salarys);
        List<EmployeeResponseForGetAll> list = bySalaryIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }

    @Override
    public List<EmployeeResponseForGetAll> getBySalaryNotIn(String salary) {
        List<BigDecimal> salarys = Arrays.asList(salary.split(",")).stream().map(BigDecimal::new).toList();
        List<Employee> bySalaryNotIn = employeeRepository.findBySalaryNotIn(salarys);
        List<EmployeeResponseForGetAll> list = bySalaryNotIn.stream().map(employee -> modelMapper.map(employee, EmployeeResponseForGetAll.class)).toList();
        return list;
    }


}
