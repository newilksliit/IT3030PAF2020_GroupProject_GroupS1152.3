<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="Views/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="Views/css/Login.css" rel="stylesheet">
<script src="Views/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Login</title>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>Username</label>
                     <input type="text" class="form-control" placeholder="Username">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
                  <button action ="UserType.jsp" type="submit" class="btn btn-secondary">Register</button>
               </form>
            </div>
         </div>
      </div>
</body>
</html>