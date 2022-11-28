package com.tyb.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyb.bean.User;
import com.tyb.service.impl.UserServiceImpl;
import com.tyb.web.BaseServlet;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		UserServiceImpl userService= new UserServiceImpl();
	 try {
		User user =	userService.getUserByNameAndPassword(name,password);
		if (user!=null) {
			request.setCharacterEncoding("utf-8");
//			response.getWriter().write("登录成功");
//			request.getRequestDispatcher("category?method=list").forward(request, response);
			
			response.sendRedirect(request.getContextPath()+"/category?method=pageList");
			
		}
		else {
			request.setCharacterEncoding("utf-8");
			response.getWriter().write("登录失败");
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		
		
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		UserServiceImpl userService= new UserServiceImpl();
	 try {
		 boolean flag = userService.register(user);
		 
		 if (flag) {
			request.setCharacterEncoding("utf-8");
//		注册成功
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			request.getRequestDispatcher("/login.jsp");
			response.sendRedirect("login.jsp");
			
		}
		else {
//			注册失败
			request.setCharacterEncoding("utf-8");
			response.getWriter().write("注册失败！！！");
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		
		
	}
       
   
	

}
