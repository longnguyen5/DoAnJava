<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Hệ thống quản lý bánh khúc</title>
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,600,700"
	rel="stylesheet" />
<!-- Nucleo Icons -->
<link href="./css/nucleo-icons.css" rel="stylesheet" />
<link href="./css/nucleo-svg.css" rel="stylesheet" />
<!-- Font Awesome Icons -->
<script src="https://kit.fontawesome.com/42d5adcbca.js"
	crossorigin="anonymous"></script>
<link href="./css/nucleo-svg.css" rel="stylesheet" />
<!-- CSS Files -->
<link id="pagestyle" href="./css/soft-ui-dashboard.css?v=1.0.3"
	rel="stylesheet" />

<script type="text/javascript">
	function doDelete(coverId) {
		if (confirm("Bạn có chắc chắn xóa Cover với ID = " + coverId)) {
			window.location = "DeleteCoverServlet?coverId=" + coverId;
		}
	}
</script>
	
</head>

<body class="g-sidenav-show bg-gray-100">
	<aside
		class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 "
		id="sidenav-main">
		<div class="sidenav-header">
			<i
				class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
				aria-hidden="true" id="iconSidenav"></i> <a class="navbar-brand m-0"
				href="HeaderServlet"
				target="_blank"> <span class="ms-1 font-weight-bold">Quản
					lý hệ thống</span>
			</a>
		</div>
		<hr class="horizontal dark mt-0">
		<div class="collapse navbar-collapse  w-auto  max-height-vh-100 h-100"
			id="sidenav-collapse-main">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link  "
					href="CategoryServlet">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>layers-3</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffff"></rect>
  <g fill="#3a416f">
    <path d="M15.685,4.423L9.816,1.333c-.511-.271-1.121-.27-1.631,0L2.315,4.423c-.494,.26-.801,.769-.801,1.327s.307,1.067,.801,1.327l5.869,3.09c.255,.135,.536,.203,.816,.203s.56-.067,.815-.202l5.87-3.091c.494-.26,.801-.769,.801-1.327s-.307-1.067-.801-1.327Z" fill="#3a416f"></path>
    <path d="M15.736,8.25c-.414,0-.75,.336-.75,.75l-5.87,3.091c-.072,.038-.158,.038-.232,0l-5.87-3.091c0-.414-.336-.75-.75-.75s-.75,.336-.75,.75c0,.559,.307,1.067,.801,1.327l5.869,3.09c.255,.135,.536,.203,.816,.203s.56-.067,.815-.202l5.87-3.091c.494-.26,.801-.769,.801-1.327,0-.414-.336-.75-.75-.75Z"></path>
    <path d="M15.736,11.5c-.414,0-.75,.336-.75,.75l-5.87,3.091c-.072,.038-.158,.038-.232,0l-5.87-3.091c0-.414-.336-.75-.75-.75s-.75,.336-.75,.75c0,.559,.307,1.067,.801,1.327l5.869,3.09c.255,.135,.536,.203,.816,.203s.56-.067,.815-.202l5.87-3.091c.494-.26,.801-.769,.801-1.327,0-.414-.336-.75-.75-.75Z"></path>
  </g>
</svg>
						</div> <span class="nav-link-text ms-1">Quản lý danh mục</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  "
					href="EmployeesServlet">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>users</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffffff"></rect>
  <g fill="#3a416f">
    <circle cx="5.75" cy="6.25" r="2.75" fill="#3a416f"></circle>
    <circle cx="12" cy="3.75" r="2.75"></circle>
    <path d="M17.196,11.098c-.811-2.152-2.899-3.598-5.196-3.598-1.417,0-2.752,.553-3.759,1.48,1.854,.709,3.385,2.169,4.109,4.089,.112,.296,.162,.603,.182,.91,1.211-.05,2.409-.26,3.565-.646,.456-.152,.834-.487,1.041-.919,.2-.42,.221-.888,.059-1.316Z"></path>
    <path d="M10.946,13.598c-.811-2.152-2.899-3.598-5.196-3.598S1.365,11.446,.554,13.598c-.162,.429-.141,.896,.059,1.316,.206,.432,.585,.767,1.041,.919,1.325,.442,2.704,.667,4.096,.667s2.771-.225,4.096-.667c.456-.152,.834-.487,1.041-.919,.2-.42,.221-.888,.059-1.316Z" fill="#3a416f"></path>
  </g>
</svg>
						</div> <span class="nav-link-text ms-1">Quản lý nhân viên</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  "
					href="ManusServlet">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg width="12px" height="12px" viewBox="0 0 43 36" version="1.1"
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink">
								<title>credit-card</title>
								<g stroke="none" stroke-width="1" fill="none"
									fill-rule="evenodd">
									<g transform="translate(-2169.000000, -745.000000)"
									fill="#FFFFFF" fill-rule="nonzero">
										<g transform="translate(1716.000000, 291.000000)">
											<g transform="translate(453.000000, 454.000000)">
												<path class="color-background opacity-6"
									d="M43,10.7482083 L43,3.58333333 C43,1.60354167 41.3964583,0 39.4166667,0 L3.58333333,0 C1.60354167,0 0,1.60354167 0,3.58333333 L0,10.7482083 L43,10.7482083 Z">
												</path>
												<path class="color-background"
									d="M0,16.125 L0,32.25 C0,34.2297917 1.60354167,35.8333333 3.58333333,35.8333333 L39.4166667,35.8333333 C41.3964583,35.8333333 43,34.2297917 43,32.25 L43,16.125 L0,16.125 Z M19.7083333,26.875 L7.16666667,26.875 L7.16666667,23.2916667 L19.7083333,23.2916667 L19.7083333,26.875 Z M35.8333333,26.875 L28.6666667,26.875 L28.6666667,23.2916667 L35.8333333,23.2916667 L35.8333333,26.875 Z">
												</path>
											</g>
										</g>
									</g>
								</g>
							</svg>
						</div> <span class="nav-link-text ms-1">Quản lý nhà cung cấp</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  "
					href="table-products.jsp">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>box</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffffff"></rect>
  <g fill="#3a416f">
    <path d="M13.25,5h-3.5v2.75c0,.414-.336,.75-.75,.75s-.75-.336-.75-.75v-2.75h-3.5c-1.517,0-2.75,1.233-2.75,2.75v5.5c0,1.517,1.233,2.75,2.75,2.75H13.25c1.517,0,2.75-1.233,2.75-2.75V7.75c0-1.517-1.233-2.75-2.75-2.75ZM7.25,13.5h-2c-.414,0-.75-.336-.75-.75s.336-.75,.75-.75h2c.414,0,.75,.336,.75,.75s-.336,.75-.75,.75Z" fill="#3a416f"></path>
    <path d="M8.25,1.5h-2.009c-1.052,0-1.996,.586-2.464,1.529l-.348,.703c.418-.138,.857-.231,1.321-.231h3.5V1.5Z"></path>
    <path d="M14.223,3.028c-.468-.942-1.412-1.528-2.464-1.528h-2.009V3.5h3.5c.464,0,.903,.093,1.322,.231l-.348-.703Z"></path>
  </g>
</svg>
						</div> <span class="nav-link-text ms-1">Quản lý sản phẩm</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  active"
					href="CoverServlet">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>sparkle-3</title>
  <g fill="#ffffff">
    <path d="M3.025,5.623c.068,.204,.26,.342,.475,.342s.406-.138,.475-.342l.421-1.263,1.263-.421c.204-.068,.342-.259,.342-.474s-.138-.406-.342-.474l-1.263-.421-.421-1.263c-.137-.408-.812-.408-.949,0l-.421,1.263-1.263,.421c-.204,.068-.342,.259-.342,.474s.138,.406,.342,.474l1.263,.421,.421,1.263Z"></path>
    <path d="M16.525,8.803l-4.535-1.793-1.793-4.535c-.227-.572-1.168-.572-1.395,0l-1.793,4.535-4.535,1.793c-.286,.113-.475,.39-.475,.697s.188,.584,.475,.697l4.535,1.793,1.793,4.535c.113,.286,.39,.474,.697,.474s.584-.188,.697-.474l1.793-4.535,4.535-1.793c.286-.113,.475-.39,.475-.697s-.188-.584-.475-.697Z" fill="#ffffff"></path>
  </g>
</svg>
						</div> <span class="nav-link-text ms-1">Site Cover</span>
				</a></li>
		</div>
	</aside>
	<main
		class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
		<!-- Navbar -->
		<nav
			class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl"
			id="navbarBlur" navbar-scroll="true">
			<div class="container-fluid py-1 px-3">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
						<li class="breadcrumb-item text-sm"><a
							class="opacity-5 text-dark" href="javascript:;">Bánh khúc</a></li>
						<li class="breadcrumb-item text-sm text-dark active"
							aria-current="page">Bảng</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">Bảng</h6>
				</nav>
				<div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4"
					id="navbar">
					<div class="ms-md-auto pe-md-3 d-flex align-items-center">
						<div class="input-group">
							<span class="input-group-text text-body"><i
								class="fas fa-search" aria-hidden="true"></i></span> <input type="text"
								class="form-control" placeholder="Type here...">
						</div>
					</div>
				
				</div>
			</div>
		</nav>
		<!-- End Navbar -->
		<div class="container-fluid py-4">
			<div class="row">
				<div class="col-12">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<h5>Danh sách Site Cover</h5>
						</div>
						<%@ include file="addCover.jsp" %>
						
						<div class="card-body px-0 pt-0 pb-2">
								<p align="center"><a href="#" id="openModalLink1"
													class="text-secondary font-weight-bold text-xs" 
													data-toggle="tooltip" data-original-title="Add category"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>square-plus</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffffff"></rect>
  <g fill="#8392be" stroke="#8392be">
    <rect x="2.75" y="2.75" width="12.5" height="12.5" rx="2" ry="2" fill="none" stroke="#8392be" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5"></rect>
    <line x1="5.75" y1="9" x2="12.25" y2="9" fill="none" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5"></line>
    <line x1="9" y1="5.75" x2="9" y2="12.25" fill="none" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5"></line>
  </g>
</svg>
														Thêm mới </a></p>
							<div class="table-responsive p-0">
								<table class="table align-items-center mb-0">
									<thead>
										<tr>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Tên danh mục</th>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
												Mô tả thêm</th>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
												Đường dẫn</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Trạng thái hiển thị</th>
											<th class="text-secondary opacity-7"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="c" items="${data}">
											<tr>
												<td>
													<div class="d-flex px-2 py-1">
														<div class="d-flex flex-column justify-content-center">
															<h6 class="mb-0 text-sm">${c.coverName}</h6>
															<p class="text-xs text-secondary mb-0">ID:${c.coverId}</p>
														</div>
													</div>
												</td>
												<td style="white-space: normal;">
													<p class="text-xs font-weight-bold mb-0">${c.description}</p>
												</td>
												<td>
													<p class="text-xs font-weight-bold mb-0">${c.link}</p>
												</td>
												<td class="align-middle text-center text-sm"><span
													class="badge badge-sm ${c.status == 1 ? 'bg-gradient-success' : 'bg-gradient-danger'}">
														${c.status == 1 ? 'CHỌN' : 'KHÔNG'} </span></td>
												<td class="align-middle"><a href="UpdateCoverServlet?coverId=${c.coverId}"
													class="text-secondary font-weight-bold text-xs" 
													data-toggle="tooltip" data-original-title="Edit cover">
														<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>pen-3</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffffff"></rect>
  <g fill="#8db762">
    <path d="M15.152,2.848c-.998-.998-2.74-.997-3.738,0L3.605,10.657c-.863,.864-1.401,3.406-1.593,4.459-.044,.242,.034,.491,.208,.665,.142,.142,.333,.22,.53,.22,.044,0,.089-.004,.134-.012,1.053-.191,3.595-.729,4.459-1.593l5.495-5.495,.217,.217c.487,.487,.487,1.28,0,1.768l-1.586,1.586c-.293,.293-.293,.768,0,1.061,.146,.146,.338,.22,.53,.22s.384-.073,.53-.22l1.586-1.586c1.072-1.072,1.072-2.816,0-3.889l-.217-.217,1.253-1.253c1.03-1.031,1.03-2.707,0-3.738Zm-1.061,2.677l-1.253,1.253-1.617-1.617,1.253-1.253c.216-.216,.503-.334,.809-.334s.592,.119,.808,.334c.445,.446,.445,1.171,0,1.617Z" fill="#8db762"></path>
  </g>
</svg></a> <a href="#"
													class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Delete category" onclick="doDelete('${c.coverId}')">
														<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>trash</title>
  <rect data-element="frame" x="0" y="0" width="16" height="16" rx="2" ry="2" stroke="none" fill="#ffffff"></rect>
  <g fill="#ff5f53">
    <path d="M15.25,3.5h-3.25v-.75c0-.965-.785-1.75-1.75-1.75h-2.5c-.965,0-1.75,.785-1.75,1.75v.75H2.75c-.414,0-.75,.336-.75,.75s.336,.75,.75,.75H15.25c.414,0,.75-.336,.75-.75s-.336-.75-.75-.75Zm-7.75-.75c0-.138,.112-.25,.25-.25h2.5c.138,0,.25,.112,.25,.25v.75h-3v-.75Z"></path>
    <path d="M13.5,6H4.5c-.206,0-.402,.084-.544,.234s-.216,.35-.205,.556l.4,7.604c.077,1.461,1.283,2.606,2.746,2.606h4.205c1.463,0,2.669-1.145,2.746-2.605l.4-7.605c.011-.206-.063-.406-.205-.556s-.338-.234-.544-.234Z" fill="#ff5f53"></path>
  </g>
</svg> </a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	</div>
	
<!-- 	<script>
    function showForm() {
        var form = document.getElementById('addForm');
        form.style.display = 'block';
    }

    function hideForm() {
        var form = document.getElementById('addForm');
        form.style.display = 'none';
    }
	</script> -->

	<script>
		// JavaScript để kích hoạt modal khi nút được nhấp
		document.getElementById('openModalLink1').addEventListener(
				'click',
				function() {
					// Kích hoạt modal1
					var myModal1 = new bootstrap.Modal(document
							.getElementById('staticBackdrop1'));
					myModal1.show();
				});
		
		  /* document.getElementById('openModalLink2').addEventListener('click', function() {
			    // Kích hoạt Modal 2
			    var myModal2 = new bootstrap.Modal(document.getElementById('staticBackdrop2'));
			    myModal2.show();
			  });
		  document.getElementById('saveButton').addEventListener('click', function (event) {
			    event.preventDefault();  // Ngăn chặn hành vi mặc định của nút submit

			    // Thu thập dữ liệu từ form
			    var formData = new FormData(document.getElementById('updateForm'));

			    // Gửi Ajax request đến UpdateCoverServlet
			    $.ajax({
			      type: 'POST',
			      url: 'UpdateCoverServlet',
			      data: formData,
			      processData: false,
			      contentType: false,
			      success: function(response) {
			    	  var result = JSON.parse(response);

			    	  if (result.success) {
			    	    // Đóng modal hoặc thực hiện các bước cần thiết
			    	    $('#staticBackdrop2').modal('hide');
			    	    // Ví dụ: Hiển thị thông báo thành công
			    	    alert(result.message);
			    	  } else {
			    	    // Xử lý trường hợp lỗi nếu cần
			    	    alert('Lỗi: ' + result.message);
			    	  }
			      },
			      error: function(error) {
			        console.log('Error:', error);
			      }
			    });
			  }); */
	</script>
	
	<!--   Core JS Files   -->
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/perfect-scrollbar.min.js"></script>
	<script src="./js/smooth-scrollbar.min.js"></script>
	<script>
		var win = navigator.platform.indexOf('Win') > -1;
		if (win && document.querySelector('#sidenav-scrollbar')) {
			var options = {
				damping : '0.5'
			}
			Scrollbar.init(document.querySelector('#sidenav-scrollbar'),
					options);
		}
	</script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Github buttons -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="./js/soft-ui-dashboard.min.js?v=1.0.3"></script>
</body>

</html>