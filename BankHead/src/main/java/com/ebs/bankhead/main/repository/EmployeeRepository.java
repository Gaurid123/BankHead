package com.ebs.bankhead.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.bankhead.main.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

	public Optional<Employee> findByEmployeeUsernameAndEmployeePassword(String username,String password);
}
