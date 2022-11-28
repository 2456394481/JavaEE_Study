package com.tyb.dao;

import java.sql.SQLException;
import java.util.List;

import com.tyb.bean.Category;

public interface ICategory {
	/**
	 * 获取所有生鲜种类列表
	 * 
	 * @throws SQLException
	 */
	List<Category> getCategoryList() throws SQLException;

	/**
	 * 添加
	 * 
	 * @param categoty
	 * @return
	 * @throws SQLException
	 */
	int insert(Category categoty) throws SQLException;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int delete(Integer categoryId) throws SQLException;

	/**
	 * 更新
	 * 
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	int update(Category category) throws SQLException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	int getTotalCount() throws SQLException;
	/**
	 * 查询某一页的结果集
	 * @param begin 开始位置
	 * @param currentCount 每页显示条数
	 * @return
	 * @throws SQLException
	 */
	List<Category> getCategoryPageList(Integer begin,Integer currentCount) throws SQLException;

}
