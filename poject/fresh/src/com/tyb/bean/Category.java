package com.tyb.bean;

import java.util.Date;


/**
 * 生鲜种类类
 * @author teng
 *
 */
public class Category {
	/**
	 * 生鲜id
	 */
	private Integer categoryId;

	/**
	 * 生鲜名称
	 */
	private String categoryName;

	/**
	 * 生鲜的产地
	 */
	private String place;

	/**
	 * 添加日期
	 */
	private Date createtime;

	/**
	 * 生鲜种类(0未知，1，肉类 2，海鲜3，蔬菜)
	 */
	private Byte type;
	


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
	
	
}
