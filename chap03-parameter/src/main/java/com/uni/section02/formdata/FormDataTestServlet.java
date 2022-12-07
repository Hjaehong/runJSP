package com.uni.section02.formdata;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormDataTestServlet
 */
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormDataTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 기본적으로 설정된 인코딩 값은 null값이다.
		System.out.println(request.getCharacterEncoding());
		/*
		 * post방식으로 전달받은 데이터에 한글이 있는 경우에는 한글이 깨지게 된다. GET 방식의 데이터는 HTML charset에 기술된 인코딩
		 * 방식으로 인코딩하지않고 브라우저가 한글을 이해한 뒤 %문자로 URLEncoder를 이용하여 변환 후 url 요청으로 전송한다. 이 때
		 * header의 내용은 ascii 코드로 전송되기 때문에 어떠한 언어이든 서버쪽 설정 인코딩 방식과 맞기만 하면 url 요청은
		 * URLEncoder로 해석하는데 문제가 없기에 한글이 깨지지 않는다. GET 요청은 보통 서버쪽 리소스를 가져오는 용도의 행위를 요청하는
		 * http 요청 방식이기에 별도의 데이터가 필요 없어서 요청 본문(페이로드)는 해석하지 않게 된다. 하지만 POST 요청은 서버쪽 리소스에
		 * 내용을 추가하는 용도의 요청이기 때문에 요청하는 데이터가 필요한 경우가 많다. 이러한 서버쪽 리소스에 추가해야 하는 정보를 페이로드에
		 * key:value 방식으로 담아 전송을 하는데, 헤더와는 별개로 URLEncoder를 이용하지 않고 페이지 meta에 기술된
		 * charset에 따라 UTF-8로 해석된 데이터를 서버로 전송하게 된다. 기본적으로 서버 쪽에서 페이로드를 디코딩 하는 방식은 별도로
		 * 지정되어 있지 않아 request.getCharacterEncoding()을 호출해보면 null을 반환하는데, 인코딩 된 방식을 명시해주지
		 * 않으면 기본 ISO-8859-1로 해석하게 되어 값을 꺼내오면 글자가 깨지는 현상이 발생한다. 이 때 parameter를 꺼내오기 전에
		 * parameter값을 해석할 인코딩 방식이 UTF-8임을 setCharacterEncoding(String encType)으로 지정해주면
		 * 브라우저에서 요청한 인코딩 방식과 일치하게 되어 한글 깨짐 현상을 막을 수 있다.
		 */
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		// 제대로 넘어왔는지 확인
		System.out.println("이름 :" + name);

		// map 방식으로 받기
		Map<String, String[]> reqeustMap = request.getParameterMap();
		// key목록만 set으로 받는다.
		Set<String> keySet = reqeustMap.keySet();

		Iterator<String> keyIter = keySet.iterator();

		while (keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = reqeustMap.get(key);

			System.out.println("key : " + key);
			for (int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " + value[i]);

			}
		}
		// key값을 뽑을 수 있다
		// iterator의 조상버전
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
	}
}
