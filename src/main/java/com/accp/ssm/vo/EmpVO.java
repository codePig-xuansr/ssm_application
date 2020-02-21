package com.accp.ssm.vo;

public class EmpVO {
	
	private Integer employeeId;//员工号
	
	private String employeeName;//名字
	
	private String password;//密码
	
	private Integer departmentId;//部门id
	
	private String departmentName;//部门
	
	private Integer positionId;//角色id
	
	private Integer pId;
	
	private Integer nextDealMan;
	
	public Integer getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(Integer nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	private String status;
	
	private String positionName;//角色
	
	private String faceImg;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public EmpVO(Integer employeeId, String employeeName, String password, Integer departmentId, String departmentName,
			Integer positionId, Integer pId, String status, String positionName, String faceImg) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.positionId = positionId;
		this.pId = pId;
		this.status = status;
		this.positionName = positionName;
		this.faceImg = faceImg;
	}

	public EmpVO() {
		super();
	}

	@Override
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", positionId=" + positionId
				+ ", pId=" + pId + ", status=" + status + ", positionName=" + positionName + ", faceImg=" + faceImg
				+ "]";
	}

	

}
