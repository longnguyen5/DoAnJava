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
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = (String) request.getAttribute("keyword");
		ProductDAO pd = new ProductDAO();
		List<Product> list = pd.getProductByKeyword(keyword);
	
		SubCategoryDAO scd = new SubCategoryDAO();
		List<SubCategory> subcategories = scd.getAll();

		request.setAttribute("subcategories", subcategories);
		request.setAttribute("key", keyword);
		// Lưu trữ danh sách sản phẩm vào request attribute
		request.setAttribute("products", list);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
