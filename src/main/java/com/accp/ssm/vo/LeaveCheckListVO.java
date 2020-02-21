package com.accp.ssm.vo;

/**
 * 请假审批结果
 * @author 轩然
 *
 */
public class LeaveCheckListVO {

	private String checkId;
	
	private String checkMan;
	
	private String checkComment;
	
	private String checkTime;
	
	private String checkResult;

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public String getCheckComment() {
		return checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public LeaveCheckListVO(String checkId, String checkMan, String checkComment, String checkTime, String checkResult) {
		super();
		this.checkId = checkId;
		this.checkMan = checkMan;
		this.checkComment = checkComment;
		this.checkTime = checkTime;
		this.checkResult = checkResult;
	}

	public LeaveCheckListVO() {
		super();
	}

	@Override
	public String toString() {
		return "LeaveCheckList [checkId=" + checkId + ", checkMan=" + checkMan + ", checkComment=" + checkComment
				+ ", checkTime=" + checkTime + ", checkResult=" + checkResult + "]";
	}
	
	
}
