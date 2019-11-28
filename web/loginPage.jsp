<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="mainStyle.css" type="text/css" media="all" />
</head>
<body>
<div class="container">
    <h1>教室管理系统</h1>
    <div class="signIn">
        <form action="login" method="post">
            <input type="text" class="userName" name="userName" placeholder="账号"  />
            <input type="password" class="userPwd pass" name="userPwd"  placeholder="密码"  /><br>
            <input type="submit" name="login" value="登录" />
            <input type="submit" name="register" value="注册" />
        </form>
    </div>
</div>
</body>
</html>
