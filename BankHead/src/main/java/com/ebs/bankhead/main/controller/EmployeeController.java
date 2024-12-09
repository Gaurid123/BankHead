package com.ebs.bankhead.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.bankhead.main.model.Employee;
import com.ebs.bankhead.main.servicei.EmployeeServiceI;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
	@Autowired
	EmployeeServiceI esi;

	
	@GetMapping("/get-employee")
	public ResponseEntity<Iterable<Employee>> getAllEmployee()
	{
		Iterable<Employee> getemployee=esi.getAllEmployeeData();
		return new ResponseEntity<Iterable<Employee>>(getemployee,HttpStatus.OK);
	}
	@PostMapping("/add-employee") 
	public ResponseEntity<Employee> onsave(@RequestPart("data")String employee,@RequestPart("eImage")MultipartFile employeeImage,@RequestPart("eAadhar")MultipartFile employeeAadhar,@RequestPart("epancard")MultipartFile employeePancard)
	{
		Employee empdata=esi.onSaveEmployeeData(employee,employeeImage,employeeAadhar,employeePancard);
		return new ResponseEntity<Employee>(empdata,HttpStatus.CREATED);

	}
	
}
