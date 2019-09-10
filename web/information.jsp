<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/8
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css">
    <script src="jq/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-4.3.1-dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>$Title$</title>
  </head>
  <body>
  <!-- 头部 -->
  <header>
    <!-- 退出 -->
    <a class="sign_out" href="#">退出</a>
    <!-- 个人中心 -->
    <a class="personal" href="#">个人中心</a>
  </header>
  <!-- 主体 -->
  <div class="container-fluid">
    <div class="row">
      <!-- 左导航栏 -->
      <nav class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col-4" >
        <!-- 头像 -->
        <div class="head_sculpture">
          <img class="rounded-circle" src="images/touxiang.jpg" alt="头像"></div>
        <!-- 选择功能 -->
        <div class="choose">
          <ul class="nav nav-tabs flex-column">
            <!-- 首页选项 -->
            <li>
              <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">首页</a>
            </li>
            <!-- 作业选项 -->
            <li>
              <a class="nav-link" href="${pageContext.request.contextPath}/work.jsp">作业</a>
            </li>
            <!-- 作业提交选项 -->
            <li>
              <a class="nav-link" href="${pageContext.request.contextPath}/submit.jsp">提交作业</a>
            </li>
            <!-- 发布选项 -->
            <li >
              <a class="nav-link" href="${pageContext.request.contextPath}/issue.jsp">发布</a>
            </li>
            <!-- 收集选项 -->
            <li >
              <a class="nav-link" href="${pageContext.request.contextPath}/gather.jsp">收集情况</a>
            </li>
            <!-- 资源选项 -->
            <li >
              <a class="nav-link active" href="${pageContext.request.contextPath}/information.jsp">资源</a>
            </li>
          </ul>
        </div>
      </nav>
      <!-- 右内容主体 -->
      <article class="col-xl-10 col-lg-10 col-md-10 col-sm-9 col-8 tab-content">
        <!-- 资源模块 -->
        <div class="container" id="information">这是 资源 模块</div>
      </article>
    </div>
  </div>

  <footer></footer>
  </body>
</html>
