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
 * Servlet implementation class AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy giá trị từ form
		String id_S = request.getParameter("categoryId");
		String name = request.getParameter("categoryName");
		String link = request.getParameter("link");
		String status_S = request.getParameter("status");

		int id = Integer.parseInt(id_S);
		int status = Integer.parseInt(status_S);

		// Kiểm tra xem danh mục đã tồn tại hay chưa
		CategoryDAO cd = new CategoryDAO();
		Category c = cd.getCategoryById(id);

		if (c == null) {
			c = new Category(id, name, link, status);
			cd.insert(c);
			request.getRequestDispatcher("CategoryServlet").forward(request, response);
		} else {
			String error = "Đã tồn tại mã ID " + id + " mà bạn đã nhập, vui lòng nhập một mã khác!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("addCategory.jsp").forward(request, response);
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
