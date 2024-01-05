<%@page import="dal.CategoryDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
// Lấy danh sách categories từ Session
List<Category> categories = (List<Category>) session.getAttribute("categories");

// Kiểm tra nếu danh sách chưa được lưu vào Session
if (categories == null) {
	// Khởi tạo CategoryDAO và lấy danh sách từ database
	CategoryDAO cd = new CategoryDAO();
	categories = cd.getAllCategory();

	// Lưu danh sách vào Session
	session.setAttribute("categories", categories);
}
%>

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
<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">
				<!-- Search bar -->
				<div
					class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="" class="site-block-top-search">
						<span class="icon icon-search2"></span> <input type="text"
							class="form-control border-0" placeholder="Tìm kiếm">
					</form>
				</div>
				<!-- Logo -->
				<div
					class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="HeaderServlet" class="js-logo-clone">Dr.Enal</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<li><a href="#"><span class="icon icon-person"></span></a></li>
							<li><a href="CategoryServlet"><span class="icon icon-heart-o"></span></a></li>
							<li><a href="cart.jsp" class="site-cart"> <span
									class="icon icon-shopping_cart"></span> <span class="count">2</span>
							</a></li>
							<li class="d-inline-block d-md-none ml-md-0"><a href="#"
								class="site-menu-toggle js-menu-toggle"> <span
									class="icon-menu"></span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="site-navigation text-right text-md-center"
		role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<li class=""><a href="HeaderServlet">Trang chủ</a></li>
				<!-- Sử dụng EL để lặp qua danh sách categories -->
				<c:forEach var="category" items="${sessionScope.categories}">
					<c:if test="${category.status == 1}">
						<li class=""><a
							href="${pageContext.request.contextPath}${category.link}">${category.categoryName}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</nav>
</header>
