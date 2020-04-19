<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

* {box-sizing: border-box}


input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

button {
    background-color: blue ;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}


.container {
    padding: 16px;
}


.clearfix::after {
    content: "";
    clear: both;
    display: table;
}



</style>
</head>
<body>
<form action="GetLeaveServlet" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1><center><font size="7" color="blue">Report Form</font></h1></center>
    
    <hr>
    
    <fieldset>
    <legend><font face="Comic Sans MS" size="4" color="black">Information</legend>
    
    <label for="Lname"><font face="Comic Sans MS" size="4" color="black"><b>Patient ID</b></label>
    <input type="text" placeholder="" name="EmpID" ><hr>
    
    
    <label for="psw-repeat"><b>Type Of Report</b></label><br>
   
    <label class="container" >Pathology Report
    <input type="radio" name="Type" checked="checked" tabindex="1" value="Official">
    </label>

    <label class="container">Labotary Report
    <input type="radio" name="Type" tabindex="2" value="Personal">
    </label><hr>

    <label><b>Dates of Request</b><br>
    <input type="date"placeholder="DD/MM/YYYY" name="Start"> <br/>
    <label><b>to</b><br>
    <input type="date"placeholder="DD/MM/YYYY" name="End"> 
    
    </label><hr>
    </fieldset>


    <fieldset>
    <legend><font face="Comic Sans MS" size="4" color="black">Reason</legend>
    
    <label for="Q1"><b>Reason </b></label>
    <input type="text"  name="Reason"><hr>  
   
    </fieldset>
       
    <div class="clearfix">
      <button type="submit">Apply</button>
      <button type="button">Cancel</button>
      
    </div>
</div>
</form>
</body>
</html>