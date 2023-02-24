<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>공원 업체 상세 정보</title>

<!-- Custom fonts for this template -->
<link href="/resources/css/vendor/fontawesome-free/css/all.min.css"	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/resources/css/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/details/detailStyle.css">
<link rel="stylesheet" href="resources/css/details/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/details/responsive.css">
<link rel="stylesheet" href="resources/css/details/jquery.mCustomScrollbar.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />

</head>


<body id="page-top">
	<div id="wrapper">
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<a class="h1 mb-2" href="/main">
						<img src="/resources/css/img/sinaedle.png" width="250" height="55"/>
					</a>
					<a style="position: relative; left:78%;" href="/main">
						<img src="resources/css/img/home.png">
					</a>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div> <!-- Nav Item - User Information -->
						
						
						<li class="nav-item dropdown no-arrow">
						<c:if test="${mngVO !=null}">
								<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <span
									class="mr-2 d-none d-lg-inline text-gray-600 small">${mngVO.mng_name}</span>
									<img class="img-profile rounded-circle"	src="resources/css/img/undraw_profile.svg">
								</a>
							</c:if> 
							<!-- Dropdown - User Information -->
							
							<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
							
								<div class="dropdown-divider"></div>
								<a id="push_logout" class="dropdown-item" href="/logout"> 
								<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃
								</a>
							</div>
						</li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<div id="request" class="contact">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 padding-left1">
								<div class="contact">
									<div class="titlepage">
										<h2>공원 민원 상세정보</h2>
									</div>
									<form class="moveDetailForm" method="get">
										<div class="row">
											<div class="col-sm-12">
												<label style="font-size:20px;">사업자 번호</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.cor_reg_no}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">업체 명</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.company_nm}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">대표자 명</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.president_nm}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">업종</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.company_busi}'/>">
											</div>
										</div>
									</form>
									<form class="moveDetailForm2" method="get">
										<div class="row">
											<div class="col-sm-12">
												<label style="font-size:20px;">업체 아이디</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.company_id}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">업체 전화번호</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.company_tel}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">업체 주소</label>
												<input style="font-size:20px;" class="contactus" readonly="readonly" value="<c:out value='${parkCompanyDetail.company_addr}'/>">
											</div>
											<div class="col-sm-12">
												<label style="font-size:20px;">업체 등록일자</label>
												<input type="date" style="font-size:20px;" class="contactus" readonly="readonly" value='<fmt:formatDate value="${parkCompanyDetail.sys_cr_dt}" pattern="yyyy-MM-dd"/>'>
											</div>
										</div>
									</form>
							
									<div class="col-sm-12">
												<a type="button" class="backBtn" href='/parkCompany'>공원 업체 목록</a>				
									</div>
								</div>
							</div>
					
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 padding-right1">	
													
							<!-- 지도와 슬라이드 -->
						
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=506d40c65df161b344374dc9e0f6690a"></script>
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=506d40c65df161b344374dc9e0f6690a&libraries=LIBRARY"></script>
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=506d40c65df161b344374dc9e0f6690a&libraries=services"></script>
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=506d40c65df161b344374dc9e0f6690a&libraries=services,clusterer,drawing"></script>					 		 
							
								<div class="slider">
        							<div id="map" style="width:950px;height:677px;">
	        							<script>										
		        							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		        							    mapOption = { 
	    	    							        center: new kakao.maps.LatLng(37.450701, 127.400000), // 지도의 중심좌표
	        								        level: 3 // 지도의 확대 레벨
	    	    							    };
		
			        						var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		    	    						// 마커가 표시될 위치입니다 
	    		    						var markerPosition  = new kakao.maps.LatLng(37.450701, 127.400000); 
		
		        							// 마커를 생성합니다
	    	    							var marker = new kakao.maps.Marker({
	        								    position: markerPosition
	    	    							});
		
			        						// 마커가 지도 위에 표시되도록 설정합니다
		    	    						marker.setMap(map);										
										</script>
        							</div>
        							<div><img src="/resources/css/assets/img/portfolio-11.jpg" style="cursor:pointer" onclick="window.open(this.src)"></div>
        							<div><img src="/resources/css/assets/img/portfolio-12.jpg" style="cursor:pointer" onclick="window.open(this.src)"></div>   		      							
								</div>														
							</div>																				
						</div>
					</div>
				</div>
				<!-- end -->

			</div>
			<footer class="sticky-footer bg-white">
				<div>
					<div class="copyright text-center my-auto">
						<span>Copyright © 시내엔들 2022</span>
					</div>
				</div>
			</footer>		
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="resources/css/vendor/jquery/jquery.min.js"></script>
	<script src="resources/css/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/css/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/css/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="resources/css/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="resources/css/vendor/datatables/dataTables.bootstrap4.min.js"></script>

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

	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script type="text/javascript">
		$(function(){
		    $('.slider').slick({
		        slide: 'div',        
		        slidesToShow : 1,    
		        infinite : true,        
		        dots : true,         
		        arrows : true,         
		        prevArrow : "<button type='button' class='slick-prev'>Previous</button>",
		        nextArrow : "<button type='button' class='slick-next'>Next</button>",
		        draggable : false     
		    });
	 	 });
	</script>


</body>
</html>