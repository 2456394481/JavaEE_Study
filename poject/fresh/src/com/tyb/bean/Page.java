package com.tyb.bean;

import java.util.List;

/**
 * 分页
 * 
 * @author admin
 *@Date 
 * @param <T>
 */
public class Page<T> {

	private Integer currentPage = 1; // 当前页
	private Integer currentCount = 4; // 每页显示条数
	private Integer totalPage; // 总页数
	private Integer totalCount;// 总条数
	private List<T> list; // 列表数据信息

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	public int getStart() {
		return (currentPage-1)*currentCount;
	}

}
