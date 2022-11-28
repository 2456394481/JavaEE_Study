package com.tyb.web.category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyb.bean.Category;
import com.tyb.bean.Page;
import com.tyb.service.ICategoryService;
import com.tyb.service.impl.CategoryServiceImpl;
import com.tyb.web.BaseServlet;

/**
 * Servlet implementation class User
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {

	/**
	 * 删除生鲜
	 * 
	 * @param request
	 * @param response
	 */
	protected void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取请求参数
			String categoryId = request.getParameter("categoryId");
			ICategoryService categoryService = new CategoryServiceImpl();
//			System.out.println(categoryId);
			boolean flag = false;
			if (categoryId != null && !"".equals(categoryId)) {

				flag = categoryService.delete(Integer.parseInt(categoryId));
			}

//				response.sendRedirect("category-list.jsp");
			if (flag) {
				response.setStatus(201);
			}

			else {
				response.setStatus(600);
			}
			// 转发到新增页面
//			request.getRequestDispatcher("category?method=list").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/category?method=pageList");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * 生鲜列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ICategoryService categoryService = new CategoryServiceImpl();
		try {
			List<Category> list = categoryService.getCategoryList();

			request.setAttribute("list", list);

		   	 request.getRequestDispatcher("category-list.jsp").forward(request, response);
//			request.getRequestDispatcher(request.getContextPath() + "/category?method=pageList").forward(request,
//					response);
//			response.sendRedirect("category?method=list");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 新增生鲜
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			// 获取请求参数
			String name = request.getParameter("c_name");
			String place = request.getParameter("place");
			String type = request.getParameter("type");
			// 封装数据
			Category category = new Category();
			category.setCategoryName(name);
			category.setPlace(place);
			category.setCreatetime(new Date());
			if (type != null && !"".equals(type)) {
				byte typeByte = Byte.parseByte(type);
				category.setType(typeByte);
			} else {

			}
//		category.setType(type);
			ICategoryService categoryService = new CategoryServiceImpl();
			boolean flag = categoryService.add(category);
			if (flag) {
				// 添加成功，设置状态码为201
				response.setStatus(201);
			} else {
				// 添加失败，设置状态码为200
				response.setStatus(600);
			}
			// 转发到新增页面
			request.getRequestDispatcher("category-add.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/category-add.jsp");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 更新生鲜
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			// 获取请求参数
			String categoryId = request.getParameter("categoryId");
			String name = request.getParameter("categoryName");
			String place = request.getParameter("place");
			String type = request.getParameter("type");
			System.out.println(categoryId);
			System.out.println(name);
			System.out.println(place);
			System.out.println(type);

			// 封装数据
			Category category = new Category();
			category.setCategoryId(Integer.getInteger(categoryId));
			category.setCategoryName(name);
			category.setPlace(place);
			category.setCreatetime(new Date());
			if (type != null && !"".equals(type)) {
				byte typeByte = Byte.parseByte(type);
				category.setType(typeByte);
			} else {

			}
//		category.setType(type);
			ICategoryService categoryService = new CategoryServiceImpl();
			boolean flag = categoryService.update(category);
			if (flag) {
				// 添加成功，设置状态码为201
				response.setStatus(201);
			} else {
				// 添加失败，设置状态码为200
				response.setStatus(600);
			}
			// 转发到新增页面
			request.getRequestDispatcher("category-add.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/category-add.jsp");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 分页查询你生鲜列表
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			// 获取请求参数
			String currentPage = req.getParameter("currentPage");
			String currentCount = req.getParameter("currentCount");
			// 封装参数
			System.out.println("currentCount=>"+currentCount);
			System.out.println("currentPage=>"+currentPage);
			Page page = new Page<Category>();
			if (currentCount != null && !"".equals(currentCount)) {
				// 修改要查询的当前页
				page.setCurrentCount(Integer.parseInt(currentCount));
			}
			if (currentPage != null && "".equals(currentPage)) {
				// 修改要查询的每页显示条数
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
			try {
			ICategoryService categoryService = new CategoryServiceImpl();
			categoryService.getCategoryPageList(page);

			req.setAttribute("page", page);
//			resp.sendRedirect(req.getContextPath()+"/category?method=list");
//			req.getRequestDispatcher("category-list.jsp").forward(req, resp);
			req.getRequestDispatcher("category-list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
