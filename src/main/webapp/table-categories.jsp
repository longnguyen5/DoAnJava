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
	function doDelete(categoryId) {
		if (confirm("Bạn có chắc chắn xóa Danh mục với ID = " + categoryId)) {
			window.location = "DeleteCategoryServlet?categoryId=" + categoryId;
		}
	}
</script>
	
</head>

<body class="g-sidenav-show  bg-gray-100">
	<aside
		class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 "
		id="sidenav-main">
		<div class="sidenav-header">
			<i
				class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
				aria-hidden="true" id="iconSidenav"></i> <a class="navbar-brand m-0"
				href="#"
				target="_blank"> <span class="ms-1 font-weight-bold">Quản
					lý hệ thống</span>
			</a>
		</div>
		<hr class="horizontal dark mt-0">
		<div class="collapse navbar-collapse  w-auto  max-height-vh-100 h-100"
			id="sidenav-collapse-main">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link  active"
					href="CategoryServlet">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg width="12px" height="12px" viewBox="0 0 45 40" version="1.1"
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink">
								<title>shop </title>
								<g stroke="none" stroke-width="1" fill="none"
									fill-rule="evenodd">
									<g transform="translate(-1716.000000, -439.000000)"
									fill="#FFFFFF" fill-rule="nonzero">
										<g transform="translate(1716.000000, 291.000000)">
											<g transform="translate(0.000000, 148.000000)">
												<path class="color-background opacity-6"
									d="M46.7199583,10.7414583 L40.8449583,0.949791667 C40.4909749,0.360605034 39.8540131,0 39.1666667,0 L7.83333333,0 C7.1459869,0 6.50902508,0.360605034 6.15504167,0.949791667 L0.280041667,10.7414583 C0.0969176761,11.0460037 -1.23209662e-05,11.3946378 -1.23209662e-05,11.75 C-0.00758042603,16.0663731 3.48367543,19.5725301 7.80004167,19.5833333 L7.81570833,19.5833333 C9.75003686,19.5882688 11.6168794,18.8726691 13.0522917,17.5760417 C16.0171492,20.2556967 20.5292675,20.2556967 23.494125,17.5760417 C26.4604562,20.2616016 30.9794188,20.2616016 33.94575,17.5760417 C36.2421905,19.6477597 39.5441143,20.1708521 42.3684437,18.9103691 C45.1927731,17.649886 47.0084685,14.8428276 47.0000295,11.75 C47.0000295,11.3946378 46.9030823,11.0460037 46.7199583,10.7414583 Z">
												</path>
												<path class="color-background"
									d="M39.198,22.4912623 C37.3776246,22.4928106 35.5817531,22.0149171 33.951625,21.0951667 L33.92225,21.1107282 C31.1430221,22.6838032 27.9255001,22.9318916 24.9844167,21.7998837 C24.4750389,21.605469 23.9777983,21.3722567 23.4960833,21.1018359 L23.4745417,21.1129513 C20.6961809,22.6871153 17.4786145,22.9344611 14.5386667,21.7998837 C14.029926,21.6054643 13.533337,21.3722507 13.0522917,21.1018359 C11.4250962,22.0190609 9.63246555,22.4947009 7.81570833,22.4912623 C7.16510551,22.4842162 6.51607673,22.4173045 5.875,22.2911849 L5.875,44.7220845 C5.875,45.9498589 6.7517757,46.9451667 7.83333333,46.9451667 L19.5833333,46.9451667 L19.5833333,33.6066734 L27.4166667,33.6066734 L27.4166667,46.9451667 L39.1666667,46.9451667 C40.2482243,46.9451667 41.125,45.9498589 41.125,44.7220845 L41.125,22.2822926 C40.4887822,22.4116582 39.8442868,22.4815492 39.198,22.4912623 Z">
												</path>
											</g>
										</g>
									</g>
								</g>
							</svg>
						</div> <span class="nav-link-text ms-1">Quản lý danh mục</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  "
					href="table-employees.jsp">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg width="12px" height="12px" viewBox="0 0 42 42" version="1.1"
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink">
								<title>office</title>
								<g stroke="none" stroke-width="1" fill="none"
									fill-rule="evenodd">
									<g transform="translate(-1869.000000, -293.000000)"
									fill="#FFFFFF" fill-rule="nonzero">
										<g transform="translate(1716.000000, 291.000000)">
											<g id="office" transform="translate(153.000000, 2.000000)">
												<path class="color-background opacity-6"
									d="M12.25,17.5 L8.75,17.5 L8.75,1.75 C8.75,0.78225 9.53225,0 10.5,0 L31.5,0 C32.46775,0 33.25,0.78225 33.25,1.75 L33.25,12.25 L29.75,12.25 L29.75,3.5 L12.25,3.5 L12.25,17.5 Z">
												</path>
												<path class="color-background"
									d="M40.25,14 L24.5,14 C23.53225,14 22.75,14.78225 22.75,15.75 L22.75,38.5 L19.25,38.5 L19.25,22.75 C19.25,21.78225 18.46775,21 17.5,21 L1.75,21 C0.78225,21 0,21.78225 0,22.75 L0,40.25 C0,41.21775 0.78225,42 1.75,42 L40.25,42 C41.21775,42 42,41.21775 42,40.25 L42,15.75 C42,14.78225 41.21775,14 40.25,14 Z M12.25,36.75 L7,36.75 L7,33.25 L12.25,33.25 L12.25,36.75 Z M12.25,29.75 L7,29.75 L7,26.25 L12.25,26.25 L12.25,29.75 Z M35,36.75 L29.75,36.75 L29.75,33.25 L35,33.25 L35,36.75 Z M35,29.75 L29.75,29.75 L29.75,26.25 L35,26.25 L35,29.75 Z M35,22.75 L29.75,22.75 L29.75,19.25 L35,19.25 L35,22.75 Z">
												</path>
											</g>
										</g>
									</g>
								</g>
							</svg>
						</div> <span class="nav-link-text ms-1">Quản lý nhân viên</span>
				</a></li>
				<li class="nav-item"><a class="nav-link  "
					href="table-manus.jsp">
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
							<h5>Danh sách danh mục sản phẩm</h5>
						</div>
						<div class="card-body px-0 pt-0 pb-2">
								<p align="center"><a href="addCategory.jsp"
													class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Delete category">
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
												Đường dẫn</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Trạng thái hiển thị</th>
											<th class="text-secondary opacity-7"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="category" items="${data}">
											<tr>
												<td>
													<div class="d-flex px-2 py-1">
														<div class="d-flex flex-column justify-content-center">
															<h6 class="mb-0 text-sm">${category.categoryName}</h6>
															<p class="text-xs text-secondary mb-0">ID:${category.categoryId}</p>
														</div>
													</div>
												</td>
												<td>
													<p class="text-xs font-weight-bold mb-0">${category.link}</p>
												</td>
												<td class="align-middle text-center text-sm"><span
													class="badge badge-sm ${category.status == 1 ? 'bg-gradient-success' : 'bg-gradient-danger'}">
														${category.status == 1 ? 'CÓ' : 'KHÔNG'} </span></td>
												<td class="align-middle"><a href="UpdateCategoryServlet?categoryId=${category.categoryId}"
													class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit category">
														Sửa </a> <a href="#"
													class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Delete category" onclick="doDelete('${category.categoryId}')">
														Xóa </a></td>
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
	<!--   Core JS Files   -->
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/core/bootstrap.min.js"></script>
	<script src="../assets/js/plugins/perfect-scrollbar.min.js"></script>
	<script src="../assets/js/plugins/smooth-scrollbar.min.js"></script>
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
	<!-- Github buttons -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="../assets/js/soft-ui-dashboard.min.js?v=1.0.3"></script>
</body>

</html>