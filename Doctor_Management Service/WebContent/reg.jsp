<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>

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
    <body>
 
            
            <div class="form-style-6">
        <form method="post" action="regis.jsp">
            <center>
            <h1>Enter Information Here</h1></br>
            <div class="abc">
      
            
                        
                       <input type="text" name="fname" value="" placeholder="Doctor ID" /><br>
                    
                        
                        <input type="text" name="lname" value=""placeholder="Name" /><br>
                    
                        
                        <input type="text" name="email" value="" placeholder="Occupation"/><br>
                   
                    
                        <input type="text" name="uname" value=""placeholder="Nationality" /><br>
                    
                    
                       
                        <input type="text" name="pass" value=""placeholder="Email" /><br>
                    
                  
                        <input type="submit" value="Submit" />
                       <input type="reset" value="Reset" /><br>
                    
                        Already registered!! <a href="customer2.jsp">Login Here</a>
                       
                  
            </center>
        </form>
    </body>
</html>