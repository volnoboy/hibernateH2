package com.volnoboy.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.volnoboy.dao.EmployeeDAO;
import com.volnoboy.entity.Employee;

public class EmployeeService {

	static EmployeeDAO dao = new EmployeeDAO();

	public static void main(String[] args) throws SQLException, IOException {

		// Add few employee records in database
		List<Employee> employeeList =  generateEmployees();
		for (Employee employee : employeeList) {
			employee.setId(dao.addEmployee(employee));
		}

		// List down all the employees
		Arrays.deepToString(dao.getEmployees().toArray());

		// Update employee's records
		employeeList.get(0).setSalary(770);
		dao.updateEmployee(employeeList.get(0));

		// Delete an employee from the database
		dao.deleteEmployee(employeeList.get(0));

	}

	public static List<Employee> generateEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee1 = new Employee();
		employee1.setFirstName("Valera");
		employee1.setLastName("Tutu");
		employee1.setSalary(250);
		employeeList.add(employee1);

		Employee employee2 = new Employee();
		employee2.setFirstName("Petya");
		employee2.setLastName("Fela");
		employee2.setSalary(450);
		employeeList.add(employee2);

		Employee employee3 = new Employee();
		employee3.setFirstName("Leha");
		employee3.setLastName("Leshiy");
		employee3.setSalary(150);
		employeeList.add(employee3);

		return employeeList;
	}


}