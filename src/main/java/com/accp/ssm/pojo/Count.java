package com.accp.ssm.pojo;

/**
 * 报销记录实体类
 * @author 轩然
 *
 */
public class Count {

	private Integer countId;
	
	private Integer money;
	
	private Integer year;
	
	private Integer month;
	
	private Integer departmentId;
	
	private Integer employeeId;
	
	private String departmentName;
	
	private String employeeName;

	public Integer getCountId() {
		return countId;
	}

	public void setCountId(Integer countId) {
		this.countId = countId;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Count(Integer countId, Integer money, Integer year, Integer month, Integer departmentId, Integer employeeId,
			String departmentName, String employeeName) {
		super();
		this.countId = countId;
		this.money = money;
		this.year = year;
		this.month = month;
		this.departmentId = departmentId;
		this.employeeId = employeeId;
		this.departmentName = departmentName;
		this.employeeName = employeeName;
	}

	public Count() {
		super();
	}

	@Override
	public String toString() {
		return "Count [countId=" + countId + ", money=" + money + ", year=" + year + ", month=" + month
				+ ", departmentId=" + departmentId + ", employeeId=" + employeeId + ", departmentName=" + departmentName
				+ ", employeeName=" + employeeName + "]";
	}
	
	
}
