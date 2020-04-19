<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
     
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
<style>


body{
background-image: url(bg3.jpg);
            background-size: cover;
            margin: 0px;
            padding: 0px;
            
            }

input[type=text], select {

    width: 70%;
    padding: 12px 20px;
    margin: 10px 0;
    display: inline-block;
    border: 5px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=password], select {
    width: 70%;
   
    padding: 12px 20px;
    margin: 20px 0;
    display: inline-block;
    border: 5px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}


input[type=submit] {
    width: 30%;
    background-color: #4CAF50;
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
input[type=reset] {
    width: 30%;
    background-color: #4CAF50;
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

input[type=submit]:hover {
    background-color: blue;
}


div {
     top: 40%;
            left: 50%;
            position: absolute;
            width: 300px;
            height: 400px;
            margin-top: -200px;
            background: rgba(255,255, 255, 0.5);
            margin-left: -250px;
            padding: 20px 30px;
            line-height: 50px;
}
img.avatar {
    width: 40%;
    border-radius: 50%;
                margin-left: 80px;
     
}

.container {
    padding: 16px;
                margin-left: 80px;
}

span.psw {
    float: right;
    padding-top: 16px;
                margin-left: 80px;
}

</style>
    <body background="bg3.jpg">
    <div>
     <img src="login.jpg" alt="Avatar" class="avatar"/>
    
        <form method="post" action="login.jsp">
            <center>
        
                      
                      <br><label for="fname"><b>User Name</label> <input type="text" name="uname" value="" />
                    
                        <br><label for="fname"><b>Password</label>
                        <input type="password" name="pass" value="" />
                    
                       <input type="submit" value="Login" />
                        <input type="reset" value="Reset" />
                        </br> <a href="reg.jsp">Register Here</a>
                 
            </center>
        </form>
        </div>
    </body>
</html>