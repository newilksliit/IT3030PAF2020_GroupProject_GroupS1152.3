
<%@ page import ="java.sql.*" %>
<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOCTORS INFORMATION WINDOW</title>
<style>

.abc{
background-color:rgba(255,255, 255, 0.5);
width:850px;
height: 100%;
margin-left:auto;
margin-right:auto;
padding: 15px; }
body{
background-image: url(back.jpg);
            background-size: cover;
            margin: 0px;
            padding: 0px;
            
            }
<style type="text/css">
.form-style-6{
    font: 95% Arial, Helvetica, sans-serif;
    max-width: 400px;
    margin: 10px auto;
    padding: 16px;
    background: #F7F7F7;
}
.form-style-6 h1{
    background: #428bca;
    padding: 20px 0;
    font-size: 140%;
    font-weight: 300;
    text-align: center;
    color: #fff;
    margin: -16px -16px 16px -16px;
}
.form-style-6 input[type="text"],
.form-style-6 input[type="date"],
.form-style-6 input[type="datetime"],
.form-style-6 input[type="email"],
.form-style-6 input[type="number"],
.form-style-6 input[type="search"],
.form-style-6 input[type="time"],
.form-style-6 input[type="url"],

.form-style-6 textarea,
.form-style-6 select 
{
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none;
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    width: 30%;
    background: #fff;
    margin-bottom: 3%;
    border: 1px solid #ccc;
    padding: 1%;
    color: #555;
    font: 95% Arial, Helvetica, sans-serif;
}
.form-style-6 input[type="text"]:focus,
.form-style-6 input[type="date"]:focus,
.form-style-6 input[type="datetime"]:focus,
.form-style-6 input[type="email"]:focus,
.form-style-6 input[type="number"]:focus,
.form-style-6 input[type="search"]:focus,
.form-style-6 input[type="time"]:focus,
.form-style-6 input[type="url"]:focus,
.form-style-6 textarea:focus,
.form-style-6 select:focus

{
    box-shadow: 0 0 20px #43D1AF;
    padding: 3%;
    border: 1px solid #43D1AF;
}

.form-style-6 input[type="submit"],
.form-style-6 input[type="button"]{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    width:10%;
    padding: 1.5%;
    background: #428bca;
    border-bottom: 2px solid #30C29E;
    border-top-style: none;
    border-right-style: none;
    border-left-style: none;    
    color: #fff;
}
.form-style-6 input[type="submit"]:hover,
.form-style-6 input[type="button"]:hover{

    background: blue;
}
input[type=reset] {
    width: 10%;
    height:2%;
    background-color: #428bca;
    color: white;
    padding: 14px 20px;
    margin: 20px 0;
    border: none;
    border-radius: 2px;
    cursor: pointer;
}

#fon{
    font-colour:black;




}

input[type=reset]:hover {
    background-color: blue;
}

</style>

</head>
</head>
<body background="Hospital main entrance-blue sky.jpg" bgproperties="fixed">
<center>

<h1>DOCTOR PROFILE WINDOW</h1>

<br><br><br>


<div class="form-style-6">
<form action="addoc.jsp" method=post>
<%!String a="",b="",d="",e="",f="",g="",h="",i="",j=""; %>
<div class="abc">

DOCTOR ID<input type="text" name="t1" maxlength=10 size=20>

<div class="abc">
<h4>DOCTOR DETAILS</h4>


<%
try
{	a=request.getParameter("Button1"); 
	if(a.equals("SEARCH DOCTOR PROFILE"))
	{
	String str1= request.getParameter("t1");
	Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jani",
        "root", "");
	Statement s= c.createStatement();
	if(str1!="")
	{	
		String sql2="select * from doctor where doc_id='"+str1+"'";
		ResultSet r=s.executeQuery(sql2);
		if(r.next())
		{
			j=r.getString(1);
			b=r.getString(2);	
			d=r.getString(3);
			e=r.getString(4);
			f=r.getString(5);
			g=r.getString(6);
			h=r.getString(7);
			i=r.getString(8);
		}
		else
		{	
			%><script language="javascript">
			alert("DOCTOR ID=<%=str1%>does not exist in database..!!!");
			</script>
			<%			
		}	
		
	}
	else
	{
		%><script language="javascript">
		alert("ENTER DOCTOR ID TO SEARCH..!!!");
		</script>
		<%		
	}
	}
}catch(Exception e) {}
%>



<br>
<br>
DOCTOR NAME<br><input type="text" name="t2" maxlength=10 size=20 value=<%=b%>><BR>
DOCTOR EDUQUALIFICATION<br><input type="text" name="t3" maxlength=10 size=20 value=<%=d%>><BR>
DATE OF BIRTH<br><input type="text" name="t4" maxlength=10 size=20 value=<%=e%>><BR>
SALARY<br><input type="text" name="t5" maxlength=10 size=20 value=<%=f%>><BR>
FATHER'S NAME<br><input type="text" name="t6" maxlength=10 size=20 value=<%=g%>><BR>
EMAIL ID<br><input type="text" name="t7" maxlength=10 size=20 value=<%=h%>><BR>
DEPARTMENT ID<br><input type="text" name="t8" maxlength=10 size=20 value=<%=i%>><BR>
</ol>
<%
try{
	
	a=request.getParameter("Button1");
	String str1= request.getParameter("t1");
	String str2= request.getParameter("t2");
	String str3= request.getParameter("t3");
	String str4= request.getParameter("t4");
	String str5= request.getParameter("t5");
	String str6= request.getParameter("t6");
	String str7= request.getParameter("t7");
	String str8= request.getParameter("t8");
	Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jani",
        "root", "");
	Statement s= c.createStatement();
	if(a.equals("ADD DOCTOR PROFILE"))
	{	

	if(str1!=""&&str2!=""&&str3!=""&&str4!=""&&str5!=""&&str6!=""&&str7!=""&&str8!="")
	{	
		String sql="insert into `doctor`(`t1`, `t2`, `t3`, `t4`, `t5`, `t6`, `t7`, `t8`) values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+",'"+str6+"','"+str7+"',"+str8+")";
		out.println(sql);
		s.execute(sql);
		%><script language="javascript">
		alert("INSERT SUCESSFUL");
		</script>
		<%
	}
	else
	{
		%><script language="javascript">
		alert("ENTER COMPLETE DETAILS..!!!");
		</script>
		<%		
	}
	}
	else if(a.equals("DELETE DOCTOR PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from doctor where doc_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				
				String sql="delete from doctor where doc_id="+str1+"";
				s.execute(sql);
				%><script language="javascript">
				alert("PROFILE OF DOCTOR WITH ID <%=str1%>DELETED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DOCTOR ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DOCTOR'S ID TO DELETE..!!!");
			</script>
			<%	
		}
	}
	else if(a.equals("EDIT DOCTOR PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from doctor where doc_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				String sql="delete from doctor where doc_id="+str1+"";
				s.execute(sql);
				String sql1="insert into doctor values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+",'"+str6+"','"+str7+"',"+str8+")";
				s.execute(sql1);
				%><script language="javascript">
				alert("PROFILE OF DOCTOR WITH ID <%=str1%>EDITED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DOCTOR ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DOCTOR'S ID TO EDIT..!!!");
			</script>
			<%	
		}
	}
	}catch(Exception e) {}

%>


</form>
<input type="submit"  name="Button1" value="ADD ">
<input type="submit"  name="Button1" value="SEARCH  ">
<input type="submit"  name="Button1" value="DELETE  ">
<input type="submit"  name="Button1" value="EDIT  ">




</center>


</body>
</html>
