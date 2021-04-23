package com.filter;

import javax.servlet.http.*;

//wrapper클래스 만들기
//HttpServletRequestWrapper 클래스를 상속 받아서 구현을 함
//상속받아서 구현을 하게되면 반드시 매개변수가 있는 생성자 한 개를 선언을 해야한다.


public class MyWrapper extends HttpServletRequestWrapper  {

	public MyWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
// HttpServletRequest 객체를 매개변수로 받아야한다.  그리고 부모 생성자를 안에서 만들어줘야한다.	
// 개발자의 로직대로 구현할 메소드를 재 정의하면 된다.
	
	
	
	@Override
		public String getParameter(String key) {
			
			
			return super.getParameter(key)+"-sh-";
//			HttpServletRequest.getParameter값을 불러와서 문자열을 추가적으로 붙여서 출력해준다. 
		}

}
