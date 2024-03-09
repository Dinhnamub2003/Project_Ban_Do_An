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
                    <a href="#" class="active">
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
                                <span class="text"><a  href="#">Statistic Sale</a></span>
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







                <!--Main Navigation-->
                <header>



                </header>
                <!--Main Navigation-->

                <!--Main layout-->
                <main>
                    <div class="container pt-4">



                        <!-- Section: Main chart 2 -->
                        <section  class="mb-4" id="doanhThuThang">
                            <div class="card">
                                <div class="card-header py-3">
                                    <h5 class="mb-0 text-center"><strong>Sale By Month</strong></h5>
                                    <h5 class="mb-0 text-center"><strong>  <a href="doanhthutheonam">Sale By Year </a>
                                        </strong></h5>
                                    <h5 class="mb-0 text-center"><strong><a href="doanhthutheonam">Sale By Week </a></strong></h5>
                                    
                                </div>
                                <form id="myForm" action="doanhthutheothang" method="post">
                                    <div class="card-header py-3">
                                        <select onchange="this.form.submit()" name="chart" style="background-color: orange ; padding: 5px ;border-radius: 5px ;color: white ">
                                            <option ${chart=="line"?"selected":""} value="line" >Line</option>
                                            <option ${chart=="bar"?"selected":""} value="bar">Bar</option>
                                            <option ${chart=="pie"?"selected":""} value="pie">Pie</option>
                                            <option ${chart=="doughnut"?"selected":""} value="doughnut">Doughnut</option>
                                            <option ${chart=="radar"?"selected":""} value="radar">radar</option>
                                            <option ${chart=="polarArea"?"selected":""} value="polarArea">PolarArea</option>
                                            <option ${chart=="horizontalBar"?"selected":""} value="horizontalBar">HorizontalBar</option>

                                        </select>
                                    </div>
                                </form>
                                <div class="card-body">
                                    <canvas id="horizontalBar"></canvas>
                                </div>
                            </div>
                        </section>
                        <!-- Section: Main chart 2 -->






                    </div>
                </main>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <!--Main layout-->
                <!-- SCRIPTS -->
                <!-- JQuery -->
                <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
                <!-- Bootstrap tooltips -->
                <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
                <!-- Bootstrap core JavaScript -->
                <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
                <!-- MDB core JavaScript -->
                <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
                <!-- MDB Ecommerce JavaScript -->
                <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
                <!-- MDB -->
                <script type="text/javascript" src="js/mdb.min.js"></script>
                <!-- Custom scripts -->
                <script type="text/javascript" src="js/script.js"></script>
                <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>

                <script>// Graph
                                            //Horizontal Bar Chart
                                            new Chart(document.getElementById("horizontalBar"), {
//                        "type": "bar",
                                                "type": "${chart}",
                                                "data": {
                                                    "labels": ["Month 12", "Month 11", "Month 10", "Month 9", "Month 8", "Month 7", "Month 6", "Month 5", "Month 4", "Month 3", "Month 2", "Month 1"],
                                                    "datasets": [{
                                                            "label": "Sale $",
                                                            "data": [${totalMoneyMonth12}, ${totalMoneyMonth11}, ${totalMoneyMonth10}, ${totalMoneyMonth9}, ${totalMoneyMonth8}, ${totalMoneyMonth7}, ${totalMoneyMonth6}, ${totalMoneyMonth5}, ${totalMoneyMonth4}, ${totalMoneyMonth3}, ${totalMoneyMonth2}, ${totalMoneyMonth1}],

                                                            "fill": false,
                                                            "backgroundColor": ["rgba(255, 99, 132, 0.7)", "rgba(255, 159, 64, 0.6)",
                                                                "rgba(255, 205, 86, 0.6)", "rgba(75, 192, 192, 0.6)", "rgba(54, 162, 235, 0.6)",
                                                                "rgba(153, 102, 255, 0.6)", "rgba(201, 203, 207, 0.7)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
                                                            ],
                                                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                                                "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
                                                            ],
                                                            "borderWidth": 1
                                                        }]
                                                },
                                                "options": {
                                                    "scales": {
                                                        "xAxes": [{
                                                                "ticks": {
                                                                    "beginAtZero": true
                                                                }
                                                            }]
                                                    }
                                                }
                                            });
                </script>
                <script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
                <!-- MDB -->
                <script type="text/javascript" src="js/mdb.min.js"></script>
                <!-- Custom scripts -->
                <script type="text/javascript" src="js/script.js"></script>




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





                                            function submitForm() {
                                                // Lấy biểu mẫu theo ID
                                                var form = document.getElementById('myForm');
                                                // Gửi biểu mẫu tự động khi có sự kiện onchange xảy ra
                                                form.submit();
                                            }



        </script>

    </body>
</html>


