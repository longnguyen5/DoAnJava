package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;

import dal.ProductDAO;

/**
 * Servlet implementation class FilterProductServlet
 */
public class FilterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int minPrice = Integer.parseInt(request.getParameter("minPrice"));
        int maxPrice = Integer.parseInt(request.getParameter("maxPrice"));

        ProductDAO pd = new ProductDAO();	
        
        // Thực hiện logic lọc sản phẩm
        List<Product> filteredProducts = pd.getProductByPrice(minPrice, maxPrice);

        // Lưu danh sách sản phẩm vào request
        request.setAttribute("products", filteredProducts);

        // Chuyển dữ liệu sang trang JSP để hiển thị
        request.getRequestDispatcher("shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
