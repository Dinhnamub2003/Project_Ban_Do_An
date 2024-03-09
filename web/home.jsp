
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home| KibyhunterShop </title>
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
            .a1 li a{
                padding: 5px;
                background: gold;
                border-radius: 15%;

            }
            .as a{
                /*                color: yellow;*/
                padding: 8px 8px;
                background-color: gray;
            }

            .as a.active{
                background-color: black;
                color: white;
            }

            .as a.hover{
                background-color: black;
                color: white;

            }



        </style>  
    </head><!--/head-->

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

                                        <li><a href="manager"><i class="fa fa-user"></i> Manager</a></li>


                                    </c:if>


                                    <li><a href="home"><i class="fa fa-user"></i> Home</a></li>


                                    <c:if test="${sessionScope.account!=null}">

                                        <li><a href="infor?user=${sessionScope.account.username}"  > <i class="fa fa-user"></i> Account</a></li>

                                    </c:if>

                                    <c:if test="${sessionScope.account!=null}">

                                        <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>

                                    </c:if>

                                    <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                    <li><a href="cart?user=${sessionScope.account.username}"><i class="fa fa-shopping-cart"></i> Cart</a></li>

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





        <div class="col-sm-9 ">
            <form method="get" action="home1?key=${key}&cidd=${ok}&price=${price}">
                <div  class="ok123">
                    <div class="search_box pull-right timkiem">
                        <input type="text" name ="key" placeholder="Search"/>

                        <input style="background: gray" type="submit"   placeholder="Search"/>
                    </div>
                    <div>




                    </div>
                </div>
            </form>
        </div>





        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">

                            </ol>

                            <div class="carousel-inner">
                                <div class="item active">

                                    <div class="col-sm-6">
                                        <img src="images/ok1.jpg" class="girl img-responsive" alt="" />
                                        <!-- <img src="images/home/pricing.png"  class="pricing" alt="" /> -->
                                    </div>

                                    <div class="col-sm-6">
                                        <img src="images/okdone.jpg" class="girl img-responsive" alt="" />
                                        <!-- <img src="images/home/pricing.png"  class="pricing" alt="" /> -->
                                    </div>
                                </div>



                            </div>


                        </div>

                    </div>
                </div>
            </div>
        </section><!--/slider-->




        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">

                            <h2>List Food</h2>

                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->

                                <c:set var="chid" value="${requestScope.chid}" />
                                <c:set value="${requestScope.cid}" var="cid" />
                                <c:set value="${requestScope.data}" var="cat" />
                                <form id="f1" action="home1">



                                    <div class="panel panel-default">
                                        <div style="color:black" class="panel-heading">

                                            <input type="checkbox" id="c0" name ="cidd" 
                                                   ${chid[0]?"checked":""}  value="${0}" 
                                                   onclick="setCheck(this)" /> ALL <br>

                                        </div>
                                    </div>

                                                  
                                    <c:forEach  begin="0" end="${cat.size()-1}" var="i">


                                        <div class="panel panel-default">
                                            <div style="color:black" class="panel-heading">

                                                <input type="checkbox" id="cm" name="cidd" ${cat.get(i).getId()==cid?"checked":""}
                                                       value="${cat.get(i).getId()}" 
                                                       ${chid[i+1]?"checked":""} onclick="setCheck(this)"/>
                                                ${cat.get(i).getName()}

                                            </div>
                                        </div>

                                    </c:forEach>

                                </form>

                            </div><!--/category-products-->






                            <h2>PRICE</h2>
                            <c:set var="pp" value="${requestScope.pp}"/>
                            <c:set var="pb" value="${requestScope.pb}"/>

                            <form id="f2" action="home1">

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <input  type="checkbox" id="g0" name="price" ${pb[0]?"checked":""} value="0" onclick="setCheck1(this)"/>
                                        ALL <br/>

                                    </div>
                                </div>




                                <c:forEach begin="0" end="${3}" var="i">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <input  type="checkbox" id="g1" name="price" ${pb[i+1]?"checked":""} value="${i+1}" onclick="setCheck1(this)"/>
                                            ${pp[i]}
                                            <br/>

                                        </div>
                                    </div>        

                                </c:forEach>
                            </form>





                            <div class="shipping text-center">
                                <img class="img-responsive" src="images/chay/chay6.jpg" alt="" />
                            </div>/shipping
                            <div class="shipping text-center"><!--shipping-->
                                <img class="img-responsive" src="images/hoaqua/nuocep11.jpg" alt="" />
                            </div><!--/shipping-->
                            <div class="shipping text-center"><!--shipping-->
                                <img class="img-responsive" src="images/gas/gas10.jpg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>


                    <!--category-tab-->
                    <div class="category-tab">
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs">
                                <c:if test="${sale==null }">
                                    <li "><a href="home1" data-toggle="tab">News</a></li>
                                    <li><a href="home"  data-toggle="tab">Sale</a></li>
                                    <li><a href="#sunglass" data-toggle="tab">Hots</a></li>
                                    <li><a href="#kids" data-toggle="tab">Oke</a></li>
                                    </c:if>
                                    <c:if test="${sale!=null}">
                                    <li ><a href="home1" data-toggle="tab">News</a></li>
                                    <li  "> <a  href="home"  data-toggle="tab">Sale</a></li>
                                    <li><a href="#sunglass" data-toggle="tab">Hots</a></li>
                                    <li><a href="#kids" data-toggle="tab">Oke</a></li>
                                    </c:if>



                            </ul>
                        </div>

                        <c:set var="hi" value="${news}"/>
                        <c:if test="${sale!=null }">

                            <c:forEach var="pn" items="${hi}" >

                                <div class="tab-content">
                                    <div class="tab-pane fade active in" id="news" >
                                        <div class="col-sm-3">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <img  style="height: 240px" src="${pn.images}" alt="not found" />

                                                            <h2>${pn.price}</h2>
                                                            <p>${pn.name}</p>
                                                            <a href="addcart?id=${pn.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                        </div>
                                                        <img src="images/new.png" class="new" alt="" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </c:forEach>
                        </c:if>



                        <c:set var="sale"  value="${requestScope.sale}"/>
                        <c:if test="${news==null }">
                            <c:forEach var="pn" items="${sale}" >


                                <div class="tab-content">
                                    <div class="tab-pane fade active in" id="news" >
                                        <div class="col-sm-3">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <img  style="height: 240px" src="${pn.images}" alt="not found" />

                                                            <h4 style="color : gray"><del>${pn.price}</del></h4>
                                                            <h2 >${pn.price*0.9}</h2>
                                                            <p>${pn.name}</p>
                                                            <a href="addcart?id=${pn.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                        </div>
                                                        <img src="images/sale.png" class="new" alt="" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <!--/category-tab-->









                    <div class="as">
                        <c:set var="page" value="${requestScope.page}"/>
                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <c:if test="${key==null}">
                                <a class="${i==page?"active":""}" style="color:gold" href="home1?page=${i}&${ok}&${price}">${i}</a>
<!--class=""active":""}"-->
                            </c:if>

                            <c:if test="${key!=null}">
                                <a class="${i==page?"active":""}"  style="color:gold" href="home1?page=${i}&${ok}&key=${key}&${price}">${i}</a>

                            </c:if>
                        </c:forEach>
                    </div>



                    <c:set var="list" value="${requestScope.listPhanTrang}"/>

                    <c:if test="${list!=null}">
                        <h2 style="color: gold">Hiện đang có (${list.size()}) sản phẩm</h2>
                        <c:forEach items="${list}" var="p">



                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img style="height: 240px" class="img-responsive"  src="${p.images}" alt="" />
                                            <h2>${p.price}</h2>
                                            <p class="panel-title" style="color:gold"> ${p.name} </p>
                                            <a href="addcart?id=${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>

                                        <div class="product-overlay">
                                            <div class="overlay-content">
                                                <h2>${p.price}</h2>
                                                <p class="panel-title" > ${p.name} </p>

                                                <a href="addcart?id=${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                <a href="detail?id=${p.id}&user=${sessionScope.account.username}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Detail </a>

                                            </div>
                                        </div>

                                    </div>
                                    <div class="choose">
                                        <ul class="nav nav-pills nav-justified">
                                            <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                            <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>



                        </c:forEach>


                    </c:if>





                </div>
            </div>

        </section>








        <footer  id="footer" style="margin-top: 50px"><!--Footer-->

            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="companyinfo">
                                <h2><span>KibyhunterShop</span></h2>
                                <p>Hàng tỷ người tin dùng ^^</p>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img  class="img-responsive" src="images/hi.jpg" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Gợi ý </p>
                                    <h2>đánh giá 4.5*</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img class="img-responsive"  src="images/hi1.jpg" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Gợi ý </p>
                                    <h2>đánh giá 4.5*</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img  class="img-responsive"  src="images/hi2.jpg" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Gợi ý </p>
                                    <h2>đánh giá 4.5*</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img class="img-responsive"  src="images/hi3.jpg" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Gợi ý </p>
                                    <h2>đánh giá 4.5*</h2>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="address">
                                <img src="images/linh tinh.jpg" alt="" />
                                <p>Ẩm thực Việt vươn tầm thế giới ^^</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <p class="pull-left">Copyright © Kibyhunter All rights reserved.</p>

                    </div>
                </div>
            </div>


        </footer><!--/Footer-->



        <!--    <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.scrollUp.min.js"></script>
            <script src="js/price-range.js"></script>
            <script src="js/jquery.prettyPhoto.js"></script>
            <script src="js/main.js"></script>-->



    </body>
</html>