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
    <!-- Font Awesome -->
    <script src="https://use.fontawesome.com/releases/v5.10.1/js/all.js"></script>
    <!-- Google Chart -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <!-- bootstrap -->
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
	    var data;
	    var options;
	    // google.charts.load('current', {'packages':['line']});
	    google.charts.load('current', {packages: ['corechart', 'line']});
	    google.charts.setOnLoadCallback(drawChart);
	
	    function drawChart() {
	        data = new google.visualization.DataTable();
	        data.addColumn('string', '월');
	        data.addColumn('number', '거래 내역');
	        
	        data.addRows([
	        	<c:forEach var="trans" items="${transactions}">
	        		['${trans.month}'.substring(5) + '월', ${trans.count}],
	        	</c:forEach>
	        ]);
	
	
	        options = {
	          title: '월별 거래 내역 조회',
	          legend: { position: 'bottom' }
	        };
	
	    // var chart = new google.charts.Line(document.getElementById('chart'));
	    // chart.draw(data, google.charts.Line.convertOptions(options)); 
	    
	        var chart = new google.visualization.LineChart(document.getElementById('chart'));
	    	chart.draw(data, options);
	  	}
	  
	  	function resize() {
			var chart = new google.visualization.LineChart(document.getElementById('chart'));
	      	chart.draw(data, options);
	  	}
	  	
	  	function go(direction) {
	  		var month = ${month};
	  		if(direction == 'left') {
	  			location.href='/transaction/inquiry?outaid=${account.aid}&month=' + (month - 1);
	  		}
	  		else {
	  			location.href='/transaction/inquiry?outaid=${account.aid}&month=' + (month + 1);
	  		}
	  	}
  		
	  	window.onresize = resize;
	</script>
</head>
<body>
<table style="width: 100%; min-height: 100%">
	<tr height="120">
		<td style="position: fixed; width: 100%; z-index: 10; padding: 0px">
			<div id="header" style="position: fixed; width: 100%; height: 70px;">
		      	 송금 시스템
		    </div>
		    <div id="nav" style="position: fixed; width: 100%; top: 70px;">
		    	<ul>
				  <li><a href="/user">회원 정보</a></li>
				  <li><a href="/account">계좌</a></li>
				  <li><a href="/remit">송금</a></li>
				  <li><a class="active" href="/transaction">거래 내역 조회</a></li>
				</ul>
		    </div>
		</td>
	</tr>
	<tr>
		<td style="min-height: 100%;">
		    <div id="transactions">
		    	<h1>거래 내역 조회</h1>
		    	<hr width="80%">
		    	<div id="accountContent">
		    		계좌 : ${account.aid} <br>
		    		잔액 : <f:formatNumber value="${account.balance}"></f:formatNumber>
		    	</div>
		    	<div id="chart"></div>
		    	<div id="transaction">
		    		<div style="text-align: center; font-size: 20px; margin-top: 20px;">
		    			<a style="float: left; margin-left: 20px;" onclick="go('left')">
		    				<i class="fas fa-chevron-left"></i>
		    			</a>
		    			<span><f:formatDate value="${date}" pattern="yyyy년 MM월"/></span>
		    			<a style="float: right; margin-right: 20px;" onclick="go('right')">
		    				<i class="fas fa-chevron-right"></i>
		    			</a>
		    		</div>
		    		<hr width="80%">
			    	<table class="default center nopadding" style="border: none; font-size: 14px">
			    		<tr>
			    			<th> 날짜 </th>
							<th> 은행 </th>
							<th> 계좌번호 </th>
							<th> 계좌주 </th>
							<th> 입금/출금 </th>
							<th> 금액 </th>
			    		</tr>
			    		<c:forEach var="trans" items="${transactionList}">
			    			<tr>
			    				<td> <f:formatDate value="${trans.remit_date}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			    				<c:choose>
			    					<c:when test="${trans.outaid == account.aid}">
			    						<td>${trans.inbname}</td>
			    						<td>${trans.inaid}</td>
			    						<td>${trans.inname}</td>
			    						<td>출금</td>
			    						<td style="color: tomato">-<f:formatNumber value="${trans.price}"></f:formatNumber></td>
			    					</c:when>
			    					<c:otherwise>
			    						<td>${trans.outbname}</td>
			    						<td>${trans.outaid}</td>
			    						<td>${trans.outname}</td>
			    						<td>입금</td>
			    						<td style="color: #3366CC"><f:formatNumber value="${trans.price}"></f:formatNumber></td>
			    					</c:otherwise>
			    				</c:choose>
			    			</tr>
			    		</c:forEach>
			    		<tr>
			    			<td colspan="6">
			    				<button onclick="location.href='/transaction'">
			    					뒤로가기
			    				</button>
			    			</td>
			    		</tr>
			    	</table>
		    	</div>
		    </div> <!-- remit -->
		</td>
	</tr>
</table>
    
</body>
</html>