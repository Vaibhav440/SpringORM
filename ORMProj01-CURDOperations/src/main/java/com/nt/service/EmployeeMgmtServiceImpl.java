//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IEmployeeDAO;
import com.nt.entity.Employee;

@Service("empService")
@Transactional(propagation = Propagation.REQUIRED)  // enables   commit or rollback activities to perform
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO  empDAO;

	public String registerEmployee(Employee emp) {
		//use  DAO
		int idVal=empDAO.insertEmployee(emp);
		return "Employee is registered with the idVal"+idVal;
	}

	public List<Employee> fetchAllEmployees() {
		//use dAO
		return (List<Employee>) empDAO.getAllEmployees();
	}

	public Employee fetchEmployeeByNo(int no) {
		//use dAO
		return empDAO.getEmployeeByNo(no);
	}

	public String hikeEmployeSalary(int eno, double percentage) {
		 //get existing salary of the employee
		Employee emp=fetchEmployeeByNo(eno);
		double salary=emp.getSalary();
		salary=salary+ (salary*percentage/100.0);
		//use DAO
		String result=empDAO.updateEmpSalary(eno, salary);
		return result;
	}

	public String removeEmployeeByNo(int eno) {
	    //use DAO
		String result=empDAO.deteleEmployee(eno);
		return  result;
	}

}
