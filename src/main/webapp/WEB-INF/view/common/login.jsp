<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }"/>

<html lang="en-US">
<head>

    <meta charset="utf-8">

    <title>Login</title>
    <link href="${ctx}/resources/css/login.css" type=text/css rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div id="login">
    <h2><span class="fontawesome-lock"></span>用户登录</h2>
    <form action="${ctx}/login" method="POST">
        <fieldset>
            <p><label for="loginName">用户名</label></p>
            <p><input type="text" name="loginName" id="loginName" value=""  ></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->
            <p><label for="password">密码</label></p>
            <p><input type="password" name="password" id="password" value="password" ></p> <!-- JS because of IE support; better: placeholder="password" -->
            <p><input type="submit" value="登 录"></p>
        </fieldset>
    </form>

</div> <!-- end login -->

</body>
</html>