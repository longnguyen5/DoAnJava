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
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">

</head>

<body class="g-sidenav-show  bg-gray-100">
	<main 
		class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
		<div class="container-fluid py-4">
			<div class="row">
				<div class="col-8" style="margin: 0 auto;">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<h5>Thêm nhà cung cấp</h5>
							<h6 style="color: red;">${error}</h6>
						</div>
						<form action="AddManuServlet" method="get">
							<div class="mb-3 ml-3 row">
								<label for="manufacturerId" class="col-sm-2 col-form-label">ID
									Nhà cung cấp</label>
								<div class="col-sm-10">
									<input class="form-control" type="text" name="manufacturerId"
										placeholder="Default input" aria-label="default input example">
								</div>
							</div>
							<div class="mb-3 ml-3 row">
								<label for="manufacturerName" class="col-sm-3 col-form-label">Tên
									Nhà cung cấp</label>
								<div class="col-sm-10">
									<input class="form-control" type="text" name="manufacturerName"
										placeholder="Default input" aria-label="default input example">
								</div>
							</div>
							<div class="mb-3 ml-3 row">
								<label for="address" class="col-sm-2 col-form-label">Địa chỉ</label>
								<div class="col-sm-10">
									<input class="form-control" type="text" name="address"
										placeholder="Default input" aria-label="default input example">
								</div>
							</div>
							<div class="mb-3 ml-3 row">
								<label for="phoneNumber" class="col-sm-3 col-form-label">Số điện thoại</label>
								<div class="col-sm-10">
									<input class="form-control" type="text" name="phoneNumber"
										placeholder="Default input" aria-label="default input example">
								</div>
							</div>
							<div class="mb-3 ml-3 row">
								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-3">
									<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
  <title>check</title>
  <g fill="#ffffff">
    <polyline points="2.75 9.25 6.75 14.25 15.25 3.75" fill="none" stroke="#ffffff" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5"></polyline>
  </g>
</svg>
									Lưu</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>

	</main>


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