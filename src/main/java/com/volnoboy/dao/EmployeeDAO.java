package com.volnoboy.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.volnoboy.HibernateUtils;
import com.volnoboy.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Reuven on 6/29/15.
 */
public class EmployeeDAO {

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to  READ all the employees */
	public List<Employee> getEmployees() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
				Employee employee = (Employee) iterator.next();
				employeeList.add(employee);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeList;
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
