package com.ebs.bankhead.main.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ebs.bankhead.main.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeControllerAdvice 
{
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> employeesNotFound(EmployeeNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
