//SpringORMTest.java
package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

public class SpringORMTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class obj ref
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		// invoke the b.method
		try {
			// prepare Employee class object
			Employee emp = new Employee();
			emp.setEmpname("rajesh");
			emp.setDesg("CLERK");
			emp.setSalary(80000.0);
			String msg = service.registerEmployee(emp);
			System.out.println(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("=== All  the employee records are===");
			List<Employee> list = service.fetchAllEmployees();
			list.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("Getting single record");
			Employee emp = service.fetchEmployeeByNo(1);
			System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("===== update operation=====");
			String result = service.hikeEmployeSalary(1, 10.0);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("===== delete operation=====");
			String result = service.removeEmployeeByNo(1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}// class
