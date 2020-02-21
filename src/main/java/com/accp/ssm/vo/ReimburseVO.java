package com.accp.ssm.vo;

import java.util.List;

import com.accp.ssm.pojo.BxDetails;
import com.accp.ssm.pojo.Check;

public class ReimburseVO {

	private Integer reimburseId;
	
	private Integer typeId;
	
	private Integer employeeId;
	
	private String createMan;
	
	private String createTime;
	
	private Integer departmentId;
	
	private String positionName;

	private String departmentName;
	
	private String nextDealMan;
	
	private String event;
	
	private Integer totalCount;
	
	private Integer statusId;
	
	private String statusName;
	
	private List<BxDetails> Bxs;
	
	private List<Check> BxCks;

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(String nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<BxDetails> getBxs() {
		return Bxs;
	}

	public void setBxs(List<BxDetails> bxs) {
		Bxs = bxs;
	}

	public List<Check> getBxCks() {
		return BxCks;
	}

	public void setBxCks(List<Check> bxCks) {
		BxCks = bxCks;
	}

	public ReimburseVO(Integer reimburseId, Integer typeId, Integer employeeId, String createMan, String createTime,
			Integer departmentId, String positionName, String departmentName, String nextDealMan, String event,
			Integer totalCount, Integer statusId, String statusName, List<BxDetails> bxs, List<Check> bxCks) {
		super();
		this.reimburseId = reimburseId;
		this.typeId = typeId;
		this.employeeId = employeeId;
		this.createMan = createMan;
		this.createTime = createTime;
		this.departmentId = departmentId;
		this.positionName = positionName;
		this.departmentName = departmentName;
		this.nextDealMan = nextDealMan;
		this.event = event;
		this.totalCount = totalCount;
		this.statusId = statusId;
		this.statusName = statusName;
		Bxs = bxs;
		BxCks = bxCks;
	}

	public ReimburseVO() {
		super();
	}

	@Override
	public String toString() {
		return "ReimburseVO [reimburseId=" + reimburseId + ", typeId=" + typeId + ", employeeId=" + employeeId
				+ ", createMan=" + createMan + ", createTime=" + createTime + ", departmentId=" + departmentId
				+ ", positionName=" + positionName + ", departmentName=" + departmentName + ", nextDealMan="
				+ nextDealMan + ", event=" + event + ", totalCount=" + totalCount + ", statusId=" + statusId
				+ ", statusName=" + statusName + ", Bxs=" + Bxs + ", BxCks=" + BxCks + "]";
	}

}