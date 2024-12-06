package com.ebs.bankhead.main.model;

import java.util.Date;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int employeeId;
	private String employeeName;
	private String employeeDesignation;
	private String employeeAddress;
	private long employeeMobileno;
	private String employeeBranchname;
	private String employeeEmail;
	private String employeeUsername;
	private String employeePassword;
	private boolean isActive;
	private Date employeeRegisteredon;
	@Lob
	@Column(length=999999999)
	private byte[] employeeImage;
	@Lob
	@Column(length=999999999)
	private byte[] employeeAadhar;
	@Lob
	@Column(length=999999999)
	private byte[] employeePancard;
}
