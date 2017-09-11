package com.masith.employee.service;

import java.util.List;

import com.masith.employee.model.Employee;

public interface EmployeeService {

	
	public void insert(Employee employee);
	public Employee read(int id);
	public List<Employee> readAll();
	public void update(Employee employee);
	public void delete(Employee employee);


}
