package com.uni.section01.xml;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCXCycleTestServlet
 */

public class LifeCXCycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 호출확인
	private int initCount = 1;
	private int serviceCount = 1;
	private int distoryCount = 1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCXCycleTestServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("annotation LifeCycleTestServlet 인스턴스생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 서블릿의 요청이 들어온경우 한번 동작하는 메소드
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("xml 매핑 init() 메소드 호출 :" + initCount++);
	}

	/**
	 * @see Servlet#destroy()
	 * 컨테이너가 종료될때 호출 되는 메소드 이고 주로 자원을 반납하는 용도로 사용
	 */
	public void destroy() {
		System.out.println("xml 매핑 destroy() 메소드 호출 :" + distoryCount++);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 서블릿 컨테이너에 의해 호출되며 최초요청시에는 init() 메소드 이후에 동작하고,
	 * 두번째 요청 부터는 바로 service() 를 호출하게 된다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("xml 매핑 service() 메소드 호출 :" + serviceCount++);
	}

}
