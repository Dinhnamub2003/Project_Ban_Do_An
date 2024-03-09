<%-- 
    Document   : information
    Created on : Oct 19, 2023, 5:15:32 PM
    Author     : Truong cun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="css/photo.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/js1.js" type="text/javascript"></script>
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
        <title>JSP Page</title>

        <style>
            body {
                color: #797979;
                background: gray;
                font-family: 'Open Sans', sans-serif;
                padding: 0px !important;
                margin: 0px !important;
                font-size: 13px;
                text-rendering: optimizeLegibility;
                -webkit-font-smoothing: antialiased;
                -moz-font-smoothing: antialiased;
            }

            .profile-nav, .profile-info{
                margin-top:30px;
            }

            .profile-nav .user-heading {
                background: #fbc02d;
                color: #fff;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
                padding: 30px;
                text-align: center;
            }

            .profile-nav .user-heading.round a  {
                border-radius: 50%;
                -webkit-border-radius: 50%;
                border: 10px solid rgba(255,255,255,0.3);
                display: inline-block;
            }

            .profile-nav .user-heading a img {
                width: 112px;
                height: 112px;
                border-radius: 50%;
                -webkit-border-radius: 50%;
            }

            .profile-nav .user-heading h1 {
                font-size: 22px;
                font-weight: 300;
                margin-bottom: 5px;
            }

            .profile-nav .user-heading p {
                font-size: 12px;
            }

            .profile-nav ul {
                margin-top: 1px;
            }

            .profile-nav ul > li {
                border-bottom: 1px solid #ebeae6;
                margin-top: 0;
                line-height: 30px;
            }

            .profile-nav ul > li:last-child {
                border-bottom: none;
            }

            .profile-nav ul > li > a {
                border-radius: 0;
                -webkit-border-radius: 0;
                color: #89817f;
                border-left: 5px solid #fff;
            }

            .profile-nav ul > li > a:hover, .profile-nav ul > li > a:focus, .profile-nav ul li.active  a {
                background: #f8f7f5 !important;
                border-left: 5px solid #fbc02d;
                color: #89817f !important;
            }

            .profile-nav ul > li:last-child > a:last-child {
                border-radius: 0 0 4px 4px;
                -webkit-border-radius: 0 0 4px 4px;
            }

            .profile-nav ul > li > a > i{
                font-size: 16px;
                padding-right: 10px;
                color: #bcb3aa;
            }

            .r-activity {
                margin: 6px 0 0;
                font-size: 12px;
            }


            .p-text-area, .p-text-area:focus {
                border: none;
                font-weight: 300;
                box-shadow: none;
                color: #c3c3c3;
                font-size: 16px;
            }

            .profile-info .panel-footer {
                background-color:#f8f7f5 ;
                border-top: 1px solid #e7ebee;
            }

            .profile-info .panel-footer ul li a {
                color: #7a7a7a;
            }

            .bio-graph-heading {
                background: #fbc02d;
                color: #fff;
                text-align: center;
                font-style: italic;
                padding: 40px 110px;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
                font-size: 16px;
                font-weight: 300;
            }

            .bio-graph-info {
                color: #89817e;
            }

            .bio-graph-info h1 {
                font-size: 22px;
                font-weight: 300;
                margin: 0 0 20px;
            }

            .bio-row {
                width: 50%;
                float: left;
                margin-bottom: 10px;
                padding:0 15px;
            }

            .bio-row p span {
                width: 100px;
                display: inline-block;
            }

            .bio-chart, .bio-desk {
                float: left;
            }

            .bio-chart {
                width: 40%;
            }

            .bio-desk {
                width: 60%;
            }

            .bio-desk h4 {
                font-size: 15px;
                font-weight:400;
            }

            .bio-desk h4.terques {
                color: #4CC5CD;
            }

            .bio-desk h4.red {
                color: #e26b7f;
            }

            .bio-desk h4.green {
                color: #97be4b;
            }

            .bio-desk h4.purple {
                color: #caa3da;
            }

            .file-pos {
                margin: 6px 0 10px 0;
            }

            .profile-activity h5 {
                font-weight: 300;
                margin-top: 0;
                color: #c3c3c3;
            }

            .summary-head {
                background: #ee7272;
                color: #fff;
                text-align: center;
                border-bottom: 1px solid #ee7272;
            }

            .summary-head h4 {
                font-weight: 300;
                text-transform: uppercase;
                margin-bottom: 5px;
            }

            .summary-head p {
                color: rgba(255,255,255,0.6);
            }

            ul.summary-list {
                display: inline-block;
                padding-left:0 ;
                width: 100%;
                margin-bottom: 0;
            }

            ul.summary-list > li {
                display: inline-block;
                width: 19.5%;
                text-align: center;
            }

            ul.summary-list > li > a > i {
                display:block;
                font-size: 18px;
                padding-bottom: 5px;
            }

            ul.summary-list > li > a {
                padding: 10px 0;
                display: inline-block;
                color: #818181;
            }

            ul.summary-list > li  {
                border-right: 1px solid #eaeaea;
            }

            ul.summary-list > li:last-child  {
                border-right: none;
            }

            .activity {
                width: 100%;
                float: left;
                margin-bottom: 10px;
            }

            .activity.alt {
                width: 100%;
                float: right;
                margin-bottom: 10px;
            }

            .activity span {
                float: left;
            }

            .activity.alt span {
                float: right;
            }
            .activity span, .activity.alt span {
                width: 45px;
                height: 45px;
                line-height: 45px;
                border-radius: 50%;
                -webkit-border-radius: 50%;
                background: #eee;
                text-align: center;
                color: #fff;
                font-size: 16px;
            }

            .activity.terques span {
                background: #8dd7d6;
            }

            .activity.terques h4 {
                color: #8dd7d6;
            }
            .activity.purple span {
                background: #b984dc;
            }

            .activity.purple h4 {
                color: #b984dc;
            }
            .activity.blue span {
                background: #90b4e6;
            }

            .activity.blue h4 {
                color: #90b4e6;
            }
            .activity.green span {
                background: #aec785;
            }

            .activity.green h4 {
                color: #aec785;
            }

            .activity h4 {
                margin-top:0 ;
                font-size: 16px;
            }

            .activity p {
                margin-bottom: 0;
                font-size: 13px;
            }

            .activity .activity-desk i, .activity.alt .activity-desk i {
                float: left;
                font-size: 18px;
                margin-right: 10px;
                color: #bebebe;
            }

            .activity .activity-desk {
                margin-left: 70px;
                position: relative;
            }

            .activity.alt .activity-desk {
                margin-right: 70px;
                position: relative;
            }

            .activity.alt .activity-desk .panel {
                float: right;
                position: relative;
            }

            .activity-desk .panel {
                background: #F4F4F4 ;
                display: inline-block;
            }


            .activity .activity-desk .arrow {
                border-right: 8px solid  !important;
            }
            .activity .activity-desk .arrow {
                border-bottom: 8px solid transparent;
                border-top: 8px solid transparent;
                display: block;
                height: 0;
                left: -7px;
                position: absolute;
                top: 13px;
                width: 0;
            }

            .activity-desk .arrow-alt {
                border-left: 8px solid #F4F4F4 !important;
            }

            .activity-desk .arrow-alt {
                border-bottom: 8px solid transparent;
                border-top: 8px solid transparent;
                display: block;
                height: 0;
                right: -7px;
                position: absolute;
                top: 13px;
                width: 0;
            }

            .activity-desk .album {
                display: inline-block;
                margin-top: 10px;
            }

            .activity-desk .album a{
                margin-right: 10px;
            }

            .activity-desk .album a:last-child{
                margin-right: 0px;
            }

            .profile-nav{
                /*background-color: #797979*/
            }
            
           
        table, th{
            border:1px solid #868585;
        }
        table{
            border-collapse:collapse;
            width:100%;
        }
        th, td{
            text-align:  center;
            padding:15px;
        }
        table tr:nth-child(odd){
            background-color:#eee;
        }
        table tr:nth-child(even){
            background-color:white;
        }
       
   
        </style>

    </head>
    <body>

        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +84 999999999</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> kibyhunter.com </a></li>
                                </ul>
                            </div>
                        </div>


                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="https://www.facebook.com/kibyhunters"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="https://www.facebook.com/kibyhunters"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="https://www.facebook.com/kibyhunters"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="https://www.facebook.com/kibyhunters"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="https://www.facebook.com/kibyhunters"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->










            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a class="tao" href="home"><img src="images/truongcun.jpg" alt="" /></a>
                                <h4 class="slogan1">Truong cun</h4>

                                <h5 class="slogan">Biến ẩm thực Việt Nam trở thành bếp ăn của thế giới</h5>

                            </div>

                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right a2">
                                <ul class="nav navbar-nav a1">


                                    <li><a href="home"><i class="fa fa-user"></i> Home</a></li>
                                    <li><a href="information.jsp"><i class="fa fa-user"></i> Account</a></li>
                                    <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
                                    <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>



                                    <li>
                                        <a href="logout"> <i class="fa fa-lock"> </i> Logout</a>
                                    </li>






                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->



            <!-- header-bottom --> -->
        </header><!--/header-->

        <div class="container bootstrap snippets bootdey">
            <div class="row">
                <div class="profile-nav col-md-3">
                    <div class="panel">
                        <div class="user-heading round">
                            <a href="#">
                                <img src="${requestScope.update5.avatar}" alt="Not Found">

                            </a>
                            <h1>${requestScope.user.realname}</h1>
                            <p>${requestScope.user.email}</p>
                        </div>

                        <ul class="nav nav-pills nav-stacked">
                            <li ><a href="infor?user=${requestScope.update5.username}"> <i class="fa fa-user"></i> Profile</a></li>
                            <li class="active"><a> <i class="fa fa-calendar"></i> Recent Activity <span class="label label-warning pull-right r-activity">9</span></a></li>
                            <li><a href="changep?user=${requestScope.update5.username}"> <i class="fa fa-edit"></i> Edit profile</a></li>
                        </ul>
                    </div>
                </div>




                <div class="profile-info col-md-9">
                    <div class="panel">
                        <form>
                            <textarea placeholder="Whats in your mind today?" rows="2" class="form-control input-lg p-text-area"></textarea>
                        </form>
                        <footer class="panel-footer">
                            <button class="btn btn-warning pull-right">Post</button>
                            <ul class="nav nav-pills">
                                <li>
                                    <a href="#"><i class="fa fa-map-marker"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-camera"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class=" fa fa-film"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-microphone"></i></a>
                                </li>
                            </ul>
                        </footer>
                    </div>


                    <div class="panel">
                        <div class="bio-graph-heading">
                            Kibyhunter Food The Kitchen Of The World :>> 


                        </div>

                        <!--                          private int id;
                            private String username, password, realname, phone, email, address, avatar, role;-->
                        <c:set var="a" value="${list}" />
                        <div class="panel-body bio-graph-info">
                            <h1>Your recent active </h1>
                            <div class="top-sales box">
                                <div style="font-family: cursive;color:orangered;text-align: center
                                     " class="title">Purchased Products</div>

                                <ul class="top-sales-details">




                                    <table border="1" >
                                        <thead>
                                            <tr>
                                                <th>IMG</th>
                                                <th>Food</th>
                                                <th>Price</th>
                                                <th>Number Order</th>
                                                <th>Total</th>
                                                <th>Order Date</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <c:forEach items="${a}" var="p">
                                                    <td><img class="img-responsive" style="width: 40%"  src="${p.username}" alt="Not found" /></td>
                                                    <td>${p.password}</td>
                                                    <td>${p.realname}</td>
                                                    <td>${p.phone}</td>
                                                    <td>${p.email}</td>
                                                    <td>${p.address}</td>
                                                </tr>


                                            </c:forEach>
                                        </tbody>
                                    </table>






                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
