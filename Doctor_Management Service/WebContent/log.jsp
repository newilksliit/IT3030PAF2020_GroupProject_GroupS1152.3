<!DOCTYPE html>
<html>
<style>


body{
background-image: url(bg2.jpg);
            background-size: cover;
            margin: 0px;
            padding: 0px;
            
            }

input[type=text], select {

    width: 70%;
    padding: 12px 20px;
    margin: 20px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 2px;
    box-sizing: border-box;
}

input[type=password], select {
    width: 70%;
   
    padding: 12px 20px;
    margin: 20px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius:2px;
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
<body>
 

<body background="bg2.jpg">
<div>
  <form action="verify.jsp"method="get">
  <img src="login.jpg" alt="Avatar" class="avatar"/>
    <br><label for="fname"><b>User Name</label>
    <input type="text"name="uname"/><br>

    <label for="lname"><b>   Password</label>
    <input type="password"width="30"name="pass"/><br>
    <input type="submit"value="Login"/><br>
    <font color="black"><a href="reg.jsp">register</a></font>
  </form>
</div>

</body>


</html>
