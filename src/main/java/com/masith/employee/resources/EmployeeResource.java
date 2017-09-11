package com.masith.employee.resources;

import com.masith.employee.model.Employee;
import com.masith.employee.service.EmployeeService;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> readAll(){
		return employeeService.readAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee read(@PathParam("id") int id) {
		return employeeService.read(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Employee insert(Employee employee) {
		employeeService.insert(employee);
		return employee;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Employee update(Employee employee) {
		employeeService.update(employee);
		return employee;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee delete(@PathParam("id") int id) {
		Employee employee = employeeService.read(id);
		employeeService.delete(employee);
		return employee;
	}
	
}
