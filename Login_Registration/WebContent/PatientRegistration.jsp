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
<title>Patient Registration</title>
</head>
<body>
<div class="container">
            <form class="form-horizontal" role="form">
                <h2>Registration</h2>
                <div class="form-group">
                    <label for="pusername" class="col-sm-3 control-label">username</label>
                    <div class="col-sm-9">
                        <input type="text" id="fName" placeholder="Please start with p eg: pfernando34" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="fName" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="fName" placeholder="First Name" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="lName" placeholder="Last Name" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ppassword" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="ppassword" placeholder="Must be 8 characters" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ppassword" class="col-sm-3 control-label">Confirm Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="ppassword" placeholder="Must be 8 characters" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="dob" class="col-sm-3 control-label">Date of Birth*</label>
                    <div class="col-sm-9">
                        <input type="date" id="dob" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ccNo" class="col-sm-3 control-label">Credit Card Number* </label>
                    <div class="col-sm-9">
                        <input type="number" id="ccNo" placeholder="Phone number" class="form-control">
                        <span class="help-block">Your Credit Card number won't be disclosed anywhere </span>
                    </div>
                </div>
                <div class="form-group">
                        <label for="expDate" class="col-sm-3 control-label">Expiry Date* </label>
                    <div class="col-sm-9">
                        <input type="text" id="expDate" placeholder="mm/yy" class="form-control">
                    </div>
                </div>
                 <div class="form-group">
                        <label for="cvc" class="col-sm-3 control-label">Card Verification Code* </label>
                    <div class="col-sm-9">
                        <input type="number" id="cvc" placeholder="Please enter the numbers at the back of your card" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form> 
        </div> 
        </body>
        </html>