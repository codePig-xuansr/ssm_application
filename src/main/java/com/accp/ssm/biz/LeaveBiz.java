package com.accp.ssm.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.ssm.dao.ILeaveDao;
import com.accp.ssm.pojo.Check;
import com.accp.ssm.pojo.Leave;
import com.accp.ssm.pojo.Status;
import com.accp.ssm.vo.LeaveCheckListVO;
import com.accp.ssm.vo.LeaveDetailsVO;
import com.accp.ssm.vo.LeaveListVO;
import com.accp.ssm.vo.LeaveVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 请假业务逻辑访问层
 * @author 轩然
 *
 */
@Service("LeaveBiz")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class LeaveBiz {

	@Resource
	private ILeaveDao dao;
	
	/**
	 * 根据条件查看请假列表
	 * @param pageNum 当前页数
	 * @param employeeId 员工id
	 * @param departmentId 部门id
	 * @param createTime 请假开始时间
	 * @param checkTime 审批结束时间
	 * @return
	 */
	public PageInfo<LeaveListVO> queryLeaveListBy(Integer pageNum,Integer employeeId,Integer departmentId,String createTime,String checkTime){
		if(pageNum==null) {
			pageNum=1;
		}
		PageHelper.startPage(pageNum, 10);
		List<LeaveListVO> list=dao.queryLeaveListBy(employeeId, departmentId, createTime, checkTime);
		PageInfo<LeaveListVO> data=new PageInfo<LeaveListVO>(list);
		return data;
	}
	
	/**
	 * 请假
	 * @param lea 请假信息
	 * @return
	 */
	public Integer addLeave(Leave lea) {
		return dao.addLeave(lea);
	}
	
	/**
	 * 根据请假编号查询请假详情
	 * @param leaveId 请假编号
	 * @return
	 */
	public LeaveDetailsVO queryLeaveDetailsById(Integer leaveId) {
		return dao.queryLeaveDetailsById(leaveId);
	}
	
	/**
	 * 审批请假并修改审批状态和下一个处理人
	 * @param leaveid 请假编号
	 * @return
	 */
	public Integer modifyLeave(Integer leaveid,Integer nextDealMan,Integer statusId) {
		return dao.modifyLeave(leaveid,nextDealMan,statusId);
	}
	
	/**
	 * 审批请假后新增一条审查结果
	 * @param ck 审查结果对象
	 * @return
	 */
	public Integer addCheck(Check ck) {
		return dao.addCheck(ck);
	}
}
