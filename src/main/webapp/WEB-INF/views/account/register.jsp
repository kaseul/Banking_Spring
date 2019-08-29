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
    	<form id="modify_form" action="/account/register" method="post">
	    	<table style="">
	            <tr>
	                <td width="120">계좌번호</td>
	                <td><input class="join" type="text" id="aid" name="aid" placeholder="계좌번호" required autofocus></td>
	                <input type="hidden" name="id" value="${user.id}">
	            </tr>
	            <tr>
	                <td>계좌주</td>    
	                <td>${user.uname}</td>
	            </tr>
	            <tr>
	                <td>
	                	<select name="bcode">
	                		<c:forEach var="bank" items="${banks}">
	                			<option value="${bank.bcode}">${bank.bname}</option>
	                		</c:forEach>
	                	</select>
                	</td>    
	                <td><input class="join" type="password" id="pw" name="password" value="${user.password}" required></td>
	            <tr>
	            	<td colspan="2" style="text-align: center"><button type="button" onclick="check()">정보 수정</button></td>
	            </tr>
	        </table>
        </form>
    	<table style="width: 80%">
    		<tr>
    			<th>은행</th>
    			<th>계좌번호</th>
    			<th>잔액</th>
    		</tr>
            <c:forEach var="account" items="${accounts}">
            	<tr>
            		<td>${account.bcode}</td>
            		<td>${account.aid}</td>
            		<td><f:formatNumber value="${account.balance}"></f:formatNumber></td>
            		<td><button type="button" onclick="location.href='/account/modify'">계좌 수정</button></td>
            	</tr>
            </c:forEach>
            <tr>
            	<td colspan="2"><button onclick="location.href='/account/register'">계좌 등록</button></td>
            	<td colspan="2"><button class="right" onclick="remove('계좌를 해지하겠습니까?', '/account/remove')">계좌 해지</button></td>
            </tr>
        </table>
    </div>
    
</body>
</html>