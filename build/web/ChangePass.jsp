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
        <title>Change Pass</title>
        <link rel="stylesheet" href="reset.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>


        <div class="signup">
            <h1 class="signup-heading">Change password</h1>
            <button class="signup-social">
                <i class="fa fa-google signup-social-icon"></i>
                <span class="signup-social-text">Sign up with Google</span>
            </button>
            <div class="signup-or"><span>Or</span></div>

            <form action="change" method="get"  class="signup-form" autocomplete="off">
                <label for="username" class="signup-label">Username</label>
                <input type="text" id="username" name="user" class="signup-input" placeholder="Ex: Truongcun">
                <label for="password" class="signup-label">Old password</label>
                <input type="password" id="pass" name="oldpass" class="signup-input" placeholder="Ex:old Kibyhunter2k3">

                <label for="newpassword" class="signup-label">New password</label>
                <input type="password" id="pass" name="newpass" class="signup-input" placeholder="Ex:new Kibyhunter2k3">

                <h3 style ="color: red"> ${error}</h3>

                <button type="submit" class="signup-submit">Change</button>


                <p class="signup-already">
                    <span>Already have an account ?</span>
                    <a href="login.jsp" class="signup-login-link">Login</a>
                </p>
        </div>
    </body>
</html>