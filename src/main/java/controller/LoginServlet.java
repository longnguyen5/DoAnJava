package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Product;

import java.io.IOException;
import java.util.List;

import dal.AccountDAO;
import dal.ProductDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		Cookie cu = new Cookie("cuser", user);
		Cookie cp = new Cookie("cpass", pass);

		cu.setMaxAge(7 * 60 * 60 * 24);
		cp.setMaxAge(7 * 60 * 60 * 24);

		response.addCookie(cu);
		response.addCookie(cp);

		AccountDAO d = new AccountDAO();
		Account a = d.check(user, pass);

		if (a == null) {
			request.setAttribute("erro", "Tên tài khoản hoặc mật khẩu bị sai!");
			request.getRequestDispatcher("login.html").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("account", a);

			response.sendRedirect("HeaderServlet");
		}
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
