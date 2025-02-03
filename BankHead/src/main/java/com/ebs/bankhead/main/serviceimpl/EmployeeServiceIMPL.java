package com.ebs.bankhead.main.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.bankhead.main.exception.EmployeeNotFoundException;

import com.ebs.bankhead.main.model.Employee;
import com.ebs.bankhead.main.repository.EmployeeRepository;
import com.ebs.bankhead.main.servicei.EmployeeServiceI;
import com.ebs.bankhead.main.utility.EmployeeUtility;
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
//		emp.setEmployeeUsername("Easybank"+1144);
//		emp.setEmployeePassword("Easybank@"+2244);
//		
		emp.setEmployeeUsername(EmployeeUtility.getUsername(emp.getEmployeeName()));
		emp.setEmployeePassword(EmployeeUtility.getPassword(emp.getEmployeeName()));
     
		er.save(emp);
		
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	return emp;
	

}

public Employee getSingleData(int eId) {

	
		return er.findById(eId).get();
	
}

@Override
public Employee onUpdateEmployeeData(int eId, String employee, MultipartFile employeeImage,
		MultipartFile employeeAadhar, MultipartFile employeePancard) {
	// TODO Auto-generated method stub
	
	Optional<Employee> id = er.findById(eId);
	Employee emp=null;
	if(id.isPresent())
	{
		
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
		
	}
	return emp;
}

@Override
public Employee statusDataUpdate(int eId, String employee, MultipartFile employeeImage, MultipartFile employeeAadhar) {
	
	Optional<Employee> id = er.findById(eId);
	Employee emp=null;
	if(id.isPresent())
	{
		
		try {
			 emp = objmapper.readValue(employee, Employee.class);
			if(!employeeImage.isEmpty())emp.setEmployeeImage(employeeImage.getBytes());
			if(!employeeAadhar.isEmpty())emp.setEmployeeAadhar(employeeAadhar.getBytes());
			
			er.save(emp);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	return emp;
}

@Override
public Employee employeelogi(String username, String password) {
	// TODO Auto-generated method stub
	return er.findByEmployeeUsernameAndEmployeePassword(username, password).get();
}

@Override
public Employee deleteEmployeeById(int eId) 
{ 
 
	Optional<Employee> idRef = er.findById(eId);
	Employee emp=null;
	if(idRef.isPresent())
	{
		er.deleteById(eId);
	}
	else {
		throw new EmployeeNotFoundException("Given Employee eId is not Present :"+eId);
	}
	return emp;
	
	
}
}
