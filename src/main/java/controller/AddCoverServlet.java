package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Cover;

import java.io.IOException;

import dal.CategoryDAO;
import dal.CoverDAO;

/**
 * Servlet implementation class AddCoverServlet
 */
public class AddCoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy giá trị từ form
		String id_S = request.getParameter("coverId");
		String name = request.getParameter("coverName");
		String description = request.getParameter("description");
		String link = request.getParameter("link");
		String status_S = request.getParameter("status");

		int id = Integer.parseInt(id_S);
		int status = Integer.parseInt(status_S);

		// Kiểm tra xem danh mục đã tồn tại hay chưa
		CoverDAO cd = new CoverDAO();
		Cover c = cd.getCoverById(id);

		if (c == null) {
			c = new Cover(id, name, description, link, status);
			cd.insert(c);
			request.getRequestDispatcher("CoverServlet").forward(request, response);
			
			if(status == 1) {
				cd.updateOther(id);
			}
			
		} else {
			String error = "Đã tồn tại mã ID " + id + " mà bạn đã nhập, vui lòng nhập một mã khác!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("addCover.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
