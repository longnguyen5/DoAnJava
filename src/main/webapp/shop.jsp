<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<a href="index.jsp">Trang chủ</a> <span class="mx-2 mb-0">/</span>
						<strong class="text-black">Tất cả sản phẩm</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">

				<div class="row mb-5">
					<div class="col-md-9 order-2">

						<div class="row">
							<div class="col-md-12 mb-5">
								<div class="float-md-left mb-4">
									<h2 class="text-black h5">Tất cả sản phẩm</h2>
								</div>
								<div class="d-flex">
									<div class="dropdown mr-1 ml-md-auto">
										<div class="btn-group">
											<button type="button"
												class="btn btn-secondary btn-sm dropdown-toggle"
												id="dropdownMenuReference" data-toggle="dropdown">Sắp
												xếp theo</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuReference">
												<a class="dropdown-item sort-option"
													data-sort-type="name-asc" href="#">Tên, từ A đến Z</a> <a
													class="dropdown-item sort-option"
													data-sort-type="name-desc" href="#">Tên, từ Z đến A</a>
												<div class="dropdown-divider"></div>
												<a class="dropdown-item sort-option"
													data-sort-type="price-asc" href="#">Giá, từ thấp đến
													cao</a> <a class="dropdown-item sort-option"
													data-sort-type="price-desc" href="#">Giá, từ cao đến
													thấp</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Hiện danh sách sản phẩm -->
						<div class="row mb-5">
							<div id="product-container" class="row" data-aos="fade-up">
								<!-- Đây là nơi hiển thị sản phẩm, sử dụng id="product-container" -->
								<c:forEach var="product" items="${products}">
									<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
										<div class="block-4 text-center border">
											<figure class="block-4-image">
												<a
													href="ProductDetailsServlet?productId=${product.productId}">
													<img src="${product.imageUrl}" alt="${product.productName}"
													class="img-fluid">
												</a>
											</figure>
											<div class="block-4-text p-4">
												<h3>
													<a
														href="ProductDetailsServlet?productId=${product.productId}">
														<script>
															document
																	.write("${product.productName}".length > 20 ? "${product.productName}"
																			.substring(
																					0,
																					20)
																			+ '...'
																			: "${product.productName}");
														</script>
													</a>
												</h3>
												<p class="mb-0">
													<script>
														document
																.write("${product.description}".length > 50 ? "${product.description}"
																		.substring(
																				0,
																				50)
																		+ '...'
																		: "${product.description}");
													</script>
												</p>
												<p class="text-primary font-weight-bold">${product.price}
													VNĐ</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:if test="${currentPage > 1}">
											<li><a href="ProductServlet?page=${currentPage - 1}">&lt;</a></li>
										</c:if>

										<c:forEach var="page" begin="1" end="${totalPages}">
											<c:choose>
												<c:when test="${page eq currentPage}">
													<li class="active"><span>${page}</span></li>
												</c:when>
												<c:otherwise>
													<li><a href="ProductServlet?page=${page}">${page}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>

										<c:if test="${currentPage < totalPages}">
											<li><a href="ProductServlet?page=${currentPage + 1}">&gt;</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-3 order-1 mb-5 mb-md-0">
						<div class="border p-4 rounded mb-4">
							<h3 class="mb-3 h6 text-uppercase text-black d-block">Theo
								danh mục</h3>
							<ul class="list-unstyled mb-0">
								<c:forEach var="subcategory" items="${subcategories}">
									<li class="mb-1"><a
										href="SubCategoriesServlet?subcategoryId=${subcategory.subcategoryId}"
										class="d-flex"><span>${subcategory.subcategoryName}</span>
											<span class="text-black ml-auto">(2,124)</span></a></li>
								</c:forEach>
							</ul>
						</div>

						<div class="border p-4 rounded mb-4">
							<div class="mb-4">
								<h3 class="mb-3 h6 text-uppercase text-black d-block">Theo
									giá</h3>
								<div id="slider-range" class="border-primary"></div>
								<input type="text" name="text" id="amount"
									class="form-control border-0 pl-0 bg-white" disabled="" />
							</div>
							<!-- 							<a href="#" class="btn btn-sm btn-primary" onclick="applyFilter()">Áp dụng</a> -->
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

	<script>
		$(function() {
			var sliderRange = $("#slider-range");
			var amountInput = $("#amount");

			sliderRange.slider({
				range : true,
				min : 0,
				max : 10000000,
				step : 50000, // Bước giá trị
				values : [ 0, 2500000 ],
				slide : function(event, ui) {
					updateAmountInput(ui.values[0], ui.values[1]);
				},
				input : function(event, ui) {
					updateAmountInput(ui.values[0], ui.values[1]);
				},
				change : function(event, ui) {
					var minPrice = ui.values[0];
					var maxPrice = ui.values[1];

					// Sử dụng Ajax để gửi yêu cầu đến Servlet
					$.ajax({
						url : "FilterProductsServlet", // Đường dẫn tới Servlet
						data : {
							minPrice : minPrice,
							maxPrice : maxPrice
						},
						type : "GET",
						success : function(response) {
							// Hiển thị sản phẩm sau khi lọc
							$("#product-container").html(response);
						},
						error : function(error) {
							console.log("Error:", error);
						}
					});
				}
			});

			function updateAmountInput(minValue, maxValue) {
				var formattedMinValue = formatCurrency(minValue);
				var formattedMaxValue = formatCurrency(maxValue);

				amountInput.val(formattedMinValue + " - " + formattedMaxValue);
			}

			function formatCurrency(value) {
				// Định dạng giá trị theo đơn vị tiền tệ của bạn
				var currencyFormat = new Intl.NumberFormat('vi-VN', {
					style : 'currency',
					currency : 'VND'
				});

				return currencyFormat.format(value);
			}

			// Khởi tạo giá trị ban đầu cho input
			updateAmountInput(sliderRange.slider("values", 0), sliderRange
					.slider("values", 1));
		});
	</script>

<script>
$(document).on("click", ".sort-option", function(e) {
	   e.preventDefault();
	   
	   var sortType = $(this).data("sort-type");

	   // Sử dụng Ajax để gửi yêu cầu đến Servlet
	   $.ajax({
	      url: "SortServlet", // Đường dẫn tới Servlet
	      data: {
	         sortType: sortType
	      },
	      type: "GET",
	      success: function(response) {
	         // Hiển thị sản phẩm sau khi sắp xếp
	         $("#product-container").html(response);
	      },
	      error: function(error) {
	         console.log("Error:", error);
	      }
	   });
	});
</script>
</body>
</html>