package com.ebs.bankhead.main.servicei;


import org.springframework.web.multipart.MultipartFile;


import com.ebs.bankhead.main.model.Employee;

public interface EmployeeServiceI {

	public Iterable<Employee> getAllEmployeeData();

	public Employee onSaveEmployeeData(String employee, MultipartFile employeeImage, MultipartFile employeeAadhar,
			MultipartFile employeePancard);

	public Employee getSingleData(int eId);

	public Employee onUpdateEmployeeData(int eId, String employee, MultipartFile employeeImage,
			MultipartFile employeeAadhar,
			MultipartFile employeePancard);

	public void deletedata(int eId);


}
