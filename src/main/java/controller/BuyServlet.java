package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.util.List;

import dal.ProductDAO;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO d = new ProductDAO();
//		List<Product> list = d.getAll();
		Cookie[] arr = request.getCookies();
		String txt = "";
	    String productId = request.getParameter("productId");
	    String quantity = request.getParameter("quantity");

	    if (arr != null) {
	        for (Cookie o : arr) {
	            if (o.getName().equals("cart")) {
	                txt += o.getValue();
	                o.setMaxAge(0);
	                response.addCookie(o);
	        	    }
	            }
	        }
	    
	    if (txt.isEmpty()) {
	        txt = productId + ":" + quantity;
	    } else {
	        txt = txt + "," + productId + ":" + quantity;
	
	    }
	
	    Cookie c = new Cookie("cart", txt);
	    c.setMaxAge(24*60*60);
	    response.addCookie(c);
	    
//	    request.getRequestDispatcher("shop-single.jsp");
//	    response.sendRedirect("shop-single.jsp");
	}

}
