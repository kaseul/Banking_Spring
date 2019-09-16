<!-- 회원가입 폼 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
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
    	body {
        	background: rgba(0, 0, 0, 0.5);
        }
    </style>
    <script>
    	window.onload = function() {
    		if('${result}' == 'fail') {
    			alert('사용할 수 없는 아이디입니다.');
    		}
    	}
    	
    	function join() {
    	    var id = document.getElementById('join_id').value.trim();
    	    var name = document.getElementById('join_name').value.trim();
    	    var pw = document.getElementById('join_pw').value.trim();
    	    var pw_check = document.getElementById('join_pw_check').value.trim();
    	    var birth = document.getElementById('join_birth').value.trim();
    	    var tel = document.getElementById('join_tel').value.trim();
    	    
    	    if(id == "" || name == "" || pw == "" || pw_check == "" || birth == "" || tel == "") {
    	        alert('양식을 모두 입력해주세요');
    	    }
    	    else if(pw != pw_check) {
    	        alert('같은 비밀번호를 입력해주세요')
    	    }
    	    else {
    	    	<c:forEach var="data" items="${datas}">
    	    		<c:if test="${data.column_name == 'ID'}">
    	    			if(id.length > ${data.data_length}) {
    	    				alert('아이디는 ' + ${data.data_length} + '자리 이하여야 합니다.');
    	    			}
    	    			else {
    	    				document.getElementById('join_form').submit();
    	    			}
    	    		</c:if>
    	    	</c:forEach>
    	    }
    	}
    	
    </script>
</head>
<body>
    <div id="join">
        <div class="title">회원가입</div>
        <form action="join" method="post" id="join_form">
            <table>
                <tr>
                    <td width="120">ID</td>
                    <td><input class="join" type="text" id="join_id" name="id" placeholder="ID" required autofocus></td>
                </tr>
                <tr>
                	<td colspan="2" id="check" style="color: #ff00000;"></td>
                </tr>
                <tr>
                    <td>이름</td>    
                    <td><input class="join" type="text" id="join_name" name="uname" placeholder="이름"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input class="join" type="password" id="join_pw" name="password" placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input class="join" type="password" id="join_pw_check" placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td><input class="join" type="text" id="join_birth" name="birth" placeholder="1999/01/01"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input class="join" type="tel" id="join_tel" name="tel" placeholder="01000000000" pattern="(010)\d{3,4}\d{4}"></td>
                </tr>
            </table>
            
            <input type="button" class="btn_join" value="완료" onclick="join()">
            <input type="reset" class="btn_join right" value="초기화">
        </form>
    </div>
</body>
</html>