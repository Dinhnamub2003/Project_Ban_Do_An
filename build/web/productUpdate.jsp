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
        <link href="css/updateproduct.css" rel="stylesheet" type="text/css"/>

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

            * {
                box-sizing: border-box;
            }

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
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
                    <a href="#" class="active">
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#">
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
                    <div class="title">Update Product</div>



                    <c:set var="p" value="${requestScope.updatepro}"/>


                    <!--                    private int id;
                                        private String name;
                                        private String describe;
                                        private double price;
                                        private String images;
                                        private String dateupdate;
                                        private typeproduct idtypeproduct;
                                        private int quantity;
                                        private int viewed;-->

                    <div class="container">
                        <form action="updatep?id=${p.id}"  method="post">
                            <div class="row">
                                <div class="col-25">
                                    <label for="fname">Name</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" id="fname" name="name" value="${p.name}">
                                </div>
                            </div>



                            <div class="row">
                                <div class="col-25">
                                    <label for="lname">Price</label>
                                </div>
                                <div class="col-75">
                                    <input type="text"  name="price" value="${p.price}">
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-25">
                                    <label for="lname">Images</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="images" value="${p.images}">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="lname">Quantity</label>
                                </div>
                                <div class="col-75">
                                    <input type="text"  name="quantity" value="${p.quantity}">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="lname">Date Update</label>
                                </div>
                                <div class="col-75">
                                    <input type="date"  name="dateupdate" value="${p.dateupdate}">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="lname">Viewed</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="viewed" value="${p.viewed}">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="country">ID Category</label>
                                </div>
                                <div class="col-75">
                                    <select id="country" name="typeproduct">
                                        <c:forEach var="i" items="${allcat}">
                                            <option  value="${i.id}">${i.name} </option>

                                        </c:forEach>

                                    </select>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-25">
                                    <label for="subject">Describe</label>
                                </div>
                                <div class="col-75">
                                    <textarea id="subject" name="describe"  style="height:150px">${p.describe}</textarea>
                                </div>
                            </div>
                            <div style="margin-right: 100px" class="row">
                                <input type="submit"  value="Submit">
                            </div>
                        </form>
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
