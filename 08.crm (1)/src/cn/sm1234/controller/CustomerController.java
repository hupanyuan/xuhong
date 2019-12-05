package cn.sm1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.Customer;
import cn.sm1234.service.CustomerService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CustomerController {
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public List<Customer> list(){
		List<Customer> list = customerService.findAll();
		return list;
	}
	
	private Map<String,Object> result = new HashMap<String,Object>();
	
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		List<Customer> list = customerService.findAll();
		
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
		
		long total = pageInfo.getTotal();
		List<Customer> custList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", custList);
		
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Customer customer){
		try {
			customerService.save(customer);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	@RequestMapping("/findById")
	@ResponseBody
	public Customer findById(Integer id){
		Customer cust = customerService.findById(id);
		return cust;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			customerService.delete(id);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
