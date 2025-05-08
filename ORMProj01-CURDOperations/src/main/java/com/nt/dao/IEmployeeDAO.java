//DAO Interface
package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeDAO {
    public  int    insertEmployee(Employee emp);
    public  List<?>  getAllEmployees();
    public  Employee  getEmployeeByNo(int eno);
    public   String  updateEmpSalary(int eno, double newSalary);
    public    String deteleEmployee(int eno);
}
