package com.listener;

import java.time.*;

import javax.servlet.*;

//리스너 구현 클래스 작성
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener{
//	------------------------------------------------------------------------------------------
	@Override //서버가 종료되면 실행하는 리스너 메소드
		public void contextDestroyed(ServletContextEvent sce) {
						System.out.println("서버가 종료되었습니다.");
			LocalDateTime now = LocalDateTime.now();
						System.out.println(now);

		}

	@Override //서버가 실행되면 실행하는 리스너 메소드
		public void contextInitialized(ServletContextEvent sce) {
						System.out.println("서버가 기동되었습니다.");
			LocalDateTime now = LocalDateTime.now();
						System.out.println(now);
		}
//	---------------------------------------------------ServletContextListener
		/*
		 * 
		 * 
		 * */	
//	------------------------------------------------------------------------------------------

	@Override //ServletContext 객체에 setAttribute로 값을 추가했을 때를 트리거로 실행되는 메소드
		public void attributeAdded(ServletContextAttributeEvent event) {
			// TODO Auto-generated method stub
							System.out.println("context값을 추가함");
							System.out.println(event.getName());
							System.out.println(event.getValue());
		}

	@Override // ServletContext 객체에 removeAttribute로 값을 삭제했을 때를 트리거로 실행되는 메소드
		public void attributeRemoved(ServletContextAttributeEvent event) {
			// TODO Auto-generated method stub
							System.out.println("context값을 삭제함");
		}

	@Override // ServletContext 객체에서 setAttribute로 기존의 키 값에 할당된 값을 덮어쓰는 것을 트리거로 실행되는 메소드
		public void attributeReplaced(ServletContextAttributeEvent event) {
			// TODO Auto-generated method stub
							System.out.println("context값을 수정함");
			
		}
//	---------------------------------------------------ServletContextAttributeListener

}
