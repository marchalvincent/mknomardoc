<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.upmc.ta.mdoc.object.Member"%> 
<%@ page import="java.util.List"%>
<%@ page import="java.lang.Iterable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 	todo liste les members + suppression -->
<!-- 	 rediriger vers le lien ./DeleteMember le servlet est créé -->
<h2>Voici la liste des membres :<h2><br />
<%
	List <Member> members = (List<Member>)request.getSession().getAttribute("members");
	for(Member member : members){
		%>
		<Form methode="post" action="./Deletemember">
			<p><%=member.toString()%> </p>
			<input type="hidden" name="deleteMember" value="<%=member.getId()%>" />
			<input type="submit" value="Modify">
		</Form>
		<%
	}
%>

</body>
</html>