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
    </style>
    <script>
		window.onclick = function(event) {
		  	if (!event.target.matches('.dropdiv')) {
		    	var dropdowns = document.getElementsByClassName("dropdown-content");
		    	var i;
		    	for (i = 0; i < dropdowns.length; i++) {
		    		var openDropdown = dropdowns[i];
		      		if (openDropdown.classList.contains('show')) {
		        		openDropdown.classList.remove('show');
		      		}
		    	}
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
    <div id="account">
    	<h1>송금</h1>
    	<hr width="80%">
    	<form id="register_form" action="/account/register" method="post">
	    	<table class="default left">
	    		<tr>
	                <td>
	                	<div class="dropdown">
	                		<div id="selectedBank" class="dropdiv" onclick="dropdown()">
	                			계좌 선택
	                			<i class="fas fa-chevron-down"></i>
	                		</div>
	                		<div id="bankDropdown" class="dropdown-content">
	                			<c:forEach var="bank" items="${banks}">
		                			<a href="javascript:void(0)" onclick="selectBank('${bank.bcode}', '${bank.bname}')">
		                				<img src="<c:url value="/resources/image/bank/logo_${bank.bname}.png"/>" width="30">
		                				${bank.bname}
		                			</a>
		                		</c:forEach>
						  	</div>
	                	</div>
	                	<input type="hidden" id="bcode" name="bcode">
                	</td>    
	                <td>
	                	<input class="default" type="text" id="aid" name="aid" placeholder="계좌번호" pattern="[0-9]+[0-9-]{7,16}[0-9]" required autofocus>
                	</td>
                </tr>
	            <tr>
	                <td width="140">계좌주</td>
	                <td>
	                	${user.uname}
	                	<input type="hidden" name="id" value="${user.id}">
                	</td>
	            </tr>
                <tr>
                	<td>잔액</td>
	                <td>
	                	<input class="default" type="number" id="balance" name="balance" placeholder="잔액" min="0" required>
                	</td>
                </tr>
	            <tr>
	            	<td colspan="2" style="text-align: center"><button type="submit">등록</button></td>
	            </tr>
	        </table>
        </form>
    </div>
    
</body>
</html>