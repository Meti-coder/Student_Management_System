<%@page import="java.util.List"%>
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
<% List<Student> student =(List<Student>)request.getAttribute("key"); %>

<h1>All Your Student Details:-</h1>

<table border="2px" cellpadding="2px" cellspacing="0px">

<tr>
	<th>studentId</th>
	<th>studentName</th>
	<th>studentEmail</th>
	<th>mobile</th>
	<th>studentMarks</th>
	<th>Update</th>
	<th>Delete</th>
	
</tr>

<%for(Student students: student) {%>

<tr align="center">
			<td><%=students.getStudentId()%></td>
			<td><%=students.getStudentName()%></td>
			<td><%=students.getStudentEmail()%></td>
			<td><%=students.getMobile()%></td>
			<td><%=students.getStudentMarks()%></td>
			<td><button> <a href="update?id=<%= students.getStudentId()%>">update</a> </button></td>
			<td><button>  <a href="delete?id1=<%= students.getStudentId()%>">delete</a> </button></td>

		</tr>
		<%
		}
		%>

</table>
  <h2> <a href="index.jsp">Take Me Back To The DashBoard:-</a> </h2>
</body>
</html>