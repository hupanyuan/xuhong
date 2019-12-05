package cn.sm1234.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.Employee;
import cn.sm1234.domain.Fenye;
import cn.sm1234.service.EmployeeService;

@Controller
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;
	@RequestMapping(value="/findAllEmp",method=RequestMethod.POST)
	@ResponseBody
	public Fenye<Employee> findAllEmp(Integer page,Integer rows,Fenye<Employee> fenye) {
		fenye.setPage((page-1)*rows);
		fenye.setPagesize(rows);
		fenye=employeeService.findAllEmp(fenye);
		return fenye;
	}

	@RequestMapping(value="/deleteEmp",method=RequestMethod.POST)
	@ResponseBody
	public void deleteEmp(Integer[] id) {
		employeeService.deleteEmp(id);
	}

	@RequestMapping(value="/updateEmp",method=RequestMethod.POST)
	@ResponseBody
	public Integer updateEmp(Employee employee) {
		return employeeService.updateEmp(employee);
	}

	@RequestMapping(value="/insertEmp",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertEmp(Employee employee) {
		return employeeService.insertEmp(employee);
	}

}
