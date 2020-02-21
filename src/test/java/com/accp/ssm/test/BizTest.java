package com.accp.ssm.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.ssm.biz.LeaveBiz;
import com.accp.ssm.dao.ILeaveDao;
import com.accp.ssm.dao.IUserDao;

/**
 * 业务测试用例
 * @author 轩然
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ctx.xml" })
public class BizTest {

	@Resource
	private IUserDao ubiz;
	
	@Resource
	private LeaveBiz lbiz;
	
	@Test
	public void login() {
		System.out.println(ubiz.loginEmp(1002, "aaa12345"));
	}
	
	@Test
	public void queryLeavList() {
		System.out.println(lbiz.queryLeaveListBy(1,1008, 3, "2018-6-21", "2018-6-26"));
	}
}
