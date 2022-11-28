package com.tyb.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础Servlet类，用于被继承
 */

public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//获取业务处理方法
		String method = req.getParameter("method");
//		System.out.println(method);
//		通过反射获取字节码对象
		Class<? extends BaseServlet> clazz = getClass();
		
		
		try {
//			获取要执行的方法对象
			Method method2 = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
//			暴力反射
			method2.setAccessible(true);
//			执行方法
		method2.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
