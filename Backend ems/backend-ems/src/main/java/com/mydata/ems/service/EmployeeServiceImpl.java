package com.mydata.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mydata.ems.dto.EmployeeDto;
import com.mydata.ems.entity.Employee;
import com.mydata.ems.exception.ResourceNotFoundException;
import com.mydata.ems.mapper.EmployeeMapper;
import com.mydata.ems.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) 
	{
		super();
		this.employeeRepository=employeeRepository;
		
	}
	
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployeeDto(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
	
		EmployeeDto edto=EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return edto;
	}


	@Override
	public EmployeeDto getEmployeeById(Long empId) throws ResourceNotFoundException 
	{
	
		Employee emp= employeeRepository.findById(empId)
				.orElseThrow(() ->
		new ResourceNotFoundException("employee is not exit with given id: "+empId));
		
		
		return EmployeeMapper.mapToEmployeeDto(emp);
	}


	public List<EmployeeDto> getAllEmployees() {

		List<Employee> allEmp=employeeRepository.findAll();
		
		return allEmp.stream()
				.map((Employess)->EmployeeMapper.mapToEmployeeDto(Employess))
				.collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updateEmployee(Long Id, EmployeeDto ed) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee e= employeeRepository.findById(Id)
				.orElseThrow(
						() ->new ResourceNotFoundException("employee is not exit with given id :"+Id));
		e.setFirstName(ed.getFirstName());
		e.setLastName(ed.getLastName());
		e.setEmail(ed.getEmail());
		
		Employee updatedEmp =employeeRepository.save(e);
		return EmployeeMapper.mapToEmployeeDto(updatedEmp);
	}


	@Override
	public void deleteEmployee(Long Id) throws ResourceNotFoundException {
		Employee e= employeeRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("employee is not exist with given id:"+Id));
		employeeRepository.deleteById(Id);
		
	}




	
	
	
	
	


	

}