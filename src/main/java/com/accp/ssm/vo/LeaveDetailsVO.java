package com.accp.ssm.vo;

import java.util.List;

/**
 * 请假详情
 * @author 轩然
 *
 */
public class LeaveDetailsVO {

	private Integer leaveId;
	
	private String createMan;
	
	private String departmentName;
	
	private String startTime;
	
	private String endTime;
	
	private Integer totalCount;
	
	private String event;
	
	private String statusName;
	
	private List<LeaveCheckListVO> checks;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<LeaveCheckListVO> getChecks() {
		return checks;
	}

	public void setChecks(List<LeaveCheckListVO> checks) {
		this.checks = checks;
	}

	public LeaveDetailsVO(Integer leaveId, String createMan, String departmentName, String startTime, String endTime,
			Integer totalCount, String event, String statusName, List<LeaveCheckListVO> checks) {
		super();
		this.leaveId = leaveId;
		this.createMan = createMan;
		this.departmentName = departmentName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalCount = totalCount;
		this.event = event;
		this.statusName = statusName;
		this.checks = checks;
	}

	public LeaveDetailsVO() {
		super();
	}

	@Override
	public String toString() {
		return "LeaveDetailsVO [leaveId=" + leaveId + ", createMan=" + createMan + ", departmentName=" + departmentName
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", totalCount=" + totalCount + ", event="
				+ event + ", statusName=" + statusName + ", checks=" + checks + "]";
	}
	
}
