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
 * Servlet implementation class FilterProductsServlet
 */
public class FilterProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Lấy giá trị minPrice và maxPrice từ yêu cầu Ajax
		double minPrice = Double.parseDouble(request.getParameter("minPrice"));
		double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
		ProductDAO pd = new ProductDAO();
		String filteredProductHtml = pd.getFilteredProductHtml(minPrice, maxPrice);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(filteredProductHtml);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
