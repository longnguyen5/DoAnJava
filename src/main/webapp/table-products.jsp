<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>
		Hệ thống quản lý bánh khúc
	</title>
	<!--     Fonts and icons     -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,600,700" rel="stylesheet" />
	<!-- Nucleo Icons -->
	<link href="./css/nucleo-icons.css" rel="stylesheet" />
	<link href="./css/nucleo-svg.css" rel="stylesheet" />
	<!-- Font Awesome Icons -->
	<script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
	<link href="./css/nucleo-svg.css" rel="stylesheet" />
	<!-- CSS Files -->
	<link id="pagestyle" href="./css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
</head>

<body class="g-sidenav-show  bg-gray-100">
	<aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 "
		id="sidenav-main">
		<div class="sidenav-header">
			<i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
				aria-hidden="true" id="iconSidenav"></i>
			<a class="navbar-brand m-0" href="https://demos.creative-tim.com/soft-ui-dashboard/pages/dashboard.html"
				target="_blank">
				<span class="ms-1 font-weight-bold">Quản lý hệ thống</span>
			</a>
		</div>
		<hr class="horizontal dark mt-0">
		<div class="collapse navbar-collapse  w-auto  max-height-vh-100 h-100" id="sidenav-collapse-main">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link  " href="CategoryServlet">
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
						</div>
						<span class="nav-link-text ms-1">Quản lý danh mục</span>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link " href="table-employees.jsp">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg width="12px" height="12px" viewBox="0 0 42 42" version="1.1"
								xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
								<title>office</title>
								<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
									<g transform="translate(-1869.000000, -293.000000)" fill="#FFFFFF"
										fill-rule="nonzero">
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
						</div>
						<span class="nav-link-text ms-1">Quản lý nhân viên</span>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link  " href="table-manus.jsp">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg width="12px" height="12px" viewBox="0 0 43 36" version="1.1"
								xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
								<title>credit-card</title>
								<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
									<g transform="translate(-2169.000000, -745.000000)" fill="#FFFFFF"
										fill-rule="nonzero">
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
						</div>
						<span class="nav-link-text ms-1">Quản lý nhà cung cấp</span>
					</a>
				</li>
				<li class="nav-item"><a class="nav-link  active"
					href="table-products.jsp">
						<div
							class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>box</title>
  <g fill="#ffffff">
    <path d="M13.25,5h-3.5v2.75c0,.414-.336,.75-.75,.75s-.75-.336-.75-.75v-2.75h-3.5c-1.517,0-2.75,1.233-2.75,2.75v5.5c0,1.517,1.233,2.75,2.75,2.75H13.25c1.517,0,2.75-1.233,2.75-2.75V7.75c0-1.517-1.233-2.75-2.75-2.75ZM7.25,13.5h-2c-.414,0-.75-.336-.75-.75s.336-.75,.75-.75h2c.414,0,.75,.336,.75,.75s-.336,.75-.75,.75Z" fill="#ffffff"></path>
    <path d="M8.25,1.5h-2.009c-1.052,0-1.996,.586-2.464,1.529l-.348,.703c.418-.138,.857-.231,1.321-.231h3.5V1.5Z"></path>
    <path d="M14.223,3.028c-.468-.942-1.412-1.528-2.464-1.528h-2.009V3.5h3.5c.464,0,.903,.093,1.322,.231l-.348-.703Z"></path>
  </g>
</svg>
						</div> <span class="nav-link-text ms-1">Quản lý sản phẩm</span>
				</a></li>
	</aside>
	<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
		<!-- Navbar -->
		<nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
			navbar-scroll="true">
			<div class="container-fluid py-1 px-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
						<li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Bánh khúc</a>
						</li>
						<li class="breadcrumb-item text-sm text-dark active" aria-current="page">Bảng</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">Bảng</h6>
				</nav>
				<div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
					<div class="ms-md-auto pe-md-3 d-flex align-items-center">
						<div class="input-group">
							<span class="input-group-text text-body"><i class="fas fa-search"
									aria-hidden="true"></i></span>
							<input type="text" class="form-control" placeholder="Type here...">
						</div>
					</div>
					<ul class="navbar-nav  justify-content-end">
						<li class="nav-item d-flex align-items-center">
							<a href="javascript:;" class="nav-link text-body font-weight-bold px-0">
								<i class="fa fa-user me-sm-1"></i>
								<span class="d-sm-inline d-none">Sign In</span>
							</a>
						</li>
						<li class="nav-item d-xl-none ps-3 d-flex align-items-center">
							<a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
								<div class="sidenav-toggler-inner">
									<i class="sidenav-toggler-line"></i>
									<i class="sidenav-toggler-line"></i>
									<i class="sidenav-toggler-line"></i>
								</div>
							</a>
						</li>
						<li class="nav-item px-3 d-flex align-items-center">
							<a href="javascript:;" class="nav-link text-body p-0">
								<i class="fa fa-cog fixed-plugin-button-nav cursor-pointer"></i>
							</a>
						</li>
						<li class="nav-item dropdown pe-2 d-flex align-items-center">
							<a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton"
								data-bs-toggle="dropdown" aria-expanded="false">
								<i class="fa fa-bell cursor-pointer"></i>
							</a>
							<ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4"
								aria-labelledby="dropdownMenuButton">
								<li class="mb-2">
									<a class="dropdown-item border-radius-md" href="javascript:;">
										<div class="d-flex py-1">
											<div class="my-auto">
												<img src="../assets/img/team-2.jpg" class="avatar avatar-sm  me-3 ">
											</div>
											<div class="d-flex flex-column justify-content-center">
												<h6 class="text-sm font-weight-normal mb-1">
													<span class="font-weight-bold">New message</span> from Laur
												</h6>
												<p class="text-xs text-secondary mb-0">
													<i class="fa fa-clock me-1"></i>
													13 minutes ago
												</p>
											</div>
										</div>
									</a>
								</li>
								<li class="mb-2">
									<a class="dropdown-item border-radius-md" href="javascript:;">
										<div class="d-flex py-1">
											<div class="my-auto">
												<img src="../assets/img/small-logos/logo-spotify.svg"
													class="avatar avatar-sm bg-gradient-dark  me-3 ">
											</div>
											<div class="d-flex flex-column justify-content-center">
												<h6 class="text-sm font-weight-normal mb-1">
													<span class="font-weight-bold">New album</span> by Travis Scott
												</h6>
												<p class="text-xs text-secondary mb-0">
													<i class="fa fa-clock me-1"></i>
													1 day
												</p>
											</div>
										</div>
									</a>
								</li>
								<li>
									<a class="dropdown-item border-radius-md" href="javascript:;">
										<div class="d-flex py-1">
											<div class="avatar avatar-sm bg-gradient-secondary  me-3  my-auto">
												<svg width="12px" height="12px" viewBox="0 0 43 36" version="1.1"
													xmlns="http://www.w3.org/2000/svg"
													xmlns:xlink="http://www.w3.org/1999/xlink">
													<title>credit-card</title>
													<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
														<g transform="translate(-2169.000000, -745.000000)"
															fill="#FFFFFF" fill-rule="nonzero">
															<g transform="translate(1716.000000, 291.000000)">
																<g transform="translate(453.000000, 454.000000)">
																	<path class="color-background"
																		d="M43,10.7482083 L43,3.58333333 C43,1.60354167 41.3964583,0 39.4166667,0 L3.58333333,0 C1.60354167,0 0,1.60354167 0,3.58333333 L0,10.7482083 L43,10.7482083 Z"
																		opacity="0.593633743"></path>
																	<path class="color-background"
																		d="M0,16.125 L0,32.25 C0,34.2297917 1.60354167,35.8333333 3.58333333,35.8333333 L39.4166667,35.8333333 C41.3964583,35.8333333 43,34.2297917 43,32.25 L43,16.125 L0,16.125 Z M19.7083333,26.875 L7.16666667,26.875 L7.16666667,23.2916667 L19.7083333,23.2916667 L19.7083333,26.875 Z M35.8333333,26.875 L28.6666667,26.875 L28.6666667,23.2916667 L35.8333333,23.2916667 L35.8333333,26.875 Z">
																	</path>
																</g>
															</g>
														</g>
													</g>
												</svg>
											</div>
											<div class="d-flex flex-column justify-content-center">
												<h6 class="text-sm font-weight-normal mb-1">
													Payment successfully completed
												</h6>
												<p class="text-xs text-secondary mb-0">
													<i class="fa fa-clock me-1"></i>
													2 days
												</p>
											</div>
										</div>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navbar -->
		<div class="container-fluid py-4">
			<div class="row">
				<div class="col-12">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<h6>Nhân viên</h6>
						</div>
						<div class="card-body px-0 pt-0 pb-2">
							<div class="table-responsive p-0">
								<table class="table align-items-center mb-0">
									<thead>
										<tr>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Tên nhân viên</th>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
												Vai trò</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Trạng thái</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Ngày vào</th>
											<th class="text-secondary opacity-7"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">John Michael</h6>
														<p class="text-xs text-secondary mb-0">john@creative-tim.com</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Manager</p>
												<p class="text-xs text-secondary mb-0">Organization</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-success">Online</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">23/04/18</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">Alexa Liras</h6>
														<p class="text-xs text-secondary mb-0">alexa@creative-tim.com
														</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Programator</p>
												<p class="text-xs text-secondary mb-0">Developer</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-danger">Offline</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">11/01/19</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">Laurent Perrier</h6>
														<p class="text-xs text-secondary mb-0">laurent@creative-tim.com
														</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Executive</p>
												<p class="text-xs text-secondary mb-0">Projects</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-success">Online</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">19/09/17</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">Michael Levi</h6>
														<p class="text-xs text-secondary mb-0">michael@creative-tim.com
														</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Programator</p>
												<p class="text-xs text-secondary mb-0">Developer</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-success">Online</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">24/12/08</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">Richard Gran</h6>
														<p class="text-xs text-secondary mb-0">richard@creative-tim.com
														</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Manager</p>
												<p class="text-xs text-secondary mb-0">Executive</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-secondary">Offline</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">04/10/21</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
													<div class="d-flex flex-column justify-content-center">
														<h6 class="mb-0 text-sm">Miriam Eric</h6>
														<p class="text-xs text-secondary mb-0">miriam@creative-tim.com
														</p>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">Programtor</p>
												<p class="text-xs text-secondary mb-0">Developer</p>
											</td>
											<td class="align-middle text-center text-sm">
												<span class="badge badge-sm bg-gradient-secondary">Offline</span>
											</td>
											<td class="align-middle text-center">
												<span class="text-secondary text-xs font-weight-bold">14/09/20</span>
											</td>
											<td class="align-middle">
												<a href="javascript:;" class="text-secondary font-weight-bold text-xs"
													data-toggle="tooltip" data-original-title="Edit user">
													Edit
												</a>
											</td>
										</tr>
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
				damping: '0.5'
			}
			Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
		}
	</script>
	<!-- Github buttons -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="../assets/js/soft-ui-dashboard.min.js?v=1.0.3"></script>
</body>

</html>