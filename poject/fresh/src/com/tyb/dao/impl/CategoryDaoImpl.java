package com.tyb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tyb.bean.Category;
import com.tyb.dao.ICategory;
import com.tyb.utils.DataSourceUtils;

public class CategoryDaoImpl implements ICategory{

	@Override
	public List<Category> getCategoryList() throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "select categoryId,categoryName,place,createtime,type from category";
		List<Category> list = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return list; 
	}

	@Override
	public int insert(Category category) throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "insert into category Values(null,?,?,?,?)";
		int row = queryRunner.update(sql,category.getCategoryName(),category.getPlace(),category.getCreatetime(),category.getType());
		return row;
	}

	@Override
	public int delete(Integer categoryId) throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "delete from category where categoryId=?";
		int row = queryRunner.update(sql,categoryId);
		return row;
	}

	@Override
	public int update(Category category) throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "update category set categoryName=?,place=?,type=? where categoryId=?";
		int row = queryRunner.update(sql,category.getCategoryName(),category.getPlace(),category.getPlace(),category.getCategoryId());
		return row;
	}

	@Override
	public int getTotalCount() throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "select count(categoryId) from category";
		 Long totalCount = queryRunner.query(sql, new ScalarHandler<Long>());
		return totalCount.intValue();
		
	}

	@Override
	public List<Category> getCategoryPageList(Integer begin, Integer currentCount) throws SQLException {
		QueryRunner queryRunner = DataSourceUtils.getQueryRunner();
		String sql  = "select * from category limit ?,?";
		List<Category> list =queryRunner.query(sql, new BeanListHandler<Category>(Category.class),begin,currentCount);
		return list;
	}
	
}
