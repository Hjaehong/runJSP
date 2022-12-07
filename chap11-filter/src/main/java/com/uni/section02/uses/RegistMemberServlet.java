package com.uni.section02.uses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Servlet implementation class RegistMemberServlet
 */
@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + password);
		System.out.println("name : " + name);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("비밀번호가 pass01 인지 확인" + passwordEncoder.matches("pass01", password));
		System.out.println("비밀번호가 pass02 인지 확인" + passwordEncoder.matches("pass02", password));
				/*    평문+salt값(랜덤값) == 솔팅기법
				 *    apple + fnidon =>dmekfnkwfkejnf
				 *    apple + dokenf=>enwjenfjenfjen
				 *    매번 입력한 평문에 랜덤값 salt을 붙여서 암호화 시키는 방식을 디크리트 방식이라고한다.
				 *    matches(비교할 문자열 (평문), 암호화된 다이제스트) -> 결과 트루
				 */
	}

}
