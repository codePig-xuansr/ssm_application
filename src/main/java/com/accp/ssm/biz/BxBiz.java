package com.accp.ssm.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.ssm.dao.IBxDao;
import com.accp.ssm.pojo.Bx;
import com.accp.ssm.pojo.Check;
import com.accp.ssm.pojo.Count;
import com.accp.ssm.vo.ReimburseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("BxBiz")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BxBiz {
	
	@Resource
	private IBxDao dao;

	/**
	 * 分页条件查询报销列表
	 * @param num 查询页数
	 * @param createMan 创建人编号
	 * @param departmentId 部门编号
	 * @param createTime 创建时间
	 * @param checkTime 审核时间
	 * @return
	 */
	public PageInfo<ReimburseVO> queryBxList(Integer num,Integer statusId,Integer uid,Integer createMan,Integer departmentId,String createTime,String checkTime){
		PageHelper.startPage(num,10);
		List<ReimburseVO> data=dao.queryBxList(statusId,uid,createMan, departmentId, createTime, checkTime);
		PageInfo<ReimburseVO> info=new PageInfo<>(data);
		return info;
	}
	
	/**
	 * 按照报销编号查询报销详情信息
	 * @param reimburseId 报销编号
	 * @return
	 */
	public ReimburseVO queryBxDetails(Integer reimburseId) {
		return dao.queryBxDetails(reimburseId);
	}
	
	/**
	 * 新增报销
	 * @param bx 报销对象
	 * @return
	 */
	public Integer addBx(Bx bx) {
		return dao.addBx(bx);
	}
	
	/**
	 * 删除报销 
	 * @param reimburseId 报销编号
	 * @return
	 */
	public Integer removeBx(Integer reimburseId) {
		return dao.removeBx(reimburseId);
	}
	
	/**
	 * 更改报销单得状态
	 * @param reimburseId 报销单编号
	 * @param statusId 审核状态编号
	 * @return
	 */
	public Integer modifyBx(Integer reimburseId,Integer statusId,Integer nextDealMan) {
		return dao.modifyBx(reimburseId, statusId,nextDealMan);
	}
	
	/**
	 * 新增一条审核记录
	 * @param ck 审核信息对象
	 * @return
	 */
	public Integer addCheck(Check ck) {
		return dao.addCheck(ck);
	}
	
	/**
	 * 新增一条报销打款记录
	 * @param count 打款记录信息
	 * @return
	 */
	public Integer addCount(Count count) {
		return dao.addCount(count);
	}
	
	/**
	 * 查询报销单月度统计列表
	 * @param year 开始年份
	 * @param sm 开始月份
	 * @param em 结束月份
	 * @param departmentId 部门编号
	 * @return
	 */
	public PageInfo<Count> getByMonth(Integer pageNum,Integer year,Integer sm,Integer em,Integer departmentId){
		if(pageNum==0) {
			pageNum=1;
		}
		PageHelper.startPage(pageNum, 6);
		List<Count> data=dao.getByMonth(year, sm, em, departmentId);
		PageInfo<Count> info=new PageInfo<Count>(data);
		return info;
	}
	
	/**
	 * 按照具体年月查询月度统计详细
	 * @param year 年
	 * @param month 月
	 * @param departmentId 部门编号
	 * @return
	 */
	public List<Count> getCountDetailsByMonth(Integer year,Integer month,Integer departmentId){
		return dao.getCountDetailsByMonth(year, month, departmentId);
	}
	
	/**
	 * 按照年份查询年度统计列表
	 * @param startYear 开始年份
	 * @param endYear 结束年份
	 * @return
	 */
	public List<Count> getByYear(Integer startYear,Integer endYear,Integer departmentId){
		return dao.getByYear(startYear, endYear,departmentId);
	}
	
	/**
	 * 按照具体年份查询年度统计详细
	 * @param year 年份
	 * @param departmentId 部门编号
	 * @return
	 */
	public List<Count> getCountDetailsByYear(Integer year,Integer departmentId){
		return dao.getCountDetailsByYear(year, departmentId);
	}
}
