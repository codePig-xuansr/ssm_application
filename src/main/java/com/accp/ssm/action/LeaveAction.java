package com.accp.ssm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.LeaveBiz;
import com.accp.ssm.pojo.Check;
import com.accp.ssm.pojo.Leave;
import com.accp.ssm.pojo.Status;
import com.accp.ssm.vo.LeaveDetailsVO;
import com.accp.ssm.vo.LeaveListVO;
import com.accp.ssm.vo.LeaveVO;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/leaves")
public class LeaveAction {

	@Resource
	private LeaveBiz lbiz;
	
	@GetMapping("{pageNum}/{employeeId}/{departmentId}/{createTime}/{checkTime}")
	public PageInfo<LeaveListVO> queryLeaveListBy(@PathVariable Integer pageNum,@PathVariable Integer employeeId,@PathVariable Integer departmentId,@PathVariable String createTime,@PathVariable String checkTime){
		if("0".equals(createTime)) {
			createTime=null;
		}
		if("0".equals(checkTime)) {
			checkTime=null;
		}
		return lbiz.queryLeaveListBy(pageNum, employeeId, departmentId, createTime, checkTime);
	}
	
	@PostMapping(value = "leave")
	public String addLeave(@RequestBody Leave obj){
		lbiz.addLeave(obj);
		return "ok";
	}
	
	@GetMapping("/leave/{leaveId}")
	public LeaveDetailsVO queryLeaveDetails(@PathVariable Integer leaveId) {
		return lbiz.queryLeaveDetailsById(leaveId);
	}
}
