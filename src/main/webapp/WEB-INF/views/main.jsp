<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>가로수 관리 시스템</title>

<!-- Custom fonts for this template-->
<link href="resources/css/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

	
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<a class="h1 mb-2" href="/main">
						<img src="/resources/css/img/sinaedle.png" width="250" height="55"/>
					</a>				
					<a style="position:relative; left:78%;" href="/main">
						<img src="resources/css/img/home.png">
					</a>
					
					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">
						<li class="topbar-divider d-none d-sm-block"></li>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
							<c:if test="${mngVO !=null}">
								<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
									<span class="mr-2 d-none d-lg-inline text-gray-600 small">${mngVO.mng_name}</span>
									<img class="img-profile rounded-circle"	src="resources/css/img/undraw_profile.svg">
								</a>
							</c:if>
							
							<!-- Dropdown - User Information -->
							<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"	aria-labelledby="userDropdown">
								<div class="dropdown-divider"></div>
									<a id="push_logout" class="dropdown-item" href="/logout"> 
										<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>Logout
									</a>
							</div>
						</li>
					</ul>
				</nav>
				<!-- End of Topbar -->


			<!-- Page Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800"></h1>
					
					</div>
				
				
				<!-- 이곳에 추가 -->
				
					<div class="max-content">
					<div class="org-chart cf">
						<div class="board">
							<div class="h-line"></div>
							<ul class="columnOne">
								<li>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/sinaedle1.png'); background-position: center; background-size:cover; "  class="lvl-b"></span> 
										<span style="font-size:55px" class="details">시내엔들 전체 관리 시스템입니다</span>
									</div>
								</li>
							</ul>
							<ul class="columnThree">
								<li>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/1.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/grsBsc1'">가로수 관리 현황</span>									
									</div>																	
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/2.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/grsCompl'">가로수 민원 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/3.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/grsCompany'">가로수 업체 현황</span>
									</div>
								</li>
								<li>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/4.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/parkBsc'">공원 관리 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/2.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/parkCompl'">공원 민원 현황</span>
									</div>
										<div class="org-single">
										<span style="background-image:url('/resources/css/img/3.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer;" class="details" onclick="location.href='/parkCompany'">공원 업체 현황</span>
									</div>
								</li>
								<li>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/5.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/toiletBsc'">화장실 관리 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/2.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/toiletCompl'">화장실 민원 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/3.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/toiletCompany'">화장실 업체 현황</span>
									</div>
								</li>
								<li>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/6.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 

										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/submain'">시설 관리 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/2.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/submain'">시설 민원 현황</span>
									</div>
									<div class="org-single">
										<span style="background-image:url('/resources/css/img/3.png'); background-repeat:no-repeat; background-position: center;" class="lvl-b"></span> 
										<span style="font-size:25px; cursor:pointer" class="details" onclick="location.href='/submain'">시설 업체 현황</span>
									</div>							
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span style="font-size:20px;">사용에 대한 주의사항 및 추가 알림에 대한 문구 삽입 부분</span></br></br>
						<span style="font-size:15px;">Copyright © 시내엔들 2022</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fas fa-angle-up"></i>
	</a>


	<!-- Bootstrap core JavaScript-->
	<script src="resources/css/vendor/jquery/jquery.min.js"></script>
	<script src="resources/css/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/css/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/css/js/sb-admin-2.min.js"></script>

	<!-- push_logout -->
	<script type="text/javascript">
	$("#push_logout").click(function(){
		
		$.ajax({
			type:"POST",
			url:"/logout",
			success:function(data){
				alert("로그아웃 되었습니다");
				document.location.href="/";
			}
		}); //ajax
	});
	</script>
</body>

</html>