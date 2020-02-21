package com.accp.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.ssm.pojo.Bx;
import com.accp.ssm.pojo.BxDetails;
import com.accp.ssm.pojo.Check;
import com.accp.ssm.pojo.Count;
import com.accp.ssm.vo.LeaveCheckListVO;
import com.accp.ssm.vo.ReimburseVO;

public interface IBxDao {

	/**
	 * 分页条件查询报销列表
	 * @param statusId 报销单状态
	 * @param createMan 创建人
	 * @param departmentId 部门编号
	 * @param createTime 创建时间
	 * @param checkTime 审核时间
	 * @return
	 */
	public List<ReimburseVO> queryBxList(@Param("statusId")Integer statusId,@Param(value = "employeeId") Integer employeeId,@Param(value = "createMan") Integer createMan,@Param("departmentId")Integer departmentId,@Param("createTime")String createTime,@Param("checkTime")String checkTime);

	/**
	 * 按照报销编号查询报销详情信息
	 * @param reimburseId 报销编号
	 * @return
	 */
	public ReimburseVO queryBxDetails(@Param("reimburseId")Integer reimburseId);
	
	/**
	 * 根据外键报销编号查询详细信息列表
	 * @param mainId 外键
	 * @return
	 */
	public List<BxDetails> queryBxs(@Param("mainId")Integer mainId);
	
	/**
	 * 根据报销编号查询审核信息列表
	 * @param bizId 报销编号
	 * @return
	 */
	public List<LeaveCheckListVO> queryBxCks(@Param("bizId")Integer bizId);
	
	/**
	 * 新增报销
	 * @param bx 报销对象
	 * @return
	 */
	public Integer addBx(@Param("bx")Bx bx);
	
	/**
	 * 删除报销 
	 * @param reimburseId 报销编号
	 * @return
	 */
	public Integer removeBx(@Param("reimburseId")Integer reimburseId);
	
	/**
	 * 更改报销单得状态
	 * @param reimburseId 报销单编号
	 * @param statusId 审核状态编号
	 * @return
	 */
	public Integer modifyBx(@Param("reimburseId")Integer reimburseId,@Param("statusId")Integer statusId,@Param("nextDealMan")Integer nextDealMan);
	
	/**
	 * 新增一条审核记录
	 * @param ck 审核信息对象
	 * @return
	 */
	public Integer addCheck(@Param("ck")Check ck);
	
	/**
	 * 新增一条报销打款记录
	 * @param count 打款记录信息
	 * @return
	 */
	public Integer addCount(@Param("count")Count count);
	
	/**
	 * 查询报销单月度统计列表
	 * @param year 开始年份
	 * @param sm 开始月份
	 * @param em 结束月份
	 * @param departmentId 部门编号
	 * @return
	 */
	public List<Count> getByMonth(@Param("year")Integer year,@Param("sm")Integer sm,@Param("em")Integer em,@Param("departmentId")Integer departmentId);

	/**
	 * 按照具体年月查询月度统计详细
	 * @param year 年
	 * @param month 月
	 * @param departmentId 部门编号
	 * @return
	 */
	public List<Count> getCountDetailsByMonth(@Param("year")Integer year,@Param("month")Integer month,@Param("departmentId")Integer departmentId);

	/**
	 * 按照年份查询年度统计列表
	 * @param startYear 开始年份
	 * @param endYear 结束年份
	 * @return
	 */
	public List<Count> getByYear(@Param("startYear")Integer startYear,@Param("endYear")Integer endYear,@Param("departmentId")Integer departmentId);

	/**
	 * 按照具体年份查询年度统计详细
	 * @param year 年份
	 * @param departmentId 部门编号
	 * @return
	 */
	public List<Count> getCountDetailsByYear(@Param("year")Integer year,@Param("departmentId")Integer departmentId);
}

