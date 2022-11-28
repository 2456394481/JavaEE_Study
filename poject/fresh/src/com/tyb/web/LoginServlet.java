//package com.tyb.web;
//
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.tyb.bean.User;
//import com.tyb.service.impl.UserServiceImpl;
//
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		
//		UserServiceImpl userService= new UserServiceImpl();
//	 try {
//		User user=	userService.getUserByNameAndPassword(name,password);
//		if (user!=null) {
//			request.setCharacterEncoding("utf-8");
////			response.getWriter().write("登录成功");
//			request.getRequestDispatcher("category-list.jsp").forward(request, response);;
//			
//		}
//		else {
//			request.setCharacterEncoding("utf-8");
//			response.getWriter().write("登录失败");
//		}
//	} catch (SQLException e) {
//	
//		e.printStackTrace();
//	}
//		
//		
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
