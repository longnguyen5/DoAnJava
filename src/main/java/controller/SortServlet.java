package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dal.ProductDAO;

/**
 * Servlet implementation class SortServlet
 */
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sortType = request.getParameter("sortType");
		ProductDAO pd = new ProductDAO();
			
		String sortedProductsHtml = null;
		if ("name-asc".equals(sortType)) {
			sortedProductsHtml = pd.getSortedProductsHtml(pd.getProductNameAcs());
		} else if ("name-desc".equals(sortType)) {
			sortedProductsHtml = pd.getSortedProductsHtml(pd.getProductNameDesc());
		} else if ("price-asc".equals(sortType)) {
			sortedProductsHtml = pd.getSortedProductsHtml(pd.getProductPriceAcs());
		} else if ("price-desc".equals(sortType)){
			sortedProductsHtml = pd.getSortedProductsHtml(pd.getProductPriceDesc());
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(sortedProductsHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
