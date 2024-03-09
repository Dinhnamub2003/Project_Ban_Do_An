

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home| KibyhunterShop </title>
        <link href="css/font.css" rel="stylesheet" type="text/css"/>
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

        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

        <style>



         table {
                                width: 100%;
                                padding: 20px;
                                text-align: center;


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




            @media (min-width: 1025px) {
                .h-custom {
                    height: 100vh !important;
                }
            }
        </style>


    </head>

    <body>

        <header id="header"><!--header-->


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

                    </div>
                </div>
            </div><!--/header-middle-->



            <!-- header-bottom --> -->
        </header><!--/header-->




        <section class="h-100 h-custom" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col ">
                        <div class="card">
                            <div class="card-body p-4">

                                <div class="row">


                                    <div class="col-md-8">




                                        <h5 class="mb-3"><a href="home" class="text-body"><i
                                                    class="fas fa-long-arrow-alt-left me-2"></i>Continue shopping</a></h5>
                                        <hr>

                                     

                                        
                                  


                                        <table border="1" style=" width: 100%;
                                              
                                                   border-collapse: collapse;
                                               width: 100%;
                                               color: #333;
                                               font-family: Arial, sans-serif;
                                               font-size: 14px;
                                               text-align: left;
                                               border-radius: 10px;
                                               overflow: hidden;
                                               box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                                               margin: auto;
                                               margin-top: 50px;
                                               margin-bottom: 50px;
                                                padding: 20px;
                                               text-align: center;
                                               " >

                                            <tr>
                                                <th>#</th>
                                                <th>IMG</th>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                                <th>Action</th>
                                            </tr>

                                  

                                          


                                                <tbody>
                                                    <c:forEach items="${carts}" var="C">
                                                    <form id="myForm" action="cartupdate?user=${acc.username}">
                                                        <tr>
                                                        <input type="hidden" name="id" value="${C.value.product.id}"/>
                                                        <th scope="row">${C.value.product.id}</th>
                                                        <td>
                                                            ${C.value.product.name}
                                                      
                                                        </td>
                                                        <td><img src="${C.value.product.images}" width="50"/></td>
                                                        <td>
                                                             <fmt:formatNumber pattern="##.#" value=" ${C.value.product.price}"/>
                                                           </td>
                                                        <td><input onchange="this.form.submit()" type="number" name="quantity" value="${C.value.quantity}"/></td>
                                                        <td>
                                                            <fmt:formatNumber pattern="##.#" value="${C.value.product.price*C.value.quantity}"/>

                                                        </td>
                                                        <td><a href="cartdelete?id=${C.value.product.id}" class="btn btn-outline-danger"><i class="bi bi-trash"></i>Delete</a></td>
                                                        </tr>
                                                    </form>
                                                </c:forEach>
                                                 
                                                </tbody>
                                       

                                        </table>
                                                <!--<h4 style="color:white ; background: goldenrod; padding: 5px; border-radius: 10px; text-align: center" >Total Amount: ${totalMoney}</h4>-->












                                    </div>



                                                <c:set var="a" value="${acc}" />

                                                <c:if test="${a==null}">
                                                    
                                                        <div style="background: goldenrod" class="text-white rounded-3 col-md-4">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between align-items-center mb-4">
                                                <h5 class="mb-0">Checkout</h5>
                                                <img style="border-radius: 50%;width: 20%" src="images/truongcun.jpg"
                                                     class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                            </div>

                                          

                                            <form class="mt-4">
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeName" class="form-control form-control-lg" siez="17"
                                                           placeholder="Kibyhunter" />
                                                    <label class="form-label" for="typeName">Your Name</label>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" class="form-control form-control-lg" siez="17"
                                                           placeholder="0987 654 321" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Phone Number</label>
                                                </div>
                                                
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" class="form-control form-control-lg" siez="17"
                                                           placeholder="kihyhunter@food.com" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Email</label>
                                                </div>
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" class="form-control form-control-lg" siez="17"
                                                           placeholder="VietNam" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Address</label>
                                                </div>
                                                <div class="form-outline form-white mb-4">
                                                    <select>
                                                        <option>Cash</option>
                                                        <option>Credit Card</option>
                                                        <option>Debit Card</option>
                                                        <option>Bank Transfer</option>
                                                    </select>
                                                   
                                                </div>

                                          

                                            </form>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Shipping</p>
                                                <p class="mb-2">Free</p>
                                            </div>

                                            <div class="d-flex justify-content-between mb-4">
                                                <p class="mb-2">Total</p>
                                                <p class="mb-2">${totalMoney}</p>
                                            </div>

                                            <button style="background :gold" type="button" class="btn btn-info btn-block btn-lg">
                                                <div class="d-flex justify-content-between">
                                                    <span>${totalMoney}</span>
                                                    <span >Checkout <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                                </div>
                                            </button>

                                        </div>
                                    </div>

                                                    
                                                </c:if>           
                                
                                                
                                                <c:if test="${a!=null}"> 
                                                
                                                    <div style="background: goldenrod" class="text-white rounded-3 col-md-4">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between align-items-center mb-4">
                                                <h5 class="mb-0">Checkout</h5>
                                                <img style="border-radius: 50%;width: 20%" src="images/truongcun.jpg"
                                                     class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                            </div>

                                          

                                            <form class="mt-4">
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeName" name="name" value="${a.realname}" class="form-control form-control-lg" siez="17"
                                                           placeholder="Kibyhunter" />
                                                    <label class="form-label" for="typeName">Your Name</label>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" name="phone" value="${a.phone}" class="form-control form-control-lg" siez="17"
                                                           placeholder="0987 654 321" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Phone Number</label>
                                                </div>
                                                
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" name="email" value="${a.email}" class="form-control form-control-lg" siez="17"
                                                           placeholder="kihyhunter@food.com" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Email</label>
                                                </div>
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeText" name="address" value="${a.address}" class="form-control form-control-lg" siez="17"
                                                           placeholder="VietNam" minlength="19" maxlength="19" />
                                                    <label class="form-label" for="typeText">Address</label>
                                                </div>
                                                <div class="form-outline form-white mb-4">
                                                    <select name="checkout">
                                                        <option value="Cash">Cash</option>
                                                        <option  value="Credit Card">Credit Card</option>
                                                        <option value="Debit Card">Debit Card</option>
                                                        <option  value="Bank Transfer"> Bank Transfer</option>
                                                    </select>
                                                   
                                                </div>

                                          

                                            </form>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Shipping</p>
                                                <p class="mb-2">Free</p>
                                            </div>

                                            <div class="d-flex justify-content-between mb-4">
                                                <p class="mb-2">Total</p>
                                                <p class="mb-2">${totalMoney}</p>
                                            </div>

                                            <button style="background :gold" type="button" class="btn btn-info btn-block btn-lg">
                                                <div class="d-flex justify-content-between">
                                                    <span >${totalMoney}</span>
                                                    <span ><a href="cartOrder?user=${a.username}&total=${totalMoney}">Checkout</a> <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                                    <span ><a href="mail">Mail</a> <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                                </div>
                                            </button>

                                        </div>
                                    </div>

                                                
                                                
                                                </c:if>


                                </div>






                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script>
            function submitForm() {
                // Lấy biểu mẫu theo ID
                var form = document.getElementById('myForm');
                // Gửi biểu mẫu tự động khi có sự kiện onchange xảy ra
                form.submit();


        </script>
    </body>

</html>

