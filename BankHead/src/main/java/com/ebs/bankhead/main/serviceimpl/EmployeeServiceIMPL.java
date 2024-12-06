package com.ebs.bankhead.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.bankhead.main.repository.EmployeeRepository;
import com.ebs.bankhead.main.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceI
{
@Autowired
EmployeeRepository er;
}
