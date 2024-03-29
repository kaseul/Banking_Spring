<!-- 로그인 폼 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <style>
    	html {
            margin: 0 auto;
            padding: 0;
            background: url('<c:url value="/resources/image/index_background.jpg"/>') no-repeat center center fixed; 
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
        body {
        	background: rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>
    <div id="login">
        <form action="login" method="post" id="login_form">
            <input class="login" type="text" id="login_id" name="loginId" placeholder="ID" autofocus> <br>
            <input class="login" style="margin-bottom: 0px;" type="password" id="login_pw" name="loginPw" placeholder="비밀번호">
            <p id="login_result" style="color: red">
            	<c:if test="${result == 'fail'}">
            		ID나 비밀번호가 일치하지 않습니다.
            	</c:if>
            </p>
            <input type="button" class="btn_login" value="로그인" onclick="login()">
            <input type="button" class="btn_login" value="회원이 아니신가요?" onclick="location.href='join'" style="margin-bottom: 0px">
        </form>
    </div>
</body>
</html>