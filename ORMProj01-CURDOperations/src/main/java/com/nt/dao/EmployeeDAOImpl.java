//DAO Impl class
package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private  HibernateTemplate  ht;

	public int insertEmployee(Employee emp) {
		 ht.setCheckWriteOperations(false);  // Set whether to check that the Hibernate Session is not
		                                                                //in read-only mode in case of write operations (save/update/delete). 
		 int idVal=(Integer) ht.save(emp);   //saves the object (inserts the records)
		return  idVal;
	}

	public List<?> getAllEmployees() {
		List<?> list=ht.find("from Employee");  // bulk select operation
		return list;
		
	}

	public Employee getEmployeeByNo(int eno) {
	   Employee emp=ht.get(Employee.class, eno);  //single record selection
	   return emp;
		
	}

	public String updateEmpSalary(int eno, double newSalary) {
		 //get  Employee object based on given emplyee no
		Employee emp=getEmployeeByNo(eno);
		//update the salary
		emp.setSalary(newSalary);
		//update the object
		ht.setCheckWriteOperations(false);
		 ht.update(emp);
		 
		return "Employee details are updated with new salary:"+newSalary;
	}

	public String deteleEmployee(int eno) {
		 //get  Employee object based on given emplyee no
		Employee emp=getEmployeeByNo(eno);
		//delete the object
		ht.setCheckWriteOperations(false);
		ht.delete(emp);
		
		return "Employee is deleted";
	}

}
