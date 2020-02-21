package com.accp.ssm.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.BxBiz;
import com.accp.ssm.pojo.Bx;
import com.accp.ssm.pojo.Check;
import com.accp.ssm.util.TestExportExcel;
import com.accp.ssm.vo.ReimburseVO;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/bxs")
public class BxAction {

	@Resource
	private BxBiz biz;
	
	@GetMapping("{pageNum}/{statusId}/{uid}/{employeeId}/{departmentId}/{createTime}/{checkTime}")
	public PageInfo<ReimburseVO> queryBxList(@PathVariable Integer pageNum,@PathVariable Integer statusId,@PathVariable Integer uid,@PathVariable Integer employeeId,@PathVariable Integer departmentId,@PathVariable String createTime,@PathVariable String checkTime){
		if("0".equals(createTime)) {
			createTime=null;
		}
		if("0".equals(checkTime)) {
			checkTime=null;
		}
		return biz.queryBxList(pageNum, statusId, uid, employeeId, departmentId, createTime, checkTime);
	}
	
	@GetMapping("/bx/{reimburseId}")
	public ReimburseVO queryBxDetails(@PathVariable Integer reimburseId) {
		return biz.queryBxDetails(reimburseId);
	}
	
	@PostMapping("/bx")
	public String addBx(@RequestBody Bx bx) {
		if(biz.addBx(bx)>0) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	@DeleteMapping("/bx/{reimburseId}")
	public String removeBx(@PathVariable Integer reimburseId) {
		if(biz.removeBx(reimburseId)>0) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	@PutMapping("/bx/{reimburseId}/{statusId}/{nextDealMan}")
	public String modifyBx(@PathVariable Integer reimburseId,@PathVariable Integer statusId,@PathVariable Integer nextDealMan) {
		if(biz.modifyBx(reimburseId, statusId,nextDealMan)>0) {
			return "ok";
		}else {
			return "no";
		}
	}
}
