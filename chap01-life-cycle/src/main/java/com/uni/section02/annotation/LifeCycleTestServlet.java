package com.uni.section02.annotation;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleTestServlet
 */
@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 10) //@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 10)
public class LifeCycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int initCount = 1;
	private int serviceCount = 1;
	private int distoryCount = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleTestServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("annotation LifeCycleTestServlet 인스턴스생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("annotation 매핑 init() 메소드 호출  : " + initCount++);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("annotation 매핑 destroy() 메소드 호출 : " + distoryCount++);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
	}

}
