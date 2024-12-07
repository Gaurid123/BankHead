package com.ebs.bankhead.main.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.bankhead.main.exception.EmployeeNotFoundException;
import com.ebs.bankhead.main.model.Employee;
import com.ebs.bankhead.main.repository.EmployeeRepository;
import com.ebs.bankhead.main.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceI
{
@Autowired
EmployeeRepository er;

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
}
