package com.accp.ssm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.BxBiz;
import com.accp.ssm.pojo.Count;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/counts")
public class CountAction {

	@Resource
	private BxBiz biz;
	
	@PostMapping("/count")
	public Integer addCount(@RequestBody Count count) {
		return biz.addCount(count);
	}
	
	@GetMapping("/{pageNum}/{year}/{sm}/{em}/{departmentId}")
	public PageInfo<Count> getByMonth(@PathVariable Integer pageNum,@PathVariable Integer year,@PathVariable Integer sm,@PathVariable Integer em,@PathVariable Integer departmentId){
		if(year==0) {
			year=null;
		}
		if(sm==0) {
			sm=null;
		}
		if(em==0) {
			em=null;
		}
		if(departmentId==0) {
			departmentId=null;
		}
		return biz.getByMonth(pageNum, year, sm, em, departmentId);
	}
	
	@GetMapping("count/{year}/{month}/{departmentId}")
	public List<Count> getCountDetailsByMonth(@PathVariable Integer year,@PathVariable Integer month,@PathVariable Integer departmentId) {
		if(year==0) {
			year=null;
		}
		
		if(departmentId==0) {
			departmentId=null;
		}
		return biz.getCountDetailsByMonth(year, month, departmentId);
	}
}
