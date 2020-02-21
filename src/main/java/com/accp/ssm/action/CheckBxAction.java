package com.accp.ssm.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.BxBiz;
import com.accp.ssm.pojo.Check;

@RestController
@RequestMapping("/api/ckbxs")
public class CheckBxAction {
	
	@Resource
	private BxBiz biz;
	
	@PutMapping("/ck/{reimburseId}/{statusId}/{nextDealMan}")
	public Integer modifyBx(@PathVariable Integer reimburseId,@PathVariable Integer statusId,@PathVariable Integer nextDealMan) {
		return biz.modifyBx(reimburseId, statusId, nextDealMan);
	}
	
	@PostMapping("/ck")
	public Integer addCheck(@RequestBody Check ck) {
		return biz.addCheck(ck);
	}

}
