<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="Views/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="Views/css/PatientReg.css" rel="stylesheet">
<script src="Views/js/PatientReg.js"></script>
<script src="Views/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="Views/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="Views/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"> </script>
<title>Hospital Registration</title>
</head>
<body>
<div class="container">
            <form class="form-horizontal" role="form">
                <h2>Registration</h2>
                <div class="form-group">
                    <label for="husername" class="col-sm-3 control-label">username</label>
                    <div class="col-sm-9">
                        <input type="text" id="husername" placeholder="Please start with h eg: hapollo" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hName" class="col-sm-3 control-label">Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="hName" placeholder="" class="form-control" autofocus>
                    </div>
                </div>        
                <div class="form-group">
                    <label for="hpassword" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="hpassword" placeholder="Must be 8 characters" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="hpassword" class="col-sm-3 control-label">Confirm Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="hpassword" placeholder="Must be 8 characters" class="form-control">
                    </div>
                </div>                
                 <div class="form-group">
                    <label for="address" class="col-sm-3 control-label">Address</label>
                    <div class="col-sm-9">
                        <input type="text" id="address" placeholder="Address" class="form-control" autofocus>
                    </div>
                </div>               
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                <button action="Login.jsp" type="submit" class="btn btn-primary btn-block">Register</button>
            </form> 
        </div> 
        </body>
        </html>