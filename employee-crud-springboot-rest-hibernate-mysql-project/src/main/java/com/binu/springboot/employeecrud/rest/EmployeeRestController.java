package com.binu.springboot.employeecrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binu.springboot.employeecrud.dao.EmployeeDAO;
import com.binu.springboot.employeecrud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	
	private EmployeeDAO employeeDAO;
	
	// inject employee dao using constructor injection
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}
	
	// expose "/employees" endpoint and return list of all employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeDAO.findAll();
	}
	
	
	
	
}
