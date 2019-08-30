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
    </style>
    
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
    <div id="account">
    	<h1>계좌</h1>
    	<hr width="80%">
    	<table class="default">
    		<tr>
    			<th>은행</th>
    			<th colspan="2">계좌번호</th>
    			<th>잔액</th>
    		</tr>
    		<c:choose>
    			<c:when test="${accounts == 'null'}">
    				<tr>
    					<td colspan="4" style="padding: 30px 0px;">아직 등록된 계좌가 없습니다</td>
    				</tr>
    				<tr>
    					<td colspan="4">
    						<button style="position: absolute; left: 50%; transform: translate(-50%, -50%);" type="button" onclick="location.href='/account/register'">계좌 등록</button>
    					</td>
    				</tr>
    			</c:when>
    			<c:otherwise>
    				<c:forEach var="account" items="${accounts}">
		            	<tr>
		            		<td>${account.bcode}</td>
		            		<td>${account.aid}</td>
		            		<td><f:formatNumber value="${account.balance}"></f:formatNumber></td>
		            		<td><button type="button" onclick="location.href='/account/modify'">계좌 수정</button></td>
		            	</tr>
		            	<tr>
			            	<td colspan="2"><button onclick="location.href='/account/register'">계좌 등록</button></td>
			            	<td colspan="2"><button class="right" onclick="remove('계좌를 해지하겠습니까?', '/account/remove')">계좌 해지</button></td>
			            </tr>
		            </c:forEach>	
    			</c:otherwise>
    		</c:choose>
   		</table>
    </div>
    
</body>
</html>