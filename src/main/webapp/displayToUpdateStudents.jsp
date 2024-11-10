<%@page import="com.jsp.spring_mvc_studentdb.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	Student id = (Student) request.getAttribute("keyId");
	%>

	<h1>Enter the data to be updated:--</h1>

	<form action="finalUpdate" method="post">
	<input type="number"  value="<%= id.getStudentId()%>"     readonly="readonly"   name="studentId"> <br>
	<input type="text"    value="<%= id.getStudentName()%>"   name="studentName"> <br>
	<input type="text"    value="<%= id.getStudentEmail()%>"  name="studentEmail"> <br>
	<input type="number"  value="<%= id.getMobile()%>"        name="mobile"> <br>
	<input type="number"  value="<%= id.getStudentMarks()%>"  name="studentMarks"> <br>
	<input type="submit"  value="UPDATE">
	
	</form>


</body>
</html>