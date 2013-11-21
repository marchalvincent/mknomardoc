<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
Welcome !<br />
<%
String message = (String) request.getAttribute("message");
if (message != null) {
	%>
	<p><%=message %></p>
	<%
}
%>
<a href="./AddMember.jsp">Add member</a><br />
<a href="./ModifyMember">Modify member</a><br />
<a href="./DeleteMember">Delete member</a><br />
</body>
</html>