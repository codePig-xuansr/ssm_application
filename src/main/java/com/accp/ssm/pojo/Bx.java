package com.accp.ssm.pojo;

import java.util.List;

/**
 * 报销主表实体类
 * @author 轩然
 *
 */
public class Bx {

	private String reimburseId;
	
	private Integer typeId;
	
	private Integer createMan;
	
	private String createTime;
	
	private Integer departmentId;
	
	private Integer nextDealMan;
	
	private String event;
	
	private Integer totalCount;
	
	private Integer statusId;
	
	private List<BxDetails> bxs;

	public String getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(String reimburseId) {
		this.reimburseId = reimburseId;
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

	public Integer getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(Integer nextDealMan) {
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

	public List<BxDetails> getBxs() {
		return bxs;
	}

	public void setBxs(List<BxDetails> bxs) {
		this.bxs = bxs;
	}

	public Bx(String reimburseId, Integer typeId, Integer createMan, String createTime, Integer departmentId,
			Integer nextDealMan, String event, Integer totalCount, Integer statusId, List<BxDetails> bxs) {
		super();
		this.reimburseId = reimburseId;
		this.typeId = typeId;
		this.createMan = createMan;
		this.createTime = createTime;
		this.departmentId = departmentId;
		this.nextDealMan = nextDealMan;
		this.event = event;
		this.totalCount = totalCount;
		this.statusId = statusId;
		this.bxs = bxs;
	}

	public Bx() {
		super();
	}

	@Override
	public String toString() {
		return "Bx [reimburseId=" + reimburseId + ", typeId=" + typeId + ", createMan=" + createMan + ", createTime="
				+ createTime + ", departmentId=" + departmentId + ", nextDealMan=" + nextDealMan + ", event=" + event
				+ ", totalCount=" + totalCount + ", statusId=" + statusId + ", bxs=" + bxs + "]";
	}
	
	
}
