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
			<form method="POST" action="./ModifyMember">
				<p><%=member.toString()%> </p>
				<input type="hidden" name="memberId" value="<%=member.getId()%>" />
				Login : <input type="text" name="login" value="<%=member.getLogin() %>" /><br />
				Age : <input type="text" name="age" value="<%=member.getAge() %>" /><br />
				
				<p>Modifier le password</p>
				Password : <input type="password" name="oldPassword" value="" /><br />
				New password : <input type="password" name="password1" value="" /><br />
				Confirmation : <input type="password" name="password2" value="" /><br />
				<input type="submit" value="Modify">
			</form>
			<%
		}
	}
%>
</body>
</html>