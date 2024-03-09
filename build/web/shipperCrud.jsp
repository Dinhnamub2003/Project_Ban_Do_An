<%-- 
    Document   : crudProduct
    Created on : Oct 22, 2023, 8:47:17 AM
    Author     : Truong cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/managerProduct.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <link rel="stylesheet" href="style.css">
        <!-- Boxicons CDN Link -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <title>JSP Page</title>

        <style>
            .edit {
                color: #FFC107;
            }

            .delete {
                color: #F44336;
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
            .sales-details{
                display: flex;

            }
            .sales-details ul{
                margin-left: 10px;
                margin-right: 40px;
                text-align: center;
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
                    <a href="managerProduct.jsp" >
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a  class="active">
                        <i class='bx bx-box' ></i>
                        <span class="links_name">Product</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Order list</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-pie-chart-alt-2' ></i>
                        <span class="links_name">Analytics</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-coin-stack' ></i>
                        <span class="links_name">Stock</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-book-alt' ></i>
                        <span class="links_name">Total order</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-user' ></i>
                        <span class="links_name">Team</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-message' ></i>
                        <span class="links_name">Messages</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-heart' ></i>
                        <span class="links_name">Favrorites</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-cog' ></i>
                        <span class="links_name">Setting</span>
                    </a>
                </li>
                <li class="log_out">
                    <a href="#">
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
                    <span class="dashboard">Admin Manager</span>
                </div>


                <form method="get" action="#" >
                    <div class="search-box">
                        <input type="text" name="key1" placeholder="Search...">
                        <i class='bx bx-search' ></i>
                    </div>
                </form>


                <div class="profile-details">
                    <img src="images/profile.jpg" alt="">
                    <span class="admin_name">Prem Shahi</span>
                    <i class='bx bx-chevron-down' ></i>
                </div>
            </nav>



            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Order</div>
                            <div class="number">40,876</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text">Up from yesterday</span>
                            </div>
                        </div>
                        <i class='bx bx-cart-alt cart'></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Sales</div>
                            <div class="number">38,876</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text">Up from yesterday</span>
                            </div>
                        </div>
                        <i class='bx bxs-cart-add cart two' ></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Profit</div>
                            <div class="number">$12,876</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <span class="text">Up from yesterday</span>
                            </div>
                        </div>
                        <i class='bx bx-cart cart three' ></i>
                    </div>


                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Return</div>
                            <div class="number">11,086</div>
                            <div class="indicator">
                                <i class='bx bx-down-arrow-alt down'></i>
                                <span class="text">Down From Today</span>
                            </div>
                        </div>
                        <i class='bx bxs-cart-download cart four' ></i>
                    </div>
                </div>
            </div>










            <div class="sales-boxes">
                <div style="width: 100%" class="recent-sales box">
                    <div style="display: flex;">
                        <div style="margin-left: 30px" class="title">Manager Shipper</div>
                        <div style="margin-left:50px" class="title"><a href="shippera" > Add New shipper </a></div>

                    </div>




                    <c:set var="list2" value="${requestScope.list}"/>

                    <c:if test="${list2!=null}">








                        <table  style="border : solid 1px green; width: 100%; ">
                            <thead  style="margin-left: 20px">
                                <tr  style="margin-left: 20px" >
                                    <th>ID</th>
                                    <th>NAME</th>
                                    <th>PHONE</th>
                                    <th>EMAIL</th>
                                    <th>EDIT</th>
                                </tr>
                            </thead>

                            <tbody  style="margin-left: 20px">
                                <c:forEach items="${list2}" var="p">
                                    <tr >
                                        <td>${p.id}</td>
                                        <td>${p.name}</td>
                                        <td>${p.phone}</td>
                                        <td>${p.email}</td>
                                        <td>
                                            <a href="shipperu?id=${p.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>

                                            <a href="shipperd?id=${p.id}" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>



                       

                    </c:if>




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
