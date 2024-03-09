<%-- 
    Document   : managerProduct
    Created on : Oct 21, 2023, 6:34:12 PM
    Author     : Truong cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- Coding by CodingNepal | www.codingnepalweb.com -->
<html lang="en" dir="ltr">
    <link href="css/managerProduct.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta charset="UTF-8">
        <title> Responsiive Admin Dashboard | CodingLab </title>

        <link rel="stylesheet" href="style.css">
        <!-- Boxicons CDN Link -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


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


    </head>


    <body>
        <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxl-c-plus-plus'></i>
                <span class="logo_name">CodingLab</span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="manager" class="active">
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="crudp">
                        <i class='bx bx-box' ></i>
                        <span class="links_name">Product</span>
                    </a>
                </li>
                <!--                <li>
                                    <a href="#">
                                        <i class='bx bx-list-ul' ></i>
                                        <span class="links_name">Order list</span>
                                    </a>
                                </li>-->
                <li>
                    <a href="top3satff">
                        <i class='bx bx-pie-chart-alt-2' ></i>
                        <span class="links_name">Excellent Staff</span>
                    </a>
                </li>

                <li>
                    <a href="top3customer">
                        <i class='bx bx-user' ></i>
                        <span class="links_name">Best Customer</span>
                    </a>
                </li>

                <li>
                    <a href="cruds">
                        <i class='bx bx-book-alt' ></i>
                        <span class="links_name">Best Shipper</span>
                    </a>
                </li>



                <li>
                    <a href="#">
                        <i class='bx bx-cog' ></i>
                        <span class="links_name">Setting</span>
                    </a>
                </li>
                <li class="log_out">
                    <a href="logout">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">Log out</span>
                    </a>
                </li>
            </ul>
        </div>




        <section class="home-section">
            <nav>
                <div class="sidebar-button">
                    <i class='bx bx-menu sidebarBtn'></i>
                    <span class="dashboard">Dashboard</span>
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <i class='bx bx-search' ></i>
                </div>
                <div class="profile-details">
                    <img src="images/profile.jpg" alt="">
                    <span class="admin_name">Prem Shahi</span>
                    <i class='bx bx-chevron-down' ></i>
                </div>
            </nav>


            <c:set var="i" value="${list}" />


            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="right-side">
                            <div  class="box-topic">Total Order</div>
                            <div class="number">${i[0]}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text"><a  href="thongkeorder.jsp">Statistic Order</a></span>
                            </div>
                        </div>
                        <i class='bx bx-cart-alt cart'></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Sales</div>
                            <div class="number">${i[1]}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text"><a  href="doanhthutheothang">Statistic Sale</a></span>
                            </div>
                        </div>
                        <i class='bx bxs-cart-add cart two' ></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Profit</div>
                            <div class="number">${i[2]}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text"><a  href="thongkeloinhuanThang">Statistic Profit</a></span>
                            </div>
                        </div>
                        <i class='bx bx-cart cart three' ></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Products Hots Sold</div>
                            <div class="number">${i[3]}</div>
                            <div class="indicator">
                                <i class='bx bx-down-arrow-alt down'></i>
                                <span style="color:gray" class="text"> <a href="topview">Statistic View</a></span>
                            </div>
                        </div>
                        <i class='bx bxs-cart-download cart four' ></i>
                    </div>
                </div>







                <c:set var="o1" value="${list3}"/>

                <div class="sales-boxes">


                    <div class="recent-sales box">

                        <div style="font-family: cursive;color:orangered;text-align: center
                             "  class="title">Recent Sales</div>
                        <div style="color: red"> ${mess}</div>
                        <form  action="exel" method="get"> 
                            <!--<input oninput="searchByDate(this)" type="date" id="dateHoaDon" name="dateHoaDon" class="form-control mb-0" style="width:30%">-->
                            <button style="background: goldenrod;color: white ;padding: 4px ;border-radius: 10px
                                    " type="submit" class="mb-0 text-center btn btn-primary">Export Excel File</button> 
                        </form> 
                        <div class="sales-details">

                            <!--
                                    this.username = username;
                                    this.password = password;
                                    this.realname = realname;
                                    this.phone = phone;-->

                            <ul class="details">
                                <li class="topic">Date</li>
                                    <c:forEach var="o" items="${o1}">
                                    <li><a href="detailo?id=${o.id}" >${o.username}</a></li>
                                    </c:forEach>


                            </ul>
                            <ul class="details">
                                <li class="topic">Customer</li>
                                    <c:forEach var="o" items="${o1}">
                                    <li><a href="detailo?id=${o.id}">${o.password} </a> </li>
                                    </c:forEach>

                            </ul>
                            <ul class="details">
                                <li class="topic">Address</li>
                                    <c:forEach var="o" items="${o1}">
                                    <li><a href="detailo?id=${o.id}">${o.realname}</a></li>
                                    </c:forEach>

                            </ul>
                            <ul class="details">
                                <li class="topic">Total</li>
                                    <c:forEach var="o" items="${o1}">
                                    <li><a href="detailo?id=${o.id}">${o.phone} </a></li>
                                    </c:forEach>

                            </ul>

                        </div>
                        <div style="margin: 20px" class="as">
                            <c:set var="page" value="${requestScope.page}"/>
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                <a class="${i==page?"active":""}" style="color:gold" href="manager?page=${i}">${i}</a>
                            </c:forEach>
                        </div>



                      



                    </div>

                    <c:set var="o1" value="${list1}"/>

                    <div class="top-sales box">
                        <div style="font-family: cursive;color:orangered;text-align: center
                             " class="title">Top Seling Product</div>

                        <ul class="top-sales-details">
                            <c:forEach var="o" items="${o1}">
                                <li>
                                    <a href="#">
                                        <img src="${o.email}" alt="">
                                        <span class="product">${o.name}</span>
                                    </a>
                                    <span class="price">${o.phone}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>


                </div>
            </div>
        </section>

        <script>
            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".sidebarBtn");
            sidebarBtn.onclick = function () {
                sidebar.classList.toggle("active");
                if (sidebar.classList.contains("active")) {
                    sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                } else
                    sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
            }
        </script>

    </body>
</html>


