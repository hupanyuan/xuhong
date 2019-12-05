package cn.sm1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sm1234.dao.EmployeeMapper;
import cn.sm1234.domain.Employee;
import cn.sm1234.domain.Fenye;
import cn.sm1234.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	public Fenye<Employee> findAllEmp(Fenye<Employee> fenye) {
		List<Employee> list=employeeMapper.findAllEmp(fenye);
		Integer selectCountEmp = employeeMapper.selectCountEmp(fenye);
		fenye.setRows(list);
		fenye.setTotal(selectCountEmp);
		return fenye;
	}


	public void deleteEmp(Integer[] id) {
		employeeMapper.deleteEmp(id);
	}


	public Integer updateEmp(Employee employee) {
		return employeeMapper.updateEmp(employee);
	}


	public Integer insertEmp(Employee employee) {
		return employeeMapper.insertEmp(employee);
	}



	
}
