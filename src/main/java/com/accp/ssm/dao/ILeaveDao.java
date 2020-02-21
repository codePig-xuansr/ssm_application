package com.accp.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.ssm.pojo.Check;
import com.accp.ssm.pojo.Leave;
import com.accp.ssm.pojo.Status;
import com.accp.ssm.vo.LeaveCheckListVO;
import com.accp.ssm.vo.LeaveDetailsVO;
import com.accp.ssm.vo.LeaveListVO;
import com.accp.ssm.vo.LeaveVO;

/**
 * 请假持久化接口
 * @author 轩然
 *
 */
public interface ILeaveDao {
	
	/**
	 * 请假
	 * @param lea 请假信息
	 * @return
	 */
	public Integer addLeave(@Param("lea")Leave lea);
	
	/**
	 * 根据条件查看请假
	 * @param employeeId 员工编号
	 * @param departmentId 部门编号
	 * @param startTime 请假发起日期
	 * @param endTime 请假审批结束日期
	 * @return
	 */
	public List<LeaveListVO> queryLeaveListBy(@Param("createMan")Integer createMan,@Param("departmentId")Integer departmentId,@Param("createTime")String createTime,@Param("checkTime")String checkTime);

	/**
	 * 根据请假编号查询请假详情
	 * @param leaveId 请假编号
	 * @return
	 */
	public LeaveDetailsVO queryLeaveDetailsById(@Param("leaveId")Integer leaveId);
	
	/**
	 * 按照请假编号查询审查结果列表
	 * @param checkId
	 * @return
	 */
	public List<LeaveCheckListVO> queryCheckList(@Param("checkId")Integer checkId);
	
	/**
	 * 审批请假并修改审批状态和下一个处理人
	 * @param leaveid 请假编号
	 * @return
	 */
	public Integer modifyLeave(@Param("leaveid")Integer leaveid,@Param("nextMan")Integer nextDealMan,@Param("statusId")Integer statusId);
	
	/**
	 * 审批请假后新增一条审查结果
	 * @param ck 审查结果对象
	 * @return
	 */
	public Integer addCheck(@Param("ck")Check ck);
}
