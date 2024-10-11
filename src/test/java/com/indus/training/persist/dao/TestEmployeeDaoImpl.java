package com.indus.training.persist.dao;

import java.sql.Date;
import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.impl.EmployeeDaoImpl;

import junit.framework.TestCase;

public class TestEmployeeDaoImpl extends TestCase {

	private EmployeeDaoImpl empDaoImplObj = null;

	protected void setUp() throws Exception {
		empDaoImplObj = new EmployeeDaoImpl();
	}

	protected void tearDown() throws Exception {
		empDaoImplObj = null;
	}

	public void testInsertEmployee() {
		try {
			Employee employee = new Employee();
			employee.setFirstName("John");
			employee.setLastName("Doe");
			Boolean result = empDaoImplObj.insertEmployee(employee);
			assertTrue("Employee should be inserted", result);
			empDaoImplObj.deleteEmployeeById(employee.getEmployeeId());
		} catch (Exception e) {
			fail("Exception thrown during testInsertEmployee: " + e.getMessage());
		}
	}

	public void testFetchEmployeeById() {
		try {
			Employee employee = new Employee();
			employee.setFirstName("Dhruthi");
			employee.setLastName("Bade");
			empDaoImplObj.insertEmployee(employee);
			Employee fetchedEmployee = empDaoImplObj.fetchEmployeeById(employee.getEmployeeId());
			assertNotNull("Employee should be fetched", employee);
			assertEquals(fetchedEmployee.getEmployeeId(), employee.getEmployeeId());
			empDaoImplObj.deleteEmployeeById(employee.getEmployeeId());
		} catch (Exception e) {
			fail("Exception thrown during testFetchEmployeeById: " + e.getMessage());
		}
	}

//	public void testDeleteEmployeeById() {
//		try {
//			Employee employee = new Employee();
//			employee.setFirstName("Navya");
//			employee.setLastName("Bade");
//			Boolean result = empDaoImplObj.insertEmployee(employee);
//			assertTrue("Employee should be inserted", result);
//			empDaoImplObj.deleteEmployeeById(employee.getEmployeeId());
//			Employee deletedEmployee = empDaoImplObj.fetchEmployeeById(employee.getEmployeeId());
//			assertNull("Employee should no longer exist", deletedEmployee);
//		} catch (Exception e) {
//			fail("Exception thrown during testDeleteEmployeeById: " + e.getMessage());
//		}
//	}

}
