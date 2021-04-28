<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*, com.member.model.vo.*"
    %>

<%	List<Member> members = new ArrayList();
		members.add(new Member("admin", "admin", "관리자", 40));
		members.add(new Member("user01", "user01", "유저일", 40));
		members.add(new Member("user02", "user02", "유저이", 40));
		members.add(new Member("user03", "user03", "유저삼", 40));
		
		request.setAttribute("members", members);
	RequestDispatcher rd = request.getRequestDispatcher("viewmember.jsp");
		rd.forward(request, response);
	
	



%>

