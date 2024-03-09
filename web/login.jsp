<%-- 
    Document   : login
    Created on : Oct 11, 2023, 4:54:36 PM
    Author     : Truong cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link href="css/styleLogin.css" rel="stylesheet" type="text/css"/>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <title>Login</title>
        <link rel="stylesheet" href="reset.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
     <body>
         
    <div class="signup">
        
        
      <h1 class="signup-heading">Login </h1>
      <button class="signup-social">
        <i class="fa fa-google signup-social-icon"></i>
        <span class="signup-social-text">Login with Google</span>
      </button>
      <div class="signup-or"><span>Or</span></div>
      
      
      <form action="login" method="post"  class="signup-form" autocomplete="off">
        <label for="username" class="signup-label">Username</label>
        <input type="text" id="username" name="user" class="signup-input" placeholder="Ex: Truongcun">
        <label for="password" class="signup-label">Password</label>
        <input type="password" id="pass" name="pass" class="signup-input" placeholder="Ex:Kibyhunter2k3">
        
        <h3 style="color : red"> ${error} </h3>
        <h2 style="color : red"> ${mas} </h2>
        
        <button type="submit" class="signup-submit">Login now</button>
      </form>
      <p class="signup-already">
        <span>Already have an account ?</span>
        <a href="signup.jsp" class="signup-login-link">Sign up</a> <br><!-- comment -->
        <a href="ChangePass.jsp" class="signup-login-link">change password</a><br>
        <a href="forgotPassword.jsp" class="signup-login-link">Forgot password</a>
      </p>
    </div>
         
         
  </body>
    
    
</html>
