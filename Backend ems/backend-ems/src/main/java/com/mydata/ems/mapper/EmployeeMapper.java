package com.mydata.ems.mapper;

import com.mydata.ems.dto.EmployeeDto;
import com.mydata.ems.entity.Employee;
// Mapper is created to convert Employee entity to employeeDto and
//employeeDto to employee Entity

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee e) {
		return new EmployeeDto(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail());
		
		
	}
	
	public static Employee mapToEmployeeDto(EmployeeDto eDto ) {
		return new Employee(eDto.getId(),eDto.getFirstName(),eDto.getLastName(),eDto.getEmail());
		
		
	}

}
