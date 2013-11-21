<%@ page import="fr.upmc.ta.mdoc.object.Member"%> 
<%@ page import="fr.upmc.ta.mdoc.object.MembersContainer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Voici la liste des membres :</h2>
<%
	Object o = request.getSession().getAttribute("members");
	if (o instanceof MembersContainer) {
		MembersContainer members = (MembersContainer) o;
		while (!members.isEmpty()) {
			Member member = members.pop();
			%>
			<form method="POST" action="./DeleteMember">
				<p><%=member.toString()%> </p>
				<input type="hidden" name="memberId" value="<%=member.getId()%>" />
				<input type="submit" value="Delete">
			</form>
			<%
		}
	}
%>
</body>
</html>