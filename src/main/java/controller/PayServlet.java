package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		Cookie cartCookie = null;
		boolean cartExists = false;

		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("cart")) {
		            cartCookie = cookie;
		            cartExists = true;
		            cookie.setMaxAge(0);
		            response.addCookie(cookie);
		            break;
		        }
		    }
		}

		if (!cartExists) {
		    request.setAttribute("emptyCartMessage", "Không có hàng trong giỏ");
		}

		request.getRequestDispatcher("cart.jsp").forward(request, response);


	}

}