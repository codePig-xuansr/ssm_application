package com.accp.ssm.pojo;

/**
 * 公司员工持久实体类
 * @author 轩然
 *
 */
public class Employee {

	private Integer employeeId;//员工号
	
	private String employeeName;//名字
	
	private String password;//密码
	
	private Integer departmentId;//部门id
	
	private Integer positionId;//角色id
	
	private Integer pId;//上级工号
	
	private String status;
	
	private String faceImg;//人脸照片文件

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
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

	public Employee(Integer employeeId, String employeeName, String password, Integer departmentId, Integer positionId,
			Integer pId, String status, String faceImg) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.pId = pId;
		this.status = status;
		this.faceImg = faceImg;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", departmentId=" + departmentId + ", positionId=" + positionId + ", pId=" + pId + ", status="
				+ status + ", faceImg=" + faceImg + "]";
	}

}
