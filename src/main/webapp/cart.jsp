<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dr.Enal &mdash; Tôi là bánh khúc đây</title>
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

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="index.jsp">Trang chủ</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Giỏ hàng</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-5">
					<form class="col-md-12" method="post">
						<div class="site-blocks-table">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="product-thumbnail">Hình ảnh</th>
										<th class="product-name">Sản phẩm</th>
										<th class="product-price">Giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-total">Tổng tiền</th>
										<th class="product-remove">Chức năng</th>
									</tr>
								</thead>
								<c:set var = "o" value = "${requestScope.cart }"/>
								<c:set var="tt" value="0"/>
								<tbody>
									<c:forEach items="${o.items }" var = "i">
										<c:set var="tt" value="${tt+1 }"/>
										<tr>
											<td class="product-thumbnail"><img
												src="${i.product.imageUrl }" alt="Image" class="img-fluid">
											</td>
											<td class="product-name">
												<h2 class="h5 text-black">${i.product.productName}</h2>
											</td>
											<td>
												${i.product.price }
											</td>
											<td>
												<div class="input-group mb-3" style="max-width: 120px;">
													<div class="input-group-prepend">
														<a href="process?num=-1&id=${i.product.productId }">
														<button class="btn btn-outline-primary js-btn-minus" 
															type="button">&minus;</button>
														</a>
													</div>
													<input type="text" class="form-control text-center"
														value="${i.quantity}" placeholder=""
														aria-label="Example text with button addon"
														aria-describedby="button-addon1">
													<div class="input-group-append">
														<a href="process?num=1&id=${i.product.productId }">
														<button class="btn btn-outline-primary js-btn-plus"
															type="button">&plus;</button>
														</a>
													</div>
												</div>
	
											</td>
											<td>
												${i.product.price*i.quantity }
											</td>
											<td>
												<form action="RemoveItemsServlet" method="post">
													<input type="hidden" name = "id" value="${i.product.productId }"/>	
															
													<input type="submit" value="X"/>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="row mb-5">
							<div class="col-md-6 mb-3 mb-md-0">
								<button class="btn btn-primary btn-sm btn-block">Cập nhật giỏ hàng</button>
							</div>
							<div class="col-md-6">
								<button class="btn btn-outline-primary btn-sm btn-block">Tiếp tục mua</button>
							</div>
						</div>
						
					</div>
					<div class="col-md-6 pl-5">
						<div class="row justify-content-end">
							<div class="col-md-7">
								<div class="row">
									<div class="col-md-12 text-right border-bottom mb-5">
										<h3 class="text-black h4 text-uppercase">Tổng tiền giỏ hàng</h3>
									</div>
								</div>
								<div class="row mb-5">
									<div class="col-md-6">
										<span class="text-black">Tổng</span>
									</div>
									<div class="col-md-6 text-right">
										<strong class="text-black">$ ${o.totalMoney}</strong>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<form action="checkout" method="post">										
											<input type="submit" value="Thanh toán"/>
										</form>
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