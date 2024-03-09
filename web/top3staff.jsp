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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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






         table {



            }
            table th {
                background-color: #ff9800;
                color: #fff;
                font-weight: bold;
                padding: 10px;
                text-transform: uppercase;
                letter-spacing: 1px;
                border-top: 1px solid #fff;
                border-bottom: 1px solid #ccc;
            }

            table tr:nth-child(even) td {
  background-color: #f2f2f2;
            }

            table tr:hover td {
                background-color: #ffedcc;
            }

            table td {
                background-color: #fff;
                padding: 10px;
                border-bottom: 1px solid #ccc;
                font-weight: bold;
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
                    <a href="manager" >
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
                    <a class="active" href="top3satff">
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
                             "  class="title">Excellent top staff</div>
                        <div style="color: red"> ${mess}</div>

                        <div style="display: flex">

                            <form  action="topstaff" method="get"> 
                                <button style="background: goldenrod;color: white ;padding: 4px ;border-radius: 10px
                                        " type="submit" class="mb-0 text-center btn btn-primary">Export Excel File</button> 
                            </form>
                            
                            <a  style="background: goldenrod;color: white ;padding: 4px ;border-radius: 10px
                                ;margin-left: 20px" href="staffAdd.jsp" > Add new staff </a>

                        </div>






                        <c:set var="o" value="${top}" />
                        <div style="margin-top: 15px;" class="sales-details">

                            <table style="  width: 100%;
                                   /*padding: 30px;*/
                                   text-align: center;
                                   " border="1">
                                <thead>
                                    <tr>

                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                        <th>BirthDate</th>
                                        <th>Country</th>
                                        <th>NumberOrder</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tbody>

                                    <!--                                    this.id = id;
                                                                        this.username = username;
                                                                        this.password = password;
                                                                        this.realname = realname;
                                                                        this.phone = phone;
                                                                        this.email = email;-->

                                    <c:forEach var="i" items="${o}">
                                        <tr>

                                            <td>${i.username}</td>
                                            <td>${i.address}</td>
                                            <td>${i.password}</td>
                                            <td>${i.realname}</td>
                                            <td>${i.phone}</td>
                                            <td>${i.email}</td>
                                            <td >
                                                <c:if  test="${search==null}">
                                                    <a href="staffu?id=${i.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>

                                                </c:if>
                                                <c:if  test="${search!=null}">

                                                    <a href="staffu?id=${i.id}&key1=${search}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>


                                                </c:if>
                                                <c:if  test="${search==null}">
                                                    <a href="staffd?id=${i.id}" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>


                                                </c:if>
                                                <c:if  test="${search!=null}">

                                                    <a href="staffd?id=${i.id}&key1=${search}" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>

                                                </c:if>


                                            </td>
                                        </tr>
                                    </c:forEach>


                                </tbody>
                            </table>



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


