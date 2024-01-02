package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.SubCategory;

import java.io.IOException;
import java.util.List;

import dal.ProductDAO;
import dal.SubCategoryDAO;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Khởi tạo đối tượng ProductDAO
		ProductDAO productDAO = new ProductDAO();

		// Xác định trang hiện tại
		int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
		int pageSize = 12; // Số lượng sản phẩm trên mỗi trang

		// Lấy tất cả sản phẩm
		List<Product> products = productDAO.getProducts(currentPage, pageSize);

		int totalProducts = productDAO.getTotalProducts();

		// Xác định tổng số trang
		int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

		SubCategoryDAO scd = new SubCategoryDAO();
		List<SubCategory> subcategories = scd.getAll();

		request.setAttribute("subcategories", subcategories);

		// Lưu trữ danh sách sản phẩm vào request attribute
		request.setAttribute("products", products);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		
		System.out.println("Current Page: " + currentPage);
        System.out.println("Total Pages: " + totalPages);
		
		// Chuyển hướng đến trang JSP để hiển thị sản phẩm
		request.getRequestDispatcher("shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
