package com.accp.ssm.pojo;

/**
 * 报销详表实体类
 * @author 轩然
 *
 */
public class BxDetails {

	private Integer id;
	
	private String mainId;
	
	private float subTotal;
	
	private String desc;
	
	private String pictureName;
	
	private String picturePath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public BxDetails(Integer id, String mainId, float subTotal, String desc, String pictureName, String picturePath) {
		super();
		this.id = id;
		this.mainId = mainId;
		this.subTotal = subTotal;
		this.desc = desc;
		this.pictureName = pictureName;
		this.picturePath = picturePath;
	}

	public BxDetails() {
		super();
	}

	@Override
	public String toString() {
		return "BxDetails [id=" + id + ", mainId=" + mainId + ", subTotal=" + subTotal + ", desc=" + desc
				+ ", pictureName=" + pictureName + ", picturePath=" + picturePath + "]";
	}
	
	
}
