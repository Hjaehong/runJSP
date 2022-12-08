package com.uni.mvc.common.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.uni.mvc.common.config.ConfigLocation;

/**
 * Servlet implementation class InitalLoadingServlet
 */
@WebServlet(urlPatterns = {}, loadOnStartup = 1) // startup의 숫자를 적게 줘서 제일 먼저 실행된다.
public class InitalLoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitalLoadingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ConfigLocation.mybatisConfigLocation = config.getServletContext().getInitParameter("mybatis-config-location");
		
		System.out.println(ConfigLocation.mybatisConfigLocation);
	}

}
