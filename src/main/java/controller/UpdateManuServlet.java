package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Manufacturer;

import java.io.IOException;

import dal.CategoryDAO;
import dal.ManufacturerDAO;

/**
 * Servlet implementation class UpdateManuServlet
 */
public class UpdateManuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_s = request.getParameter("manufacturerId");
		int id = Integer.parseInt(id_s);
		ManufacturerDAO cd = new ManufacturerDAO();
		Manufacturer c = cd.getManufacturerById(id);
		request.setAttribute("manufacturer", c);
		request.getRequestDispatcher("updateManufacturer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_S = request.getParameter("manufacturerId");
		String name = request.getParameter("manufacturerName");
		String link = request.getParameter("address"); 
		String status = request.getParameter("phoneNumber");

		int id = Integer.parseInt(id_S);

		ManufacturerDAO cd = new ManufacturerDAO();
		Manufacturer c = new Manufacturer(id, name, link, status);
		
		cd.update(c);
		response.sendRedirect("ManusServlet");
	}

}
