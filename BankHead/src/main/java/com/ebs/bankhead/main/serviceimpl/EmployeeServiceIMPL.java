package com.ebs.bankhead.main.serviceimpl;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.bankhead.main.exception.EmployeeNotFoundException;

import com.ebs.bankhead.main.model.Employee;
import com.ebs.bankhead.main.repository.EmployeeRepository;
import com.ebs.bankhead.main.servicei.EmployeeServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceI
{
@Autowired
EmployeeRepository er;
@Autowired
ObjectMapper objmapper;


@Override
public Iterable<Employee> getAllEmployeeData() {
	// TODO Auto-generated method stub
	
	
	if(er.findAll().isEmpty())
	{
		throw new EmployeeNotFoundException("Data is not Found");
	}
	else {
		return er.findAll();
	}
}

@Override
public Employee onSaveEmployeeData(String employee, MultipartFile employeeImage, MultipartFile employeeAadhar,
		MultipartFile employeePancard) {
	   
	Employee emp=null;
	try {
		 emp = objmapper.readValue(employee, Employee.class);
		if(!employeeImage.isEmpty())emp.setEmployeeImage(employeeImage.getBytes());
		if(!employeeAadhar.isEmpty())emp.setEmployeeAadhar(employeeAadhar.getBytes());
		if(!employeePancard.isEmpty())emp.setEmployeePancard(employeePancard.getBytes());
     
		er.save(emp);
		
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	return emp;
	

}
@Override
public Employee getSingleData(int employeeId) 
{
	
	return er.findById(employeeId).get();
	
}
}
