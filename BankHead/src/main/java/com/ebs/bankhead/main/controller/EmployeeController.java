package com.ebs.bankhead.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
