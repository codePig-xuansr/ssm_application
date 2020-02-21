package com.accp.ssm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.UserBiz;
import com.accp.ssm.pojo.Employee;
import com.accp.ssm.vo.EmpVO;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/api/users")
public class UserAction {

	@Resource
	private UserBiz biz;
	
	@GetMapping("user/{employeeId}/{password}")
	public EmpVO login(HttpSession se,@PathVariable Integer employeeId, @PathVariable String password){
		Map<String, String> map = new HashMap<String, String>();
		EmpVO emp=biz.queryEmployeeByIdAndPwd(employeeId, password);
		if(emp!=null) {
			se.setAttribute("user", emp);
		}
		return emp;
	}
	
	@GetMapping("user/session")
	public EmpVO session(HttpSession se){
		EmpVO emp=(EmpVO)se.getAttribute("user");
		return emp;
	}
	
	@DeleteMapping(value = "user")
	public Map<String, String> loginout(HttpSession se) {
		Map<String, String> map = new HashMap<String, String>();
		se.removeAttribute("user");
		map.put("code", "200");
		return map;
	}
	
	@GetMapping(value = "user/{employeeId}")
	public Employee queryEmpById(@PathVariable Integer employeeId){
		Employee emp=biz.queryEmpById(employeeId);
		return emp;
	}
	
}
