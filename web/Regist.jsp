<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            //给username绑定blur事件
            $("#username").blur(function () {
                //获取username文本输入框的值
                var username = $(this).val();
            })

            //发送ajax请求
            $.get("findUserServlet",{username:username},function (data) {
                //判断userExsit键的值是否是true

                // alert(data);
                var span = $("#s_username");
                if(data.userExsit){
                    //用户名存在
                    span.css("color","red");
                    span.html(data.msg);
                }else{
                    //用户名不存在
                    span.css("color","green");
                    span.html(data.msg);
                }

            })

        })
    </script>
</head>
<body>
<form>

    <input type="text" id="username" name="username" placeholder="请输入用户名">
    <span id="s_username"></span>
    <br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="注册"><br>

</form>

</body>
</html>