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
    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart);

  function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', '월');
        data.addColumn('number', '거래 내역');

        
        
        data.addRows([
        	<c:forEach var="trans" items="${transactions}">
        		['${trans.month}', ${trans.count}],
        	</c:forEach>
        ]);


        var options = {
          title: '월별 거래 내역 조회',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

    var chart = new google.charts.Line(document.getElementById('chart'));

    chart.draw(data, google.charts.Line.convertOptions(options));
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
		  <li><a href="/remit">송금</a></li>
		  <li><a class="active" href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="container">
	    <div id="remit">
	    	<h1>거래 내역 조회</h1>
	    	<hr width="80%">
	    	<div id="chart"></div>
	    </div> <!-- remit -->
    </div> <!-- container -->
</body>
</html>