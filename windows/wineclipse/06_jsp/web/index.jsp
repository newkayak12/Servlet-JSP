<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 맨 위 지시자는 무조건 있어야 한다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO MY FIRST JSP PAGE</h1>
	<h2>JSP 태그에 대해서 알아보자 </h2>
	<pre>
		JSP 태그는 html 문서에서 자바 코드를 사용할 수 있게 하는 태그로 &lt;%&gt; > 태그에 %가 있으면 자바코드로 인식한다.
			예) 지역변수, 조건문, 반복, 메소드(get/set)를 호출할 때 사용
		기본적인 자바 코드를 작성할 때는  &lt;%&gt; (스크립트립태그)를 이용해서 작성한다.
		
		
		jsp를 통해 생성되는 클래스의 멤버변수, 메소드 등을 선언할 때는 &lt;%!&gt;(지시자 태그)를 사용한다.
		
		자바코드로 작성된 변수를 html화면에 출력하려면 &lt;%=&gt;(표현식 태그)를 사용한다.
	</pre>
	
	
	<h3>선언문 태그 사용하기</h3>
	<%!
		//클래스 선언부에 작성되는 코드를 작성할 수 있다.
		String name = "유병승";
		private int age = 19; //접근 제한자도 사용할 수 있다.
				/* if(name.eqquals("유병승")){
					
				} 클래스 선언부에 들어가는 코드로 조건문, 반복문을 사용할 수 없다. */
				
		public String test(){
				return "점심은 맛있어!";
		}
	%>
	
	<h3>선언된 자바 코드 화면에 출력하기</h3>
	<h4>당신의 이름은 <%=name %></h4>
	<h4>당신의 나이는 <%=age %></h4>
	<h4>메소드 실행 : <%=test() %></h4>
	
	
	<h3>스크립트립을 이용하기</h3>
	<pre> 
		지역변수, 조건문, 반복문등을 사용하기 위해서
	</pre>
	<%
		String addr = "경기도 시흥시";
		double height = 180.5;
		String[] names = {"유병승","김상현","김예진","김두호","김지한"};
		
		
	%>
	
	<ul>
		<% for (int i =0; i<names.length; i++){ 
			if(names[i].equals("유병승")){
		%>
			<li><%= names[i] %></li>
		<%}} %>
	</ul>
	
	
	<%if(age>18) {%>
		<h1> 당신은 18세 이상이네요</h1>
	<%} else {%>
		<h1> 당신은 미성년이네요</h1>
	
	<%} %>
	
	
	<a href = "views/InnerObj.jsp">jsp</a>
	
	<h2> 내장 객체의 값 출력하기</h2>
	<%
		String[] hobby = (String[]) request.getAttribute("hobby");
		String userId= (String) session.getAttribute("userId");
		String adminEmail = (String) application.getAttribute("email");
	%>
	<% if(hobby != null){ %>
		<h2>당신의 취미는</h2>
		<ul>
			<% for (String h : hobby){ %>
				<li><%=h %></li>
			<%} %>
		</ul>
	<%} %>
	<h2> session의 값은 <%=userId %></h2>
	<h2> application의 값은 <%=adminEmail %></h2>
	
	
</body>
</html>