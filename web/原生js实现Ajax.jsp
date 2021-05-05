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
    <title>原生js实现Ajax</title>
</head>
<script>
    function fun() {
        //创建核心对象
        var xhttp;
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
//建立连接
        /**
         * 1:请求参数：get,post
         * 2:请求的URL
         * 异步（asynchronous)：true  同步（synchro):false
         */
        xhttp.open("GET", "ajaxServlet?username=whj", true);
//发送请求
        xhttp.send();
        //接受并处理服务器的响应
        //获取方式 ：xmlhttp.responseText
        //什么时候获取？当服务器响应成功后再获取

        //当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
        xhttp.onreadystatechange=function()
        {
            //判断readyState就绪状态是否为4，判断status响应状态码是否为200
            if (xhttp.readyState==4 && xhttp.status==200)
            {
                //获取服务器的响应结果
                var responseText = xhttp.responseText;
                alert(responseText);
            }
        }

    }
</script>
<body>
<input type="button" value="发送异步请求"   onclick="fun();">
<input >


</body>
</html>
