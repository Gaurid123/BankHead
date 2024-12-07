package com.ebs.bankhead.main.exception;

public class EmployeeNotFoundException extends RuntimeException
{

	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
}
