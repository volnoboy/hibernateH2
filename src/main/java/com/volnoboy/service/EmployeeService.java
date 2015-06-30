package com.volnoboy.service;

import com.volnoboy.dao.EmployeeDAO;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeService {

	public static void main(String[] args) throws SQLException, IOException {

		EmployeeDAO dao = new EmployeeDAO();

      /* Add few employee records in database */
		Integer empID1 = dao.addEmployee("Zaras", "Ali", 1000);
		Integer empID2 = dao.addEmployee("Daisy", "Das", 5000);
		Integer empID3 = dao.addEmployee("John", "Paul", 10000);

      /* List down all the employees */
		dao.listEmployees();

      /* Update employee's records */
		dao.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
		dao.deleteEmployee(empID2);

      /* List down new list of the employees */
		dao.listEmployees();


	}


}