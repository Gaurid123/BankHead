package com.ebs.bankhead.main.servicei;

import org.springframework.web.multipart.MultipartFile;

import com.ebs.bankhead.main.model.Employee;

public interface EmployeeServiceI {

	public Employee onSaveEmployeeData(String employee, MultipartFile employeeImage, MultipartFile employeeAadhar,
			MultipartFile employeePancard);

}
