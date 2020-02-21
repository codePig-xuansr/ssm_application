package com.accp.ssm.vo;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.accp.ssm.pojo.Check;

public class LeaveVO {

	private Integer leaveId;
	
	private Integer typeId;
	
	private Integer createMan;
	
	private Integer departmentId;
	
	private Integer pId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")//非常重要
	private String createTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")//非常重要
	private String startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")//非常重要
	private String endTime;
	
	private Integer nextDealMan;
	
	private String nextDealName;
	
	private String event;
	
	private Integer totalCount;
	
	private Integer statusId;
	
	private String statusName;
	
	private Integer employeeId;
	
	private String employeeName;
	
	private String departmentName;
	
	private List<Check> checks;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getCreateMan() {
		return createMan;
	}

	public void setCreateMan(Integer createMan) {
		this.createMan = createMan;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(Integer nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	public String getNextDealName() {
		return nextDealName;
	}

	public void setNextDealName(String nextDealName) {
		this.nextDealName = nextDealName;
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Check> getChecks() {
		return checks;
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}

	public LeaveVO(Integer leaveId, Integer typeId, Integer createMan, Integer departmentId, Integer pId,
			String createTime, String startTime, String endTime, Integer nextDealMan, String nextDealName, String event,
			Integer totalCount, Integer statusId, String statusName, Integer employeeId, String employeeName,
			String departmentName, List<Check> checks) {
		super();
		this.leaveId = leaveId;
		this.typeId = typeId;
		this.createMan = createMan;
		this.departmentId = departmentId;
		this.pId = pId;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.nextDealMan = nextDealMan;
		this.nextDealName = nextDealName;
		this.event = event;
		this.totalCount = totalCount;
		this.statusId = statusId;
		this.statusName = statusName;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.checks = checks;
	}

	public LeaveVO() {
		super();
	}

	@Override
	public String toString() {
		return "LeaveVO [leaveId=" + leaveId + ", typeId=" + typeId + ", createMan=" + createMan + ", departmentId="
				+ departmentId + ", pId=" + pId + ", createTime=" + createTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", nextDealMan=" + nextDealMan + ", nextDealName=" + nextDealName
				+ ", event=" + event + ", totalCount=" + totalCount + ", statusId=" + statusId + ", statusName="
				+ statusName + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", departmentName="
				+ departmentName + ", checks=" + checks + "]";
	}
	
	



	
}
