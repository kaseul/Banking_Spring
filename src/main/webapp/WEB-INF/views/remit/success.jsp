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
    <script src="https://use.fontawesome.com/releases/v5.10.1/js/all.js"></script>
    <link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>
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
        
        svg.sucess, svg.success > path {
        	color: #3366CC;
        }
    </style>
</head>
<body>
	<div id="header">
      	 송금 시스템
    </div>
    <div id="nav">
    	<ul>
		  <li><a href="/user">회원 정보</a></li>
		  <li><a href="/account">계좌</a></li>
		  <li><a class="active" href="/remit">송금</a></li>
		  <li><a href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="container">
	    <div id="account" style="text-align: center;">
	    	<h1>송금</h1>
	    	<hr width="80%">
	    	<p style="padding: 50px 0px; font-size: 20px;">
	    		<span>
					<i class="far fa-check-circle fa-3x success"></i>
				</span>
	   			<br>
	    		정상적으로 송금을 완료했습니다.
	    	</p>
	    	<br>
	    	<button style="position: absolute; bottom: 30px; transform: translate(-50%);" onclick="location.href='/remit'">확인</button>
	    </div>
    </div>
</body>
</html>