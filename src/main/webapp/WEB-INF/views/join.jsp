<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>

<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	background:
		url(http://wrbbradio.org/wp-content/uploads/2016/10/grey-background-07.jpg)
		no-repeat center fixed;
	background-size: cover;
}

.container {
	background: #2d3e3f;
	width: 350px;
	height: 400px;
	padding-bottom: 20px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	margin: auto;
	padding: 70px 50px 20px 50px;
}

.fl {
	float: left;
	width: 110px;
	line-height: 35px;
}

.fontLabel {
	color: white;
}

.fr {
	float: right;
}

.clr {
	clear: both;
}

.box {
	width: 360px;
	height: 35px;
	margin-top: 10px;
	font-family: verdana;
	font-size: 12px;
}

.textBox {
	height: 35px;
	width: 190px;
	border: none;
	padding-left: 20px;
}

.new {
	float: left;
}

.iconBox {
	height: 35px;
	width: 40px;
	line-height: 38px;
	text-align: center;
	background: #ff6600;
}

.radio {
	color: white;
	background: #2d3e3f;
	line-height: 38px;
}

.terms {
	line-height: 35px;
	text-align: center;
	background: #2d3e3f;
	color: white;
}

.submit {
	float: right;
	border: none;
	color: white;
	width: 110px;
	height: 35px;
	background: #ff6600;
	text-transform: uppercase;
	cursor: pointer;
}

::-webkit-input-placeholder {
	/* Chrome/Opera/Safari */
	
}
</style>

<title>관리자 추가등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

	<!-- Body of Form starts -->
	<div class="container">
		<form method="post" autocomplete="on">
			<!--관리자 name-->
			<div class="box">
				<label for="firstName" class="fl fontLabel"> 관리자 이름: </label>
				<div class="new iconBox">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" name="mng_name" placeholder="관리자 이름" class="textBox" required>
				</div>
				
				<div class="clr"></div>
			</div>
			<!--관리자 name-->


			<!---Password------>
			<div class="box">
				<label for="password" class="fl fontLabel"> 비밀번호: </label>
				<div class="fl iconBox">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="Password" required name="mng_password"	placeholder="비밀번호" class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!---Password---->


			<!---Phone No.------>
			<div class="box">
				<label for="phone" class="fl fontLabel"> 관리자 연락처: </label>
				<div class="fl iconBox">
					<i class="fa fa-phone-square" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" oninput="this.value=this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required name="mng_phone" maxlength="12" placeholder="하이픈(-)은 빼고 입력 해주세요" class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!---Phone No.---->

			<!---grade----->
			<div class="box radio">
				<label for="mng_grade" class="fl fontLabel"> 관리자 등급: </label> 
				<input type="radio" name="mng_grade" value="1" required> 국장 &nbsp; &nbsp; &nbsp; &nbsp; 
				<input type="radio" name="mng_grade" value="2" required> 과장 &nbsp; &nbsp; &nbsp; &nbsp; 
				<input type="radio" name="mng_grade" value="3" required> 부장
			</div>
			<!---Grade--->


			<!---짧은 코멘트---->
			<div class="box">
				<label for="mng_comment" class="fl fontLabel"> 짧은 코멘트: </label>
				<div class="fl iconBox">
					<i class="fa fa-envelope" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" required name="mng_comment" placeholder="추가 코멘트" class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!--짧은 코멘트----->
			
			
			<!--Terms and Conditions------>
			<div class="box terms">
				<input type="checkbox" name="Terms" required> &nbsp; 위의 내용이 정확한지 확인했습니다.
			</div>
			<!--Terms and Conditions------>

			<!---Submit Button------>
			<div class="box" style="background: #2d3e3f">
				<input type="Submit" name="Submit" class="submit" value="SUBMIT">
			</div>
			<!---Submit Button----->
			
			
		</form>
	</div>
	<!--Body of Form ends--->
</body>
