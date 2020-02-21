package com.accp.ssm.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.ssm.dao.IUserDao;
import com.accp.ssm.pojo.Employee;
import com.accp.ssm.vo.EmpVO;

/**
 * 员工业务类
 * @author 轩然
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UserBiz {
	
	@Resource
	private IUserDao dao;
	
	/**
	 * 登录
	 * @param id 员工号
	 * @param pwd 密码
	 * @return 
	 */
	public EmpVO queryEmployeeByIdAndPwd(Integer id,String pwd) {
		return dao.loginEmp(id, pwd);
	}
	
	/**
	 * 根据员工号查询对象
	 * @param employeeId
	 * @return
	 */
	public Employee queryEmpById(Integer employeeId) {
		return dao.queryEmpById(employeeId);
	}
}
