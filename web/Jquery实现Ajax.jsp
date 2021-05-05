<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/5/4
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jquery实现Ajax</title>
</head>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    function fun() {
        //使用$.ajax()发送异步请求
       $.ajax({
           url:"ajaxServlet",//请求路径
           type:"POST",//请求方式
           data:{"username":"whj","age":"22"},
           success:function (data) {
               alert(data)
           }

       });

    }
</script>
<body>
<input type="button" value="发送异步请求"   onclick="fun();">
<input >


</body>
</html>
