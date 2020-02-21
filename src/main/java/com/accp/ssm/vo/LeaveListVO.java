package com.accp.ssm.vo;

/**
 * 请假列表
 * @author 轩然
 *
 */
public class LeaveListVO {

	private Integer leaveId;
	
	private String createMan;
	
	private String createTime;
	
	private String checkTime;
	
	private String checkComment;
	
	private String nextDealMan;
	
	private String statusName;
	
	private Integer totalCount;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckComment() {
		return checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	public String getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(String nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public LeaveListVO(Integer leaveId, String createMan, String createTime, String checkTime, String checkComment,
			String nextDealMan, String statusName, Integer totalCount) {
		super();
		this.leaveId = leaveId;
		this.createMan = createMan;
		this.createTime = createTime;
		this.checkTime = checkTime;
		this.checkComment = checkComment;
		this.nextDealMan = nextDealMan;
		this.statusName = statusName;
		this.totalCount = totalCount;
	}

	public LeaveListVO() {
		super();
	}

	@Override
	public String toString() {
		return "LeaveListVO [leaveId=" + leaveId + ", createMan=" + createMan + ", createTime=" + createTime
				+ ", checkTime=" + checkTime + ", checkComment=" + checkComment + ", nextDealMan=" + nextDealMan
				+ ", statusName=" + statusName + ", totalCount=" + totalCount + "]";
	}

	
}
