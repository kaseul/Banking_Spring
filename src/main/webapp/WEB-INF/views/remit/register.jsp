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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
		  	
		  	if('${result}' != 'null') {
		  		if('${result}' == 'fail') {
		  			alert('존재하지 않는 계좌입니다.');
		  		}
		  		else {
		  			alert('정상적으로 송금하였습니다.');
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
		  <li><a href="/user">회원 정보</a></li>
		  <li><a href="/account">계좌</a></li>
		  <li><a class="active" href="/remit">송금</a></li>
		  <li><a href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="account">
    	<h1>송금</h1>
    	<hr width="80%">
    	<form id="register_form" action="/remit/register" method="post">
	    	<table class="default left">
	    		<tr>
	    			<td width="140">
	                	본인 계좌
                	</td>
	                <td>
	                	<div class="dropdown account">
	                		<div id="selectedAccount" class="dropdiv account" onclick="dropdown('accountDropdown')">
	                			계좌 선택
	                			<div>
	                				<i class="fas fa-chevron-down"></i>
                				</div>
	                		</div>
	                		<div id="accountDropdown" class="dropdown-content account">
	                			<c:forEach var="account" items="${accounts}">
		                			<a href="javascript:void(0)" onclick="selectAccount('${account.bcode}', '${account.bname}', '${account.aid}')">
		                				<img src="<c:url value="/resources/image/bank/logo_${account.bname}.png"/>" width="30">
		                				${account.bname} │ ${account.aid}
		                			</a>
		                		</c:forEach>
						  	</div>
	                	</div>
	                	<input type="hidden" id="no" name="no" value="0">
	                	<input type="hidden" id="outaid" name="outaid">
	                	<input type="hidden" id="outbcode" name="outbcode">
                	</td>    
                </tr>
	            <tr>
	                <td>
	                	<div class="dropdown">
	                		<div id="selectedBank" class="dropdiv" onclick="dropdown('bankDropdown')">
	                			은행 종류
	                			<div>
	                				<i class='fas fa-chevron-down'></i>
                				</div>
	                		</div>
	                		<div id="bankDropdown" class="dropdown-content">
	                			<c:forEach var="bank" items="${banks}">
		                			<a href="javascript:void(0)" onclick="selectBankWithCom('${bank.bcode}', '${bank.bname}', '${bank.commission}')">
		                				<img src="<c:url value="/resources/image/bank/logo_${bank.bname}.png"/>" width="30">
		                				${bank.bname}
		                			</a>
		                		</c:forEach>
						  	</div>
	                	</div>
	                	<input type="hidden" id="inbcode" name="inbcode">
	                	<input type="hidden" id="commission" name="commission">
                	</td>    
	                <td>
	                	<input class="default" type="text" id="inaid" name="inaid" placeholder="계좌번호" pattern="[0-9]+[0-9-]{7,16}[0-9]" required>
                	</td>
	            </tr>
                <tr>
                	<td>금액</td>
	                <td>
	                	<input class="default" type="number" id="price" name="price" placeholder="금액" min="1" max="1000000" required>
                	</td>
                </tr>
	            <tr>
	            	<td colspan="2" style="text-align: center">
	            		<button type="submit">송금</button>
            		</td>
	            </tr>
	        </table>
        </form>
    </div>
</body>
</html>