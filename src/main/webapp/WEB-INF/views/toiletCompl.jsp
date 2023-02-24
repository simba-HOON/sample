<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>화장실 민원 정보 목록</title>

<!-- Custom fonts for this template -->
<link href="/resources/css/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/resources/css/vendor/datatables/dataTables.bootstrap4.min.css"	rel="stylesheet">


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


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<a href="/toiletCompl">
					<h1 class="h3 mb-2 text-gray-800">화장실 민원 관리</h1>
					</a>
					<p class="mb-4">
						현재 등록되어 있는 화장실 민원 현황을 나타내고 있습니다.&nbsp;&nbsp;&nbsp;&nbsp;또한, 민원인 이름으로 "찾기"를 통해 해당되는 화장실 민원을 검색할 수 있습니다.
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">화장실 민원 발생현황 테이블</h6>
						</div>
						
						<div class="card-body">
							<div class="col-sm-12 col-md-6">
									<form id="searchForm2" action="/toiletCompl" method="get">
									<label class="search_input">찾기 :
										<input type="text" name="keyword2" value='<c:out value="${pageMaker2.complCriteria.keyword2}"></c:out>'>
                    					<input type="hidden" name="pageNum2" value='<c:out value="${pageMaker2.complCriteria.pageNum2}"></c:out>'>
                    					<input type="hidden" name="amount2" value='${pageMaker2.complCriteria.amount2}'>
                    					<button class='btn search_btn'>검 색</button>												
                    				</label>
									</form>
							</div>
						
							<div>							
								<table class="table table-bordered" width="100%">
									<thead>
										<tr>
											<th width="10%">민원 발생 화장실</th>
											<th width="10%">민원 카테고리</th>
											<th width="50%">민원 내용</th>
											<th width="10%">민원인 이름</th>
											<th width="10%">민원인 연락처</th>
											<th width="10%">민원 등록일자</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>민원 발생 화장실</th>
											<th>민원 카테고리</th>
											<th>민원 내용</th>
											<th>민원인이름</th>
											<th>민원인 연락처</th>
											<th>민원 등록일자</th>
										</tr>
									</tfoot>
									
									<tbody>
										<c:forEach items="${list2}" var="list2">
										<tr>
											<td><c:out value="${list2.compl_toilet_tag_id}"></c:out></td>
											<td><c:out value="${list2.compl_category}"></c:out></td>
											<td>
												<a class="move" href='<c:out value="${list2.compl_toilet_tag_id}"/>'>
													<c:out value="${list2.compl_content}"></c:out>
												</a>
											</td>
											<td><c:out value="${list2.complt_name}"></c:out></td>
											<td><c:out value="${list2.complt_phone}"></c:out></td>
											<td><fmt:formatDate value="${list2.complt_compl_cr_dt}" pattern="yyyy-MM-dd"/></td>
										</tr>		
										</c:forEach>								
									</tbody>
								</table>
							</div>						
						</div>					
						<div class="row">
							<div class="col-sm-12 col-md-5">
							<div class="dataTables_info">
								<a href="/toiletComplExcelDown" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
								<i class="fas fa-download fa-sm text-white-50"></i>엑셀파일 다운로드</a>										</div>
						</div>
						
						<div class="col-sm-12 col-md-7">											
							<ul class="pageMaker">
							
								<c:if test="${pageMaker2.prev2}">
									<li class="pageMaker_btn prev2">
										<a href="${pageMaker2.pageStart2 - 1}">이전</a>
									</li>
								</c:if>
								
								<c:forEach begin="${pageMaker2.pageStart2}" end="${pageMaker2.pageEnd2}" var="num">
									<li class="pageMaker_btn ${pageMaker2.complCriteria.pageNum2==num ? "active":""}">
										<a href="${num}">${num}</a>
									</li>
								</c:forEach>
								
								<c:if test="${pageMaker2.next2}">
									<li class="pageMaker_btn next2">
										<a href="${pageMaker2.pageEnd2 + 1}">다음</a>
									</li>
								</c:if>
							</ul>
											
											
						<form id="moveForm2" action="/toiletCompl" method="get">
							<input type="hidden" name="pageNum2" value="${pageMaker2.complCriteria.pageNum2}">
							<input type="hidden" name="amount2" value="${pageMaker2.complCriteria.amount2}">
							<input type="hidden" name="keyword2" value="${pageMaker2.complCriteria.keyword2}">											
						</form>
											
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
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/css/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/css/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/css/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/css/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/resources/css/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/css/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/css/js/demo/datatables-demo.js"></script>
	
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
		let moveForm2 = $('#moveForm2');
		let searchForm2 = $('#searchForm2');
		//페이지 이동버튼
		$(".pageMaker_btn a").on("click",function(e){
			e.preventDefault();
			moveForm2.find("input[name='pageNum2']").val($(this).attr("href"));
			moveForm2.submit();
		})
		
		//검색 버튼
		$("#searchForm2 button").on("click", function(e){	
		e.preventDefault();		
		/* 검색 키워드 유효성 검사 */
		if(!searchForm2.find("input[name='keyword2']").val()){
			alert("키워드를 입력하십시오");
			return false;
		}		
		searchForm2.find("input[name='pageNum2']").val("1");		
		searchForm2.submit();		
		});
		
		//상세페이지
		$(".move").on("click", function(e){
			
			e.preventDefault();
			
			moveForm2.append("<input type='hidden' name='compl_toilet_tag_id' value='"+$(this).attr("href")+"'>");
			moveForm2.attr("action", "/toiletComplDetail");
			moveForm2.submit();
			
		});
		
	</script>
	
	

</body>
</html>