package com.binu.springboot.employeecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.binu.springboot.employeecrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// entity manager
	private EntityManager entityManager;
	
	// set up constructor injection of entity manager that is automatically created by Spring Boot
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
		
	}
	
	
	@Override
	@Transactional // handles transaction management so we don't have to manually start and commit transactions
	public List<Employee> findAll() {
		
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query using native Hibernate API
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

}
