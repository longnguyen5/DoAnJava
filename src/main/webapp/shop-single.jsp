<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dr.Enal &mdash; Tôi là bánh đúc đây</title>
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
		<jsp:include page="header.jsp" />
		<c:set value="${details}" var="c"/>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="ProductServlet">Sản phẩm</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">${c.productName}</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<img src="${c.imageUrl}" alt="Image" class="img-fluid">
					</div>
					<div class="col-md-6">
						<h2 class="text-black">${c.productName }</h2>
						<p>${c.sku }</p>
						<p class="mb-4">${c.manufacturer.manufacturerName }</p>
						<p class="mb-4">${c.description }</p>
						<p>
							<strong class="text-primary h4">${c.price}VND</strong>
						</p>
						<form id="buyform" action="BuyServlet" method="post">
						<div class="mb-5">
							<div class="input-group mb-3" style="max-width: 120px;">
								<div class="input-group-prepend">
									<button class="btn btn-outline-primary js-btn-minus" onclick="decreaseQuantity()"
										type="button">&minus;</button>
								</div>
								<input type="text" class="form-control text-center" value="1"
									placeholder="" aria-label="Example text with button addon"
									aria-describedby="button-addon1">
								<div class="input-group-append">
									<button class="btn btn-outline-primary js-btn-plus" onclick="increaseQuantity()"
										type="button">&plus;</button>
								</div>
							</div>

						</div>
						<p>
							<a href="javascript:void(0);" onclick="updateBuyNowLink()"
								 class="buy-now btn btn-sm btn-primary">Thêm
								vào giỏ</a>
						</p>
						</form>

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
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Tank Top</a>
										</h3>
										<p class="mb-0">Finding perfect t-shirt</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/shoe_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Corater</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_2.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Polo Shirt</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_3.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">T-Shirt Mockup</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/shoe_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Corater</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
	</div>

	<script>
/* 		 function updateBuyNowLink() {
			var productId = "${c.productId}";
			var quantity = document.querySelector('.form-control.text-center').value;
			var buyNowLink = document.getElementById("buy-now-link");
			buyNowLink.href = "BuyServlet?productId=" + productId + "&quantity="
					+ quantity;
		}  */
		 function updateBuyNowLink(event) {
		    event.preventDefault(); // Ngăn chặn hành động mặc định của form

		    var productId = "${c.productId}";
		    var quantity = document.querySelector('.form-control.text-center').value;

		    // Tạo yêu cầu XMLHttpRequest
		    var xhr = new XMLHttpRequest();
		    xhr.onreadystatechange = function() {
		        if (xhr.readyState === XMLHttpRequest.DONE) {
		            if (xhr.status === 200) {
		                // Xử lý khi yêu cầu thành công
		                console.log("Đã thêm vào giỏ hàng!");
		            } else {
		                // Xử lý khi yêu cầu không thành công
		                console.error("Lỗi khi thêm vào giỏ hàng!");
		            }
		        }
		    };

		    // Tạo yêu cầu POST đến AddToCartServlet
		    xhr.open("POST", "BuyServlet", true);
		    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    xhr.send("productId=" + productId + "&quantity=" + quantity);
		}
		document.querySelector('.buy-now').addEventListener('click', updateBuyNowLink);		
	</script>

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