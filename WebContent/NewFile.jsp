<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form class="loginForm" action="loginServlet" method="post">
	<div>账户登录</div>
            <div >
                <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
            </div>

            <div class="loginInput ">
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>
            <button class="btn btn-block redButton" type="submit">登录</button>
            </form>
</body>
</html>