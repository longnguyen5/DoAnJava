package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Manufacturer;
import model.Product;

import java.io.IOException;

import dal.ManufacturerDAO;
import dal.ProductDAO;
import dal.SubCategoryDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_s = request.getParameter("productId");
		int id = Integer.parseInt(id_s);
		ProductDAO pd = new ProductDAO();
		Product p = pd.getProductById(id);
		request.setAttribute("product", p);
		request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_S = request.getParameter("productId");
		String name = request.getParameter("productName");
		String sku = request.getParameter("sku");
		String link = request.getParameter("imageUrl");
		String description = request.getParameter("description");
		String manuId_S = request.getParameter("manuId");
		String subId_S = request.getParameter("subId");
		String proDate = request.getParameter("proDate");
		String expDate = request.getParameter("expDate");
		String quantity_S = request.getParameter("quantity");
		String status = request.getParameter("status");
		String price_s = request.getParameter("price");

		int id = Integer.parseInt(id_S);

		int manuId = Integer.parseInt(manuId_S);
		int subId = Integer.parseInt(subId_S);
		int quantity = Integer.parseInt(quantity_S);
		double price = Double.parseDouble(price_s);

		ManufacturerDAO md = new ManufacturerDAO();
		SubCategoryDAO sd = new SubCategoryDAO();
		ProductDAO pd = new ProductDAO();
		Product p = new Product(id, name, sku, description, price, quantity, md.getManufacturerById(manuId), proDate, expDate, sd.getSubCategoryById(subId), link, status);
		pd.insert(p);
		response.sendRedirect("ProductListServlet");
	}

}
