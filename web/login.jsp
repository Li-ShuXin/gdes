<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/8
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css">
    <script src="jq/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-4.3.1-dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>登陆</title>

    <script>
        window.onload = function () {
            //1.获取图片对象
            var img = document.getElementById("code");
            //2.绑定单击事件
            img.onclick = function () {
                img.src = "${pageContext.request.contextPath}/verifyCodeServlet?"+new Date().getTime();
            }
        }
    </script>
</head>


<body>
    <div class="header">
        <h4 class="title">登录界面</h4>
        <form action="${pageContext.request.contextPath}/logInServlet" method="post">
            <div class="form-group">
                <label for="user">用户名：</label>
                <input type="text" name="username" class="form-control" id="user">
            </div>
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="text" name="password" class="form-control" id="password">
            </div>

            <div class="form-inline">
                <label for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="vcode">
                <img src="${pageContext.request.contextPath}/verifyCodeServlet" alt="" id="code"/>
            </div>
            <hr/>
            <div class="submit">
                <input type="submit" class="btn btn-primary" id="submit" value="登录">
            </div>
        </form>
        <!-- 登陆反馈提示信息 -->
        <strong>${requestScope.login_error}</strong>
        <strong>${requestScope.vc_error}</strong>
        <strong>${requestScope.login_msg}</strong>
    </div>
</body>
</html>
