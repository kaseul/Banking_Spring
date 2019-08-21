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
</head>
<body>
    <div id="login">
        <form action="login" method="post" id="login_form">
            <input class="login" type="text" id="login_id" name="loginId" placeholder="ID"> <br>
            <input class="login" type="password" id="login_pw" name="loginPw" placeholder="비밀번호">
            <input type="button" class="btn_login" value="로그인" onclick="login()">
            <input type="button" class="btn_login" value="회원이 아니신가요?" onclick="location.href='join'">
        </form>
    </div>
</body>
</html>