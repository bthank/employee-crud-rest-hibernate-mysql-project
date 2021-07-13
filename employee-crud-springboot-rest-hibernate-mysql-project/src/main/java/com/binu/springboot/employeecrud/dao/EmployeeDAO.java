package com.binu.springboot.employeecrud.dao;

import java.util.List;

import com.binu.springboot.employeecrud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
