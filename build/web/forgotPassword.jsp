<%-- 
    Document   : forgotPassword
    Created on : Nov 8, 2023, 6:07:50 PM
    Author     : Truong cun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home| KibyhunterShop </title>
        <!--<link href="css/font.css" rel="stylesheet" type="text/css"/>-->
        <link href="css/bootrap.css" rel="stylesheet" type="text/css"/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">



        <style>
            body{
                background:#eee;
                background-image: url("https://images.unsplash.com/photo-1553095066-5014bc7b7f2d?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8d2FsbCUyMGJhY2tncm91bmR8ZW58MHx8MHx8fDA%3D");
            }
            .separator {
                border-right: 1px solid #dfdfe0;
            }
            .icon-btn-save {
                padding-top: 0;
                padding-bottom: 0;
            }
            .input-group {
                margin-bottom:10px;
            }
            .btn-save-label {
                position: relative;
                left: -12px;
                display: inline-block;
                padding: 6px 12px;
                background: rgba(0,0,0,0.15);
                border-radius: 3px 0 0 3px;
            }

            #customers {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr{
                background-color: #f2f2f2;
            }

            #customers tr:hover {
                background-color: #ddd;
            }


            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            }
        </style>
    </head>


    <body>
        <div class="container bootstrap snippets bootdey">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-9 col-md-offset-2">


                    <form action="forgot" method="get">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <span class="glyphicon glyphicon-th"></span>
                                    Forgot password   
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 separator social-login-box"> <br>
                                        <img alt="" style="width: 70%" class="img-thumbnail" src="images/truongcun.jpg">                        
                                    </div>
                                    <div style="margin-top:80px;" class="col-xs-6 col-sm-6 col-md-6 login-box">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                                                <input class="form-control" type="text" placeholder="Your UserName"  name="user">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon"><span class="glyphicon glyphicon-log-in"></span></div>
                                                <input class="form-control" type="text" placeholder="Your Email" name="email">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon"><span class="glyphicon glyphicon-log-in"></span></div>
                                                <input class="form-control" type="text" placeholder="Your Phone" name="phone">
                                            </div>
                                        </div>
                                        <div class="form-group">


                                            <input style="border: 1px; border-radius: 5px; background-color: orange; margin-left: 40%;
                                                   padding: 4px" type="submit"  value="Forgot Pass"/>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="row">

                                    <div class="col-xs-6 col-sm-6 col-md-6">


                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <c:set  var="a" value="${list}" />
                    <c:if test="${a==null}">
                        <h4 style="color: green; font-family: cursive">No one at all</h4>
                    </c:if>
                    <c:if test="${list!=null}">
                        <table style="text-align: center ;" id="customers">
                            <tr>
                                <th> Avatar  </th>
                                <th>Name</th>
                                <th>Status</th>
                            </tr>
                            ${mas}
                            <c:forEach var="c" items="${a}">
                                <tr>
                                    <td style="width: 50%"> <img width="50%" src="${c.avatar}" alt="not found"/> </td>
                                    <td>  ${c.realname}  </td>
                                    <td> 
                                        <form method="post" action="forgot?user=${c.username}&email=${c.email}&phone=${c.phone}">

                                            <input type="submit" style="background-color: orange ; padding: 4px ; border-radius: 5px" value="Reset Password"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>



                        </table>
                    </c:if>






                </div>
            </div>
        </div>







    </body>
</html>
