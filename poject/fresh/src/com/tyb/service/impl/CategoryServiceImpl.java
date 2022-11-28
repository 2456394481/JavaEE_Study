package com.tyb.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.tyb.bean.Category;
import com.tyb.bean.Page;
import com.tyb.dao.ICategory;
import com.tyb.dao.impl.CategoryDaoImpl;
import com.tyb.service.ICategoryService;

/**
 * 生鲜种类服务接口
 * 
 * @author admin
 *
 */
public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> getCategoryList() throws SQLException {
		ICategory categoryDao = new CategoryDaoImpl();
		List<Category> list = categoryDao.getCategoryList();
		return list;
	}

	@Override
	public boolean add(Category category) throws SQLException {
		ICategory categoryDao = new CategoryDaoImpl();
		int row = categoryDao.insert(category);
		return row > 0;
	}

	@Override
	public boolean delete(Integer categoryId) throws SQLException {
		ICategory categoryDao = new CategoryDaoImpl();
		int row = categoryDao.delete(categoryId);
		return row > 0;
	}

	@Override
	public boolean update(Category category) throws SQLException {
		ICategory categoryDao = new CategoryDaoImpl();
		int row = categoryDao.update(category);
		return row > 0;
	}

	@Override
	public void getCategoryPageList(Page<Category> page) throws SQLException {
		ICategory categoryDao = new CategoryDaoImpl(); // 调用dao层
		int totalCount = categoryDao.getTotalCount();// 获取总条数
		page.setTotalCount(totalCount);

		// 计算总页数
		/*
		 * 总条数totalCount 每条显示条数currentCount 总页数totalPage
		 */
		int currentCount = page.getCurrentCount();
		int totalPage = (int) Math.ceil(totalCount / currentCount);
		// 把总页数封装到page中
		page.setTotalPage(totalPage);
		System.out.println(totalCount);

		// 查询分页数据
		int currentPage = page.getCurrentPage();
		System.out.println("currentPage=>"+currentPage);
		int begin = (currentPage - 1) * currentCount;
		List<Category> list = categoryDao.getCategoryPageList(begin, currentCount);

		// 把list 封装到page中
		page.setList(list);

	}

}
