package com.mydata.ems.service;
import java.util.List;

import com.mydata.ems.dto.EmployeeDto;
import com.mydata.ems.exception.ResourceNotFoundException;

public interface EmployeeService {
	
	
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto getEmployeeById(Long empId) throws ResourceNotFoundException; 
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto updateEmployee(Long Id,EmployeeDto ed) throws ResourceNotFoundException;
	public void deleteEmployee(Long Id) throws ResourceNotFoundException;
	
}
