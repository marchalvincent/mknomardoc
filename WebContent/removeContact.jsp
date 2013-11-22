<%@ page import="domain.Contact"%>
<%@ page import="util.ContactsContainer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer un contact</title>
</head>
<body>
	<h2>Supprimer un contact :</h2>
	<form method="POST" action="./RemoveContact">
		<input type="text" name="memberId" value="" />
		<input type="submit" value="Delete">
	</form>
</body>
</html>