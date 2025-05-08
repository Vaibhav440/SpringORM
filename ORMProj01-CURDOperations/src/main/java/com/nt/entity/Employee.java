//Employee.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_INFO_TAB")
public class Employee {
	@Id
	@Column(name="ENO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  empno;
	@Column(name="ENAME",length = 20)
	private  String  empname;
	@Column(name="JOB",length = 20)
    private  String   desg;	
   private  Double salary;

   
   // 3-param constructor
   public Employee(String empname, String desg, Double salary) {
	    System.out.println("Employee:: 3-param constructor");
		this.empname = empname;
		this.desg = desg;
		this.salary = salary;
	}
   // 0-param constructor
    public Employee() {
    	System.out.println("Employee:: 0-param constructor");
	}
    //setters  && getters
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
    
	//toString()
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", desg=" + desg + ", salary=" + salary + "]";
	}
    

}
