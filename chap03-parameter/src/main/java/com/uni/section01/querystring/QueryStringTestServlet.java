package com.uni.section01.querystring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryStringTestServlet
 */
//@WebServlet("/querystring")
@WebServlet("/headers")
public class QueryStringTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStringTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
		System.out.println("accept : " + request.getHeader("accept"));
		System.out.println("accept-encoding : " + request.getHeader("accept-encoding"));
		System.out.println("accept-language : " + request.getHeader("accept-language"));
		System.out.println("connection : " + request.getHeader("connection"));
		System.out.println("host : " + request.getHeader("host"));
		System.out.println("referer : " + request.getHeader("referer"));
		System.out.println("sec-fetch-dest : " + request.getHeader("sec-fetch-dest"));
		System.out.println("sec-fetch-mode : " + request.getHeader("sec-fetch-mode"));
		System.out.println("sec-fetch-site : " + request.getHeader("sec-fetch-site"));
		System.out.println("sec-fetch-user : " + request.getHeader("sec-fetch-user"));
		System.out.println("chche-control : " + request.getHeader("cache-control"));
		System.out.println("upgrade-insecure-requests : " + request.getHeader("upgrade-insecure-requests"));
		System.out.println("user-agent : " + request.getHeader("user-agent"));
//		// key????????? ?????????.
//		String name = request.getParameter("name");
//		// ????????? ??????????????? ??????
//		System.out.println("?????? :" + name);
//		// ?????? ???????????? ????????? ???????????? ?????? ??????.
//		int age = Integer.parseInt(request.getParameter("age"));
//		System.out.println("?????? :" + age);
//		
//		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
//		System.out.println("?????? :" + birthday);
//		
//		String gender = request.getParameter("gender");
//		System.out.println("?????? :" + gender);
//		
//		String national = request.getParameter("national");
//		System.out.println("?????? :" + national);
//		
//		String[] hobbies = request.getParameterValues("hobbies");
//		for(String hobby : hobbies) {
//			
//			System.out.println(hobby);
//		}
	}

}
