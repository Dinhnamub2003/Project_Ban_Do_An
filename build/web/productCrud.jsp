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
                    <a href="manager" >
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a class="active" href="crudp">
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
                    <span class="dashboard">Admin Manager</span>
                </div>


                <form method="get" action="crudp?" >
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


                        <c:set var="i" value="${list5}" />

            

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
            </div>










            <div class="sales-boxes">
                <div style="width: 100%" class="recent-sales box">
                    <div style="display: flex;">
                        <div style="margin-left: 30px" class="title">Manager Product</div>
                        <div style="margin-left:50px" class="title"><a href="producta" > Add New Product </a></div>

                    </div>

                    <h4 style="color :gray">Total Product : ${requestScope.so}</h4>


                    <div style="margin: 20px" class="as">
                        <c:set var="page" value="${requestScope.page}"/>
                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <c:if test="${search!=null}" >
                                <a class="${i==page?"active":""}" style="color:gold" href="crudp?page=${i}&key1=${search}">${i}</a>

                            </c:if>
                            <c:if test="${search==null}" >
                                <a class="${i==page?"active":""}" style="color:gold" href="crudp?page=${i}">${i}</a>

                            </c:if>

                        </c:forEach>
                    </div>





                    <c:set var="list2" value="${requestScope.list}"/>

                    <c:if test="${list2!=null}">

                        <c:forEach items="${list2}" var="p">

                            <!--                        private int id;
                                                    private String name;
                                                    private String describe;
                                                    private double price;
                                                    private String images;
                                                    private String dateupdate;
                                                    private typeproduct idtypeproduct;
                                                    private int quantity;
                                                    private int viewed;-->
                            <div style="border : solid 3px green" class="sales-details">

                                <ul class="details">
                                    <li class="topic">ID</li>
                                    <li><a>${p.id} </a> </li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Name</li>
                                    <li><a> ${p.name} </a></li>

                                </ul>

                                <ul class="details" style="width: 50%" >
                                    <li class="topic">Describe</li>
                                    <li><a>${p.describe}</a></li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Price</li>
                                    <li><a>${p.price}</a></li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Image</li>
                                    <li> <img class="img-responsive" style="width: 70%"  src="${p.images}" alt="Not found" /></li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Quantity</li>
                                    <li>${p.quantity}</li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Category</li>
                                    <li>${p.idtypeproduct.name}</li>

                                </ul>

                                <ul class="details">
                                    <li class="topic">Date update</li>
                                    <li>${p.dateupdate}</li>

                                </ul>

                                <ul style="margin-top: 20px" class="details">
                                    <td >
                                        <c:if  test="${search==null}">
                                            <a href="updatep?id=${p.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>

                                        </c:if>
                                        <c:if  test="${search!=null}">
                                           
                                                <a href="updatep?id=${p.id}&key1=${search}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>


                                        </c:if>


                                                <a href="detelep?id=${p.id}&key1=${search}" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>

                                    </td>
                                </ul>


                            </div>  



                        </c:forEach>


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
