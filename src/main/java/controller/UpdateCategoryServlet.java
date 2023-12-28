package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

import java.io.IOException;

import dal.CategoryDAO;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_s = request.getParameter("categoryId");
		int id = Integer.parseInt(id_s);
		CategoryDAO cd = new CategoryDAO();
		Category c = cd.getCategoryById(id);
		request.setAttribute("category", c);
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy giá trị từ form
		String id_S = request.getParameter("categoryId");
		String name = request.getParameter("categoryName");
		String link = request.getParameter("link"); 
		String status_S = request.getParameter("status");

		int id = Integer.parseInt(id_S);
		int status = Integer.parseInt(status_S);

		CategoryDAO cd = new CategoryDAO();
		Category c = new Category(id, name, link, status);
		
		cd.update(c);
		response.sendRedirect("CategoryServlet");

	}

}
