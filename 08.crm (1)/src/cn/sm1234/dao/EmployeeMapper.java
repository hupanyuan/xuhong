package cn.sm1234.dao;


import java.util.List;

import cn.sm1234.domain.Employee;
import cn.sm1234.domain.Fenye;

public interface EmployeeMapper {
	List<Employee> findAllEmp(Fenye<Employee> fenye);
	
	Integer selectCountEmp(Fenye<Employee> fenye);
	Integer updateEmp(Employee employee);
	
	Integer insertEmp(Employee employee);
	
	public void deleteEmp(Integer[] id);
}
