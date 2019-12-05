package cn.sm1234.service;


import cn.sm1234.domain.Employee;
import cn.sm1234.domain.Fenye;

public interface EmployeeService {
	Fenye<Employee> findAllEmp(Fenye<Employee> fenye);
	
	Integer updateEmp(Employee employee);
	
	Integer insertEmp(Employee employee);
	
	public void deleteEmp(Integer[] id);
}
