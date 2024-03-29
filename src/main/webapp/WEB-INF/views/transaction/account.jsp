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
	    
	    function go(element) {
	    	var outaid = document.getElementById(element).value;
	    	
	    	if(outaid == "") {
	    		document.getElementById('button').click();
	    	}
	    	else {
	    		location.href = '/transaction/inquiry?outaid=' + outaid;
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
		  <li><a href="/remit">송금</a></li>
		  <li><a class="active" href="/transaction">거래 내역 조회</a></li>
		</ul>
    </div>
    <div id="container">
	    <div id="remit">
	    	<h1>거래 내역 조회</h1>
	    	<hr width="80%">
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
		                			<a onclick="selectAccountTrans('${account.bcode}', '${account.bname}', '${account.aid}')">
		                				<img src="<c:url value="/resources/image/bank/logo_${account.bcode}.png"/>" width="30">
		                				${account.bname} │ ${account.aid}
		                			</a>
		                		</c:forEach>
						  	</div>
	                	</div>
	                	<input type="hidden" id="outaid" name="outaid">
                	</td>    
                </tr>
                <tr>
                	<td colspan="2" style="text-align: center">
                		<button onclick="go('outaid')">조회</button>
                	</td>
                </tr>
			</table>
	    </div> <!-- remit -->
	    
	    <!-- modal -->
	    <input type="hidden" style="" id="button" data-toggle="modal" data-target="#checkModal">
	    <!-- The Modal -->
	  	<div class="modal fade" id="checkModal">
	    	<div class="modal-dialog"> <!--  style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; position: relative; width: 100%; height: 100%;" -->
	      		<div class="modal-content">
		        	<!-- Modal Header -->
			        <!-- <div class="modal-header">
			        	<h4 class="modal-title">Modal Heading</h4>
			          	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div> -->
			        
			        <!-- Modal body -->
			        <div id="modalBody" class="modal-body">
			        	계좌를 선택해주세요
			        </div>
			        
			        <!-- Modal footer -->
			        <!-- <div class="modal-footer">
			        	<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			        </div> -->
	      		</div>
	    	</div>
	  	</div> <!-- modal -->
    </div> <!-- container -->
</body>
</html>