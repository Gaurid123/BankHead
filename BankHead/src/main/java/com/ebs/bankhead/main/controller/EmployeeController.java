package com.ebs.bankhead.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.bankhead.main.servicei.EmployeeServiceI;

@RestController
public class EmployeeController
{
	@Autowired
	EmployeeServiceI esi;
}
