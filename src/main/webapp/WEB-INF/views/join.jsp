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
    <script>
    	var users = new Array();
    	<c:forEach items="${users}" var="user">
    		users.push("${user.id}");
    	</c:forEach>
    	
    	function check_id() {
    		var id = document.getElementById('join_id').value.trim();
    		document.getElementById('check').innerHTML = "";
    		for(var i in users) {
    			var uname = users[i];
    			if(id == uname) {
    				document.getElementById('check').innerHTML = "사용할 수 없는 아이디 입니다.";
    				break;
    			}
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
                    <td><input class="join" type="text" id="join_id" name="id" placeholder="ID" onkeypress="check_id()" required></td>
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
                    <td><input class="join" type="tel" id="join_tel" name="tel" placeholder="01000000000"></td>
                </tr>
            </table>
            
            <input type="button" class="btn_join" value="완료" onclick="join()">
            <input type="reset" class="btn_join right" value="초기화">
        </form>
    </div>
</body>
</html>