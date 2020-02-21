package com.accp.ssm.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.LeaveBiz;
import com.accp.ssm.pojo.Check;

@RestController
@RequestMapping("/api/checks")
public class CheckAction {

	@Resource
	private LeaveBiz biz;
	
	@PutMapping("/check/{leaveId}/{nextDealMan}/{statusId}")
	public Integer modifyLeave(@PathVariable Integer leaveId,@PathVariable Integer nextDealMan,@PathVariable Integer statusId) {
		return biz.modifyLeave(leaveId,nextDealMan,statusId);
	}
	
	@PostMapping("/check")
	public Integer addCheck(@RequestBody Check check) {
		return biz.addCheck(check);
	}
}
