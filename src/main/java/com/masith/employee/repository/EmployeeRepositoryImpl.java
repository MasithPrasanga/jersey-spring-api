package com.masith.employee.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.masith.employee.model.Employee;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
private static Map<Integer,Employee> employeeMap = new HashMap<Integer,Employee>();
	
	static {
		
		Employee employee1 = new Employee(1,"masith","prasanga",1000000);
		Employee employee2 = new Employee(2,"krishantha","dinesh",8000000);
		Employee employee3 = new Employee(3,"james","gosling",1200000);
		Employee employee4 = new Employee(4,"rod","jonson",500000000);
		
		employeeMap.put(1,employee1);
		employeeMap.put(2,employee2);
		employeeMap.put(3,employee3);
		employeeMap.put(4,employee4);
		
	}

	@Override
	public void insert(Employee employee) {
		int id = findMaxId();
		employee.setId(id+1);
		employeeMap.put(employee.getId(),employee);
	}

	@Override
	public Employee read(int id) {
		return employeeMap.get(id);
	}

	@Override
	public List<Employee> readAll() {
		List<Employee> employeeList = new ArrayList<Employee>(employeeMap.values());
		return employeeList;
	}

	@Override
	public void update(Employee employee) {
		employeeMap.put(employee.getId(), employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeMap.remove(employee.getId());
	}
	
	public static int findMaxId() {
		int maxId = 0;
		for(int id : employeeMap.keySet()) {
			if(maxId <= id) {
				maxId = id;
			}
		}
		return maxId;
	}

}
