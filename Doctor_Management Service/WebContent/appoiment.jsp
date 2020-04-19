<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title></title>
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

  
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="plugins/cubeportfolio/css/cubeportfolio.min.css">
  <link href="css/nivo-lightbox.css" rel="stylesheet" />
  <link href="css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
  <link href="css/owl.carousel.css" rel="stylesheet" media="screen" />
  <link href="css/owl.theme.css" rel="stylesheet" media="screen" />
  <link href="css/animate.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet">

  <!-- boxed bg -->
  <link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
  <!-- template skin -->
  <link id="t-colors" href="color/default.css" rel="stylesheet">

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">


  
                    
     

 </BR></BR></BR></BR></BR></BR></BR></BR></BR></BR>
 <form action="appServlet" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1><center><font size="7" color="blue">Appoiment</font></h1></center>
    
    <hr>
    
    <fieldset>
    <legend><font face="Comic Sans MS" size="4" color="black">Information</legend>
    
    <label for="fname"><font face="Comic Sans MS" size="4" color="black"><b>First Name</b></label>
    <input type="text" placeholder="" name="fName" ><hr>
    
     <label for="Lname"><font face="Comic Sans MS" size="4" color="black"><b>Last Name</b></label>
    <input type="text" placeholder="" name="lName" ><hr>
     
     <label for="pnumber"><font face="Comic Sans MS" size="4" color="black"><b>Phone Number</b></label>
    <input type="text" placeholder="" name="pnumber" ><hr>
    
     <label for="email"><font face="Comic Sans MS" size="4" color="black"><b>Email</b></label>
    <input type="text" placeholder="" name="email" ><hr>
    
   

    
       
    <div class="clearfix">
      <button type="submit">Apply</button>
      <button type="button">Cancel</button>
      
    </div>
</div>
</form>
</body>
</html>
   
</body>

</html>
