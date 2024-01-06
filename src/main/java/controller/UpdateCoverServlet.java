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
 * Servlet implementation class UpdateCoverServlet
 */
public class UpdateCoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_s = request.getParameter("coverId");
		int id = Integer.parseInt(id_s);
		CoverDAO cd = new CoverDAO();
		Cover c = cd.getCoverById(id);
		request.setAttribute("cover", c);
		request.getRequestDispatcher("updateCover.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_S = request.getParameter("coverId");
		String name = request.getParameter("coverName");
		String description = request.getParameter("description");
		String link = request.getParameter("link");
		String status_S = request.getParameter("status");

		int id = Integer.parseInt(id_S);
		int status = Integer.parseInt(status_S);

		CoverDAO cd = new CoverDAO();
		Cover c = new Cover(id, name, description, link, status);
		cd.update(c);
		if(status == 1) {
			cd.updateOther(id);
		}
		response.sendRedirect("CoverServlet");
	}

}
