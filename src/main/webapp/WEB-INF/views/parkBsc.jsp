<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>가로수 기본정보</title>

<!-- Custom fonts for this template -->
<link href="/resources/css/vendor/fontawesome-free/css/all.min.css"	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/resources/css/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

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

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<!-- Topbar Search -->
					<a class="h1 mb-2" href="/main">
						<img src="/resources/css/img/sinaedle.png" width="250" height="55"/>
					</a>
					<a style="position: relative; left:78%;" href="/main">
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
								<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃
								</a>
							</div>
						</li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<a href="/parkBsc">
					<h1 class="h3 mb-2 text-gray-800">공원 관리현황</h1>
					</a>
					<p class="mb-4">
						현재 등록되어 있는 공원 현황을 나타내고 있습니다.&nbsp;&nbsp;&nbsp;&nbsp;또한, 공원 이름으로 "찾기"를 통해 해당되는 가로수를 검색할 수 있습니다.
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">전체 공원 테이블</h6>
						</div>
						<div class="card-body">
									<div class="row">
										
										<div class="col-sm-12 col-md-6">
												<form id="searchForm" action="/parkBsc" method="get">
												<label class="search_input">찾기 :
													<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
                    								<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }"></c:out>'>
                    								<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
                    								<button class='btn search_btn'>검 색</button>												
                    							</label>
												</form>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable" width="100%">
												<thead>
													<tr>
														<th width="20%">태그 ID</th>
														<th width="20%">공원 이름</th>
														<th width="10%">시행처</th>
														<th width="10%">작업 회사</th>
														<th width="20%">작업자</th>
														<th width="20%">기본정보 생성일자</th>
													</tr>
												</thead>												
												<tfoot>
													<tr>
														<th>태그 ID</th>
														<th>공원 이름</th>
														<th>시행처</th>
														<th>작업 회사</th>
														<th>작업자</th>
														<th>기본정보 생성일자</th>
													</tr>
												</tfoot>
												
												<c:forEach items="${list}" var="list">
												<tbody>
													<tr class="odd">
														<td class="sorting_1"><c:out value="${list.park_tag_id}"></c:out></td>
														<td class="sorting_1">
															<a class="move" href='<c:out value="${list.park_tag_id}"/>'>
																<c:out value="${list.park_nm}"></c:out>
															</a>
														</td>														
														<td class="sorting_1"><c:out value="${list.park_owner}"></c:out></td>														
														<td class="sorting_1"><c:out value="${list.park_impl_cp_id}"></c:out></td>
														<td class="sorting_1"><c:out value="${list.park_wk_cp_id}"></c:out></td>
														<td class="sorting_1"><fmt:formatDate value="${list.park_bsc_info_cr_dt}" pattern="yyyy-MM-dd"/></td>
													</tr>
												</tbody>														
												</c:forEach>														
											</table>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-12 col-md-5">
										<div class="dataTables_info">
											<a href="/parkBscExcelDown" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
											<i class="fas fa-download fa-sm text-white-50"></i>엑셀파일 다운로드</a>										</div>
									</div>
										
										<div class="col-sm-12 col-md-7">											
												<ul class="pageMaker">
												
													<c:if test="${pageMaker.prev}">
														<li class="pageMaker_btn prev">
															<a href="${pageMaker.pageStart - 1}">이전</a>
														</li>
													</c:if>
													
													<c:forEach begin="${pageMaker.pageStart}" end="${pageMaker.pageEnd}" var="num">
														<li class="pageMaker_btn ${pageMaker.cri.pageNum==num ? "active":""}">
															<a href="${num}">${num}</a>
														</li>
													</c:forEach>
													
													<c:if test="${pageMaker.next}">
														<li class="pageMaker_btn next">
															<a href="${pageMaker.pageEnd + 1}">다음</a>
														</li>
													</c:if>
												</ul>											
											
											<form id="moveForm" action="/parkBsc" method="get">
												<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
												<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
												<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">											
											</form>
											
										</div>
									</div>
							
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->


			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © 시내엔들 2022</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
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


	<script type="text/javascript">
		let moveForm = $('#moveForm');
		let searchForm = $('#searchForm');
		
		//페이지 이동버튼
		$(".pageMaker_btn a").on("click",function(e){
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.submit();
		});
		
		//검색 버튼
		$("#searchForm button").on("click", function(e){	
		e.preventDefault();		
		/* 검색 키워드 유효성 검사 */
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하십시오");
			return false;
		}		
		searchForm.find("input[name='pageNum']").val("1");		
		searchForm.submit();		
		});
		
		//기본 상페페이지 이름 클릭 
		$(".move").on("click", function(e){
			
			e.preventDefault();
			
			moveForm.append("<input type='hidden' name='park_tag_id' value='"+$(this).attr("href")+"'>");
			moveForm.attr("action", "/parkBscDetail");
			moveForm.submit();
			
		});
	</script>


</body>
</html>