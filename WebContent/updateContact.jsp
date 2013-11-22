<%@ page import="domain.Contact"%> 
<%@ page import="util.ContactsContainer"%>
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
	if (o instanceof ContactsContainer) {
		ContactsContainer contacts = (ContactsContainer) o;
		while (!contacts.isEmpty()) {
			Contact contact = contacts.pop();
%>
			<form method="POST" action="./UpdateContact">
				<p><%=contact.toString()%> </p>
				<input type="hidden" name="memberId" value="<%=contact.getId()%>" />
				First name : <input type="text" name="firstName" value="<%=contact.getFirstName() %>" /><br />
				Last name : <input type="text" name="lastName" value="<%=contact.getLastName() %>" /><br />
				Email : <input type="text" name="email" value="<%=contact.getEmail() %>" /><br />
				<input type="submit" value="Update">
			</form>
			<%
		}
	}
%>
</body>
</html>