package com.masith.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masith.employee.model.Employee;
import com.masith.employee.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void insert(Employee employee) {
		employeeRepository.insert(employee);
	}

	@Override
	public Employee read(int id) {
		return employeeRepository.read(id);
	}

	@Override
	public List<Employee> readAll() {
		return employeeRepository.readAll();
	}

	@Override
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}
}
