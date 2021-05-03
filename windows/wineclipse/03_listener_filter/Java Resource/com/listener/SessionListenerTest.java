package com.listener;

import javax.servlet.http.*;

import org.apache.catalina.*;

public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {
//---------------------------------------------------------------------------------------------
//	HttpSessionListener
	@Override
		public void sessionCreated(HttpSessionEvent se) {
//			request.getSession()이 실행되면 세션이 실행 됨 _ 로그인하고 세션객체를 불러오고 그 안에 값을 넣어서 처리...
						System.out.println("Session Listener 생성");
//		어디서든 getSessiong을 한 번은 실행해야 함 그래야 이벤트가 실행
//		JSessionID : 세션이 생성하면 아이디 값을 준다.  
		}

	@Override
		public void sessionDestroyed(HttpSessionEvent se) {
//			session.invalidate() 가 실행되면 세션이 종료되면서 그 것을 트리거로 세션 리스너가 작동

		
						System.out.println("Session Listener 소멸");
		
		//---------------------------------------------------------------------------------------------
		
//		--------------------HttpSessionAttributeListener
		}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
						System.out.println("session Attribute 생성");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	


}
