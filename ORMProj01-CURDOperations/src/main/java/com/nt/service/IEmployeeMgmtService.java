//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
    public  String registerEmployee(Employee emp);
    public   List<Employee>  fetchAllEmployees();
    public  Employee   fetchEmployeeByNo(int no);
    public  String   hikeEmployeSalary(int eno, double percentage);
    public   String    removeEmployeeByNo(int eno);
}
