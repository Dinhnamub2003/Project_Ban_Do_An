<%-- 
    Document   : chartView
    Created on : Oct 26, 2023, 9:14:45 PM
    Author     : Truong cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                padding :0;
                margin: 0;
                box-sizing: border-box;

            }
            body{
                min-height: 100vh;
            }
            .container{
                width:  50%;
                margin: 0px auto;
                padding-top: 100px;
            }

            .container .title{
                text-align: center;
                font-size: 40px;
                margin-bottom: 40px;

            }


            #canvas{
                width: 100%;
            }
        </style>


    </head>
    <body>

        <div class="container">
            <div class="title">Line chart</div>
            <canvas id ="canvas"></canvas>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
        <script  >

            const labels = ['January', 'February', 'March', 'April', 'May', 'June'];
            const data = {
                labels: labels,
                datasets: [
                    {
                    labels: ["Đồ ăn truyền thống", "Đồ ăn nhanh", "Canh", "Đồ ăn chay", "Đồ ăn healthy", "Nước ép", "Nước có gas", "Đồ uống có cồn", "Nước khoáng"],

                        label: 'Lượt truy cập',
                        backgroundColor: 'blue',
                        borderColor: 'blue',
                        data: [${view1}, ${view2}, ${view3}, ${view4}, ${view5}, ${view6}, ${view7},${view8},${view9}],

                        tension: 0.4,
                    }
                ]
            }


            const config = (config = {
                type = 'line',
                data: data
            });
            const canvas = document.getElementById('canvas');
            const chart = new Chart(canvas, config);

        </script>    
    </body>
</html>
