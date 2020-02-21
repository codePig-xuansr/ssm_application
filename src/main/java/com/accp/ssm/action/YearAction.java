package com.accp.ssm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.BxBiz;
import com.accp.ssm.pojo.Count;

@RestController
@RequestMapping("/api/years")
public class YearAction {


	@Resource
	private BxBiz biz;
	
	@GetMapping("year/{startYear}/{endYear}/{departmentId}")
	public List<Count> getByYear(@PathVariable Integer startYear,@PathVariable Integer endYear,@PathVariable Integer departmentId){
		if(startYear==0) {
			startYear=null;
		}
		if(endYear==0) {
			endYear=null;
		}
		if(departmentId==0) {
			departmentId=null;
		}
		return biz.getByYear(startYear, endYear, departmentId);
	}
	
	@GetMapping("yearxq/{year}/{departmentId}")
	public List<Count> getCountDetailsByYear(@PathVariable Integer year,@PathVariable Integer departmentId){
		if(departmentId==0) {
			departmentId=null;
		}
		if(year==0) {
			year=null;
		}
		return biz.getCountDetailsByYear(year, departmentId);
	}
}
