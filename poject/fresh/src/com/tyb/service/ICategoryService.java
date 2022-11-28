package com.tyb.service;

import java.sql.SQLException;
import java.util.List;

import com.tyb.bean.Category;
import com.tyb.bean.Page;

public interface ICategoryService {
	/**
	 * 获取所有实现类
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Category> getCategoryList() throws SQLException;

	/**
	 * 添加生鲜类
	 * 
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	boolean add(Category category) throws SQLException;

	/**
	 * 删除
	 * 
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	boolean delete(Integer categoryId) throws SQLException;

	/**
	 * 更新
	 * 
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	boolean update(Category category) throws SQLException;

	void getCategoryPageList(Page<Category> page) throws SQLException;

}
