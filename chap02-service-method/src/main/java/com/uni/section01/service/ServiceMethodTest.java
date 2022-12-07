package com.uni.section01.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceMethodTest
 */
@WebServlet("/request-service")
public class ServiceMethodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceMethodTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* 요청값, servlet 서비스의 요소값들을 전달 시킨다
		  * 즉 클라이언트부터 서버 요청이 들어오면 생성하여 get, post형식으로 클라이언트에 전달
		  * 만약 회원정보같은걸 컨트롤러에서 보낼때 이 HttpServletRequest 객체안에 모든 데이터가 전달된다. */  
		HttpServletRequest httpReqyest = (HttpServletRequest) request; 
		HttpServletResponse httpServletResponse = (HttpServletResponse) response; // 호출값
		
		String httpMethod = httpReqyest.getMethod();
		System.out.println(httpMethod);
		
		if(("GET".equals(httpMethod))) {
			doGet(httpReqyest, httpServletResponse);
		}else if("POST".equals(httpMethod)) {
			doPost(httpReqyest, httpServletResponse);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET 요청을 처리할 메소드 호출됨");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST 요청을 처리할 메소드 호출됨");
	}

}
