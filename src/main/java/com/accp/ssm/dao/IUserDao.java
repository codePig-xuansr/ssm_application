package com.accp.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.ssm.pojo.Employee;
import com.accp.ssm.vo.EmpVO;

/**
 * 用户持久化接口
 * @author 轩然
 *
 */
public interface IUserDao {
	
	/**
	 * 根据员工号和密码登录
	 * @param employeeId 员工号
	 * @param password 密码
	 * @return
	 */
	public EmpVO loginEmp(@Param("employeeId")Integer employeeId,@Param("password")String password);
	
	/**
	 * 根据员工号查询对象
	 * @param employeeId 员工号
	 * @return
	 */
	public Employee queryEmpById(@Param("employeeId")Integer employeeId);
}
