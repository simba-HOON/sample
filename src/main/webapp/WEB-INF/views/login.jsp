<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>시스템 로그인 페이지</title>

<!-- Custom fonts for this template-->
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/login.css" rel="stylesheet">

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>

</head>

<body>

	<div class="login">
		<h1>시내엔들 시스템</h1>
		<form id="login_form" method="post">
			<input type="text" id="name_input" name="mng_name" placeholder="관리자 이름" required="required" /> 
			<input type="password" id="password_input" name="mng_password" placeholder="비밀번호" required="required" />
			<input type="button" id="login_button" class="btn btn-primary btn-block btn-large" value="로그인" />
			<c:if test = "${result == 0 }">
				<div class = "login_warn">관리자 또는 비밀번호를 확인 하세요</div>
			</c:if>			
		</form>
		<hr>
		<div>
			<a style="text-align:center; color:grey;" href="/join">관리자 신규 등록</a>
		</div>
	</div>
	

<script>
    /* 로그인 버튼 클릭 메서드 */
    $("#login_button").click(function(){
        //alert("로그인버튼 작동확인");
        
    	/* 로그인 POST 메서드 서버 요청 */
        $("#login_form").attr("action", "/login.do");
        $("#login_form").submit();
    	
    });
</script>	
	
	
</body>

</html>