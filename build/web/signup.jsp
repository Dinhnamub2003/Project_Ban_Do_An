<%-- 
    Document   : homePage
    Created on : Oct 11, 2023, 4:15:17 PM
    Author     : Truong cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <title>Signup</title>
        <link rel="stylesheet" href="reset.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        
        
        <div class="signup">
            <h1 class="signup-heading">Sign up</h1>
            <button class="signup-social">
                <i class="fa fa-google signup-social-icon"></i>
                <span class="signup-social-text">Sign up with Google</span>
            </button>
            <div class="signup-or"><span>Or</span></div>
           
           <form action="signup" method="get"  class="signup-form" autocomplete="off">
        <label for="username" class="signup-label">Username</label>
        <input type="text" id="username" name="user1" class="signup-input" placeholder="Ex:sign up Truongcun">
        <label for="password" class="signup-label">Password</label>
        <input type="password" id="pass" name="pass1" class="signup-input" placeholder="Ex:sign up Kibyhunter2k3">
        <div> ${requestScope.error}</div>
                    <button type="submit" class="signup-submit">Signup now</button>

            
            <p class="signup-already">
                <span>Already have an account ?</span>
                <a href="#" class="signup-login-link">Login</a>
            </p>
        </div>
    </body>
</html>