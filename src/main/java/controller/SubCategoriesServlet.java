package controller;

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
 * Servlet implementation class SubCategoriesServlet
 */
public class SubCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy subcategoryId từ request
	    int subcategoryId = Integer.parseInt(request.getParameter("subcategoryId"));

	    // Lấy số trang hiện tại từ request hoặc đặt giá trị mặc định là 1
	    int currentPage = request.getParameter("page") != null ?
	            Integer.parseInt(request.getParameter("page")) : 1;

	    // Số sản phẩm trên mỗi trang
	    int pageSize = 12;

	    // Gọi DAO để lấy danh sách sản phẩm theo danh mục và trang
	    SubCategoryDAO scd = new SubCategoryDAO();
	    ProductDAO pd = new ProductDAO();
	    List<Product> list = pd.getProductsBySubCategoryId(subcategoryId, currentPage, pageSize);
	    SubCategory spec = scd.getSubCategoryById(subcategoryId);
	    // Lấy tổng số sản phẩm của danh mục
	    int totalProducts = pd.getTotalProductsBySubCategoryId(subcategoryId);

	    // Tính tổng số trang
	    int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

	    // Gửi thông tin đến trang JSP
	    request.setAttribute("spec", spec);
	   
	    request.setAttribute("subcategories", scd.getAll());
	    request.setAttribute("products", list);
	    request.setAttribute("currentPage", currentPage);
	    request.setAttribute("totalPages", totalPages);

	    // Chuyển hướng đến trang JSP để hiển thị sản phẩm của danh mục
	    request.getRequestDispatcher("subcategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
