<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>
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
    </style>
</head>
<body>
	<div id="header">
      	 송금 시스템
    </div>
    <div id="nav">
    	<ul>
		  <li><a class="active" href="/user">회원 정보</a></li>
		  <li><a href="/account">계좌 등록</a></li>
		  <li><a href="/remit">송금</a></li>
		  <li><a href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="user">
    	<h1>회원 정보</h1>
    	<hr width="80%">
    	<table style="">
            <tr>
                <td width="120">ID</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>이름</td>    
                <td>${user.uname}</td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td><f:formatDate value="${user.birth}" pattern="YYYY/MM/dd"/></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>${user.tel}</td>
            </tr>
        </table>
    </div>
</body>
</html>