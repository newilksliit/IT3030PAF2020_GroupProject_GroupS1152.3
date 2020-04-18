<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="Views/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="Views/css/Login.css" rel="stylesheet">
<script src="Views/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Users</title>
</head>
<body>
<table class="table table-bordered">
	<tr>
	<th>username</th>
	<th>password</th>
	</tr>
	<tr>
	<%
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();			
			   
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hdb", "root", "");
			
			String query = "select * from user";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				%>
				<td><%=rs.getString("username") %></td>
				<td><%=rs.getString("password") %></td>
				<%
			}
			
		}catch(Exception e){
			out.println("Exception" + e.getMessage());
			e.printStackTrace();
		}
	
	%>
	<td></td>
	<td></td>
	</tr>
</table>
</body>
</html>