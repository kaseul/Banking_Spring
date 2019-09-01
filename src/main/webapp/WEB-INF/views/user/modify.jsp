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
    <script>
    	function check() {
    		var pw = document.getElementById('pw').value.trim();
    		var pw_check = document.getElementById('pw_check').value.trim();
    		if(pw == "" || pw_check == "") {
    			alert("비밀번호를 입력해주세요");
    		}
    		else if(pw != pw_check) {
    			alert("비밀번호가 맞지 않습니다.");
    		}
    		else {
    			document.getElementById('modify_form').submit();
    		}
    	}
    </script>
</head>
<body>
	<div id="header">
      	 송금 시스템
    </div>
    
    <div id="nav">
    	<ul>
		  <li><a class="active" href="/user">회원 정보</a></li>
		  <li><a href="/account">계좌</a></li>
		  <li><a href="/remit">송금</a></li>
		  <li><a href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="user">
    	<h1>회원 정보</h1>
    	<hr width="80%">
    	<form id="modify_form" action="/user/modify" method="post">
	    	<table class="default left">
	            <tr>
	                <td width="120">ID</td>
	                <td>${user.id}</td>
	                <input type="hidden" name="id" value="${user.id}">
	            </tr>
	            <tr>
	                <td>이름</td>    
	                <td>${user.uname}</td>
	            </tr>
	            <tr>
	                <td>비밀번호</td>    
	                <td><input class="join" type="password" id="pw" name="password" value="${user.password}"></td>
	            </tr>
	            <tr>
	                <td>비밀번호 확인</td>    
	                <td><input class="join" type="password" id="pw_check" name="password_check" value="${user.password}"></td>
	            </tr>
	            <tr>
	                <td>생년월일</td>
	                <td><f:formatDate value="${user.birth}" pattern="YYYY/MM/dd"/></td>
	            </tr>
	            <tr>
	                <td>전화번호</td>
	                <td><input class="join" type="text" id="join_pw" name="tel" value="${user.tel}"></td>
	            </tr>
	            <tr>
	            	<td colspan="2" style="text-align: center"><button type="button" onclick="check()">정보 수정</button></td>
	            </tr>
	        </table>
        </form>
    </div>
</body>
</html>