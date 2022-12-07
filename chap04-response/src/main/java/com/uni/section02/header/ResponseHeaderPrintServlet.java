package com.uni.section02.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderPrintServlet
 */
@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseHeaderPrintServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

		// 1초씩 갱신 시켜준다.
//		response.setHeader("Refresh", "1");
		PrintWriter out = response.getWriter();
		// 현재시간을 밀리초로 나타낸다.
		long currentTime = System.currentTimeMillis();

		out.print("<h1>" + currentTime + "</h1>");

		out.close();
		// 헤더정보출력하기
		Collection<String> responseHeaders = response.getHeaderNames();
		Iterator<String> iter = responseHeaders.iterator();
		// Content Type, 응답코드, 응답 메시지등을 담아서 전송함
		while (iter.hasNext()) {
			// response에 관련된 정보를 담는다.
			String headerName = iter.next();
			System.out.println("header의" + headerName + " : " + response.getHeader(headerName));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
