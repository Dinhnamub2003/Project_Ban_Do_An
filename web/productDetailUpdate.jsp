<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <!--<link href="css/detailProduct.css" rel="stylesheet" type="text/css"/>-->
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


        <style>
            @import url('https://fonts.googleapis.com/css?family=Fjalla+One|Montserrat:300,400,700,800|Open+Sans:300');

            body {
                background-color: gray;
                height: 100%;
                margin: 0;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }

            main{
                max-width: 720px;
                margin: 5% auto;
            }

            .card{
                box-shadow: 0 6px 6px rgba(#000, 0.3);
                transition: 200ms;
                background: #fff;

                .card__title{
                    display: flex;
                    align-items: center;
                    padding: 30px 40px;

                    h3{
                        flex: 0 1 200px;
                        text-align: right;
                        margin: 0;
                        color: #252525;
                        font-family: sans-serif;
                        font-weight: 600;
                        font-size: 20px;
                        text-transform: uppercase;
                    }

                    .icon{
                        flex: 1 0 10px;
                        background: #115dd8;
                        color: #fff;
                        padding: 10px 10px;
                        transition: 200ms;

                        > a{
                            color: #fff;
                        }

                        &:hover{
                            background: #252525;
                        }
                    }
                }

                .card__body{
                    padding: 0 40px;
                    display: flex;
                    flex-flow: row no-wrap;
                    margin-bottom: 25px;

                    > .half{
                        box-sizing: border-box;
                        padding: 0 15px;
                        flex: 1 0 50%;
                    }

                    .featured_text{
                        h1{
                            margin: 0;
                            padding: 0;
                            font-weight: 800;
                            font-family: "Montserrat", sans-serif;
                            font-size: 64px;
                            line-height: 50px;
                            color: #181e28;
                        }

                        p{
                            margin: 0;
                            padding: 0;

                            &.sub{
                                font-family: "Montserrat", sans-serif;
                                font-size: 26px;
                                text-transform: uppercase;
                                color: #686e77;
                                font-weight: 300;
                                margin-bottom: 5px;
                            }

                            &.price{
                                font-family: "Fjalla One", sans-serif;
                                color: #252525;
                                font-size: 26px;
                            }
                        }
                    }

                    .image{
                        padding-top: 15px;
                        width: 100%;

                        img{
                            display: block;
                            max-width: 100%;
                            height: auto;
                        }
                    }

                    .description{
                        margin-bottom: 25px;

                        p{
                            margin: 0;
                            font-family: "Open Sans", sans-serif;
                            font-weight: 300;
                            line-height: 27px;
                            font-size: 16px;
                            color: #555;
                        }
                    }

                    span.stock{
                        font-family: "Montserrat", sans-serif;
                        font-weight: 600;
                        color: #a1cc16;
                    }

                    .reviews{
                        .stars{
                            display: inline-block;
                            list-style: none;
                            padding: 0;

                            > li{
                                display: inline-block;

                                .fa{
                                    color: #f7c01b;
                                }
                            }
                        }

                        > span{
                            font-family: "Open Sans", sans-serif;
                            font-size: 14px;
                            margin-left: 5px;
                            color: #555;
                        }
                    }
                }

                .card__footer{
                    padding: 30px 40px;
                    display: flex;
                    flex-flow: row no-wrap;
                    align-items: center;
                    position: relative;

                    &::before{
                        content: "";
                        position: absolute;
                        display: block;
                        top: 0;
                        left: 40px;
                        width: calc(100% - 40px);
                        height: 3px;
                        background: #115dd8;
                        background: linear-gradient(to right, #115dd8 0%,#115dd8 20%,#ddd 20%,#ddd 100%);
                    }

                    .recommend{
                        flex: 1 0 10px;

                        p{
                            margin: 0;
                            font-family: "Montserrat", sans-serif;
                            text-transform: uppercase;
                            font-weight: 600;
                            font-size: 14px;
                            color: #555;
                        }

                        h3{
                            margin: 0;
                            font-size: 20px;
                            font-family: "Montserrat", sans-serif;
                            font-weight: 600;
                            text-transform: uppercase;
                            color: #115dd8;
                        }
                    }

                    .stars{
                        display: flex;
                    }

                    .action{
                        button{
                            cursor: pointer;
                            border: 1px solid #115dd8;
                            padding: 14px 30px;
                            border-radius: 200px;
                            color: #fff;
                            background: #115dd8;
                            font-family: "Open Sans", sans-serif;
                            font-size: 16px;
                            transition: 200ms;

                            &:hover{
                                background: #fff;
                                color: #115dd8;
                            }
                        }
                    }
                }
            }
            * {
                box-sizing: border-box;
            }

            body {
                font-family: Arial;
                margin: 0 auto; /* Center website */
                padding: 20px;
            }

            .heading {
                font-size: 25px;
                margin-right: 25px;
            }

            .fa {
                font-size: 25px;
            }

            .checked {
                color: orange;
            }

            /* Three column layout */
            .side {
                float: left;
                width: 15%;
                margin-top:10px;
            }

            .middle {
                margin-top:10px;
                float: left;
                width: 70%;
            }

            /* Place text to the right */
            .right {
                text-align: right;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* The bar container */
            .bar-container {
                width: 100%;
                background-color: #f1f1f1;
                text-align: center;
                color: white;
            }

            /* Individual bars */
            .bar-5 {
                width: 60%;
                height: 18px;
                background-color: #04AA6D;
            }
            .bar-4 {
                width: 30%;
                height: 18px;
                background-color: #2196F3;
            }
            .bar-3 {
                width: 10%;
                height: 18px;
                background-color: #00bcd4;
            }
            .bar-2 {
                width: 4%;
                height: 18px;
                background-color: #ff9800;
            }
            .bar-1 {
                width: 15%;
                height: 18px;
                background-color: #f44336;
            }

            /* Responsive layout - make the columns stack on top of each other instead of next to each other */
            @media (max-width: 400px) {
                .side, .middle {
                    width: 100%;
                }
                .right {
                    display: none;
                }
            }



            .card {

                border: none;
                box-shadow: 5px 6px 6px 2px #e9ecef;
                border-radius: 4px;
            }


            .dots{

                height: 4px;
                width: 4px;
                margin-bottom: 2px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block;
            }

            .badge{

                padding: 7px;
                padding-right: 9px;
                padding-left: 16px;
                box-shadow: 5px 6px 6px 2px #e9ecef;
            }

            .user-img{

                margin-top: 4px;
            }

            .check-icon{

                font-size: 17px;
                color: #c3bfbf;
                top: 1px;
                position: relative;
                margin-left: 3px;
            }

            .form-check-input{
                margin-top: 6px;
                margin-left: -24px !important;
                cursor: pointer;
            }


            .form-check-input:focus{
                box-shadow: none;
            }


            .icons i{

                margin-left: 8px;
            }
            .reply{

                margin-left: 12px;
            }

            .reply small{

                color: #b7b4b4;

            }


            .reply small:hover{

                color: green;
                cursor: pointer;

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
                                    <c:if test="${sessionScope.account.role == 'admin'}">

                                        <li><a href="#"><i class="fa fa-user"></i> Manager</a></li>


                                    </c:if>


                                    <li><a href="home"><i class="fa fa-user"></i> Home</a></li>


                                    <c:if test="${sessionScope.account!=null}">

                                        <li><a href="infor?user=${sessionScope.account.username}"  > <i class="fa fa-user"></i> Account</a></li>

                                    </c:if>

                                    <c:if test="${sessionScope.account!=null}">

                                        <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>

                                    </c:if>

                                    <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>

                                    <c:if test="${sessionScope.account!=null}">

                                        <li>
                                            <a href="logout"> <i class="fa fa-lock"> </i> Logout</a>
                                        </li>

                                    </c:if>

                                    <c:if test="${sessionScope.account==null}">
                                        <li><a href="login.jsp"> <i class="fa fa-lock"></i> Login</a></li>

                                    </c:if>


                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->



            <!-- header-bottom --> -->
        </header><!--/header-->





        <c:set var="p" value="${requestScope.detail}"  />



        <main>
            <div class="card">
                <div class="card__title">
                    <div class="icon">
                        <a href="home"><i class="fa fa-arrow-left"> <h3>Continuing Shopping</h3></i></a>
                    </div>

                </div>
                <div class="card__body">
                    <div class="half">
                        <div class="featured_text">
                            <h1 style="color: goldenrod">${p.name}</h1>
                            <p class="sub">Food delicious</p>
                            <p class="price">${p.price}</p>
                        </div>
                        <div class="image">
                            <img class="img-responsive" src="${p.images}" alt="">
                        </div>
                    </div>
                    <div style="margin-left: 10px" class="half">
                        <div class="description">
                            <p style="font-family: cursive;font-weight: bold">${p.describe}</p>
                        </div>
                        <div class="description">
                            <p style="color:goldenrod">Quantity : ${p.quantity}</p>
                        </div>

                        <div class="reviews">


                            <div style="display: flex">
                                <span class="heading">User Rating</span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star"></span>
                            </div>
                            <p>4.1 average based on 254 reviews.</p>
                            <hr style="border:3px solid #f1f1f1">

                            <div class="row">
                                <div class="side">
                                    <div>5 star</div>
                                </div>
                                <div class="middle">
                                    <div class="bar-container">
                                        <div class="bar-5"></div>
                                    </div>
                                </div>
                                <div class="side right">
                                    <div>150</div>
                                </div>
                                <div class="side">
                                    <div>4 star</div>
                                </div>
                                <div class="middle">
                                    <div class="bar-container">
                                        <div class="bar-4"></div>
                                    </div>
                                </div>
                                <div class="side right">
                                    <div>63</div>
                                </div>
                                <div class="side">
                                    <div>3 star</div>
                                </div>
                                <div class="middle">
                                    <div class="bar-container">
                                        <div class="bar-3"></div>
                                    </div>
                                </div>
                                <div class="side right">
                                    <div>15</div>
                                </div>
                                <div class="side">
                                    <div>2 star</div>
                                </div>
                                <div class="middle">
                                    <div class="bar-container">
                                        <div class="bar-2"></div>
                                    </div>
                                </div>
                                <div class="side right">
                                    <div>6</div>
                                </div>
                                <div class="side">
                                    <div>1 star</div>
                                </div>
                                <div class="middle">
                                    <div class="bar-container">
                                        <div class="bar-1"></div>
                                    </div>
                                </div>
                                <div class="side right">
                                    <div>20</div>
                                </div>
                            </div>


                            <!--<span> viewed)</span>-->
                        </div>
                    </div>
                </div>
                <div class="card__footer">
                    <div class="recommend">
                        <p>Kibyhunter Food</p>
                        <h3>The Kitten Of The World</h3>
                    </div>
                    <div class="action">
                        <button type="button">Add to cart</button>
                    </div>




                </div>
            </div>




            <div style="width: 100%; margin-top: 15px" class="mt-5">
                <c:set var="vv" value="${requestScope.review}" />




                <div class="row  d-flex justify-content-center">

                    <div class="col-md-12">

                        <div class="headings d-flex justify-content-between align-items-center mb-3">




                            <div class="card p-3">
                                <h4 style="text-align: center;color: orangered" >Reviewed food</h4>




                                <form action="detail?id=${requestScope.detail.id}&user=${requestScope.user1}" method="post">

                                    <input style="width: 80%" type="text" name="content" placeholder="Add your review" />
                                    <input style="color: white;background: goldenrod" type="submit" value="Comment" />

                                </form>






                                <c:forEach var="c"  items="${vv}">
                                    <div>
                                        <div style="margin-top: 15px" class="d-flex justify-content-between align-items-center">

                                            <div class="user d-flex flex-row align-items-center">

                                                <img src="${c.idaccount.avatar}" width="30" class="user-img rounded-circle mr-2">
                                                <!--https://th.bing.com/th/id/OIP.VomrQusdCnSh9U730xlnbgHaH9?pid=ImgDet&rs=1-->
                                                <span><small class="font-weight-bold text-primary">${c.idaccount.realname}</small>
                                                    <form action="reviewup?reviewid=${reviewid}&user=${user}&id=${requestScope.detail.id}"  method="post">
                                                        <small class="font-weight-bold"> <input type="text" name="content" value="${list.content}" /></small></span>
                                                        <input type="submit" value="save" />
                                                </form>
                                            </div>
                                            <small>${c.review_date}</small>
                                        </div>
                                        <div class="action d-flex justify-content-between mt-2 align-items-center">
                                            <div class="reply px-4">
                                                <small><a href="reviewd?reviewid=${c.reviewid}&id=${requestScope.detail.id}&user=${requestScope.user1}">Remove</a></small>
                                                <span class="dots"></span>
                                                <small>Reply</small>
                                                <span class="dots"></span>
                                                <small>Translate</small>

                                            </div>
                                            <div class="icons align-items-center">

                                                <i class="fa fa-star text-warning"></i>
                                                <i class="fa fa-check-circle-o check-icon"></i>

                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>           

                            </div>

                        </div>

                    </div>

                </div> 
                <!--ketthuc-->

            </div>


        </main>



    </body>

</html>
