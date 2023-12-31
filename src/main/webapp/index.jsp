<%@page import="dal.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Dr.Enal &mdash; Tôi là bánh khúc đây</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">  -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,700">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">


</head>
<body>
	<div class="site-wrap">

		<%@ include file="header.jsp"%>
		<c:set value = "${cover}" var = "c"/>
		<div class="site-blocks-cover"
			style="background-image: url(${c.link});" data-aos="fade">
			<div class="container">
				<div
					class="row align-items-start align-items-md-center justify-content-end">
					<div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
						<h1 class="mb-2">${c.coverName}</h1>
						<div class="intro-text text-center text-md-left">
							<p class="mb-4">${c.description}</p>
							<p>
								<a href="ProductServlet" class="btn btn-sm btn-primary">Shop ngay</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section site-section-sm site-blocks-1">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="">
						<div class="icon mr-4 align-self-start">
							<span class="icon-truck"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Giao hàng miễn phí</h2>
							<p>Miễn phí giao hàng là dịch vụ chúng tôi cung cấp với sự
								chăm sóc đặc biệt. Chúng tôi cam kết đem đến trải nghiệm mua sắm
								thuận lợi cho bạn.</p>

						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="100">
						<div class="icon mr-4 align-self-start">
							<span class="icon-refresh2"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Miễn phí đổi trả</h2>
							<p>Chúng tôi cam kết đem đến sự hài lòng cho bạn. Nếu có bất
								kỳ vấn đề nào với sản phẩm, hãy yên tâm vì chúng tôi cung cấp
								dịch vụ đổi trả miễn phí.</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="200">
						<div class="icon mr-4 align-self-start">
							<span class="icon-help"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Chăm sóc khách hàng</h2>
							<p>Chúng tôi luôn sẵn lòng hỗ trợ bạn mọi lúc. Đội ngũ chăm
								sóc khách hàng của chúng tôi cam kết mang lại trải nghiệm mua
								sắm tốt nhất cho bạn.</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section site-blocks-2">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0"
						data-aos="fade" data-aos-delay="">
						<a class="block-2-item" href="#">
							<figure class="image">
								<img src="images/women.jpg" alt="" class="img-fluid">
							</figure>
							<div class="text">
								<span class="text-uppercase">Dành cho</span>
								<h3>Phụ nữ</h3>
							</div>
						</a>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0"
						data-aos="fade" data-aos-delay="100">
						<a class="block-2-item" href="#">
							<figure class="image">
								<img src="images/children.jpg" alt="" class="img-fluid">
							</figure>
							<div class="text">
								<span class="text-uppercase">Dành cho</span>
								<h3>Trẻ con</h3>
							</div>
						</a>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0"
						data-aos="fade" data-aos-delay="200">
						<a class="block-2-item" href="#">
							<figure class="image">
								<img src="images/men.jpg" alt="" class="img-fluid">
							</figure>
							<div class="text">
								<span class="text-uppercase">Dành cho</span>
								<h3>Đàn ông</h3>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Sản phẩm nổi bật</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
						<c:forEach var="c" items="${spnoibat }">
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="${c.imageUrl }" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">${c.productName }</a>
										</h3>
										<p class="text-primary font-weight-bold">${c.price }VND</p>
									</div>
								</div>
							</div>
						</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- <div class="site-section block-8">
			<div class="container">
				<div class="row justify-content-center  mb-5">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Sale lớn!</h2>
					</div>
				</div>
				<div class="row align-items-center">
					<div class="col-md-12 col-lg-7 mb-5">
						<a href="#"><img src="images/blog_1.jpg"
							alt="Image placeholder" class="img-fluid rounded"></a>
					</div>
					<div class="col-md-12 col-lg-5 text-center pl-md-5">
						<h2>
							<a href="#">50% less in all items</a>
						</h2>
						<p class="post-meta mb-4">
							By <a href="#">Carl Smith</a> <span class="block-8-sep">&bullet;</span>
							September 3, 2018
						</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Quisquam iste dolor accusantium facere corporis ipsum animi
							deleniti fugiat. Ex, veniam?</p>
						<p>
							<a href="#" class="btn btn-primary btn-sm">Shop Now</a>
						</p>
					</div>
				</div>
			</div>
		</div> -->

		<%@ include file="footer.jsp"%>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

</body>
</html>