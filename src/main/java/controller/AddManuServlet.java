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
 * Servlet implementation class AddManuServlet
 */
public class AddManuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy giá trị từ form
		String manufacturerId_S = request.getParameter("manufacturerId");
		String manufacturerName = request.getParameter("manufacturerName");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");

		int id = Integer.parseInt(manufacturerId_S);

		// Kiểm tra xem danh mục đã tồn tại hay chưa
		ManufacturerDAO cd = new ManufacturerDAO();
		Manufacturer c = cd.getManufacturerById(id);

		if (c == null) {
			c = new Manufacturer(id, manufacturerName, address, phoneNumber);
			cd.insert(c);
			request.getRequestDispatcher("ManusServlet").forward(request, response);
		} else {
			String error = "Đã tồn tại mã ID " + id + " mà bạn đã nhập, vui lòng nhập một mã khác!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("addManufacturer.jsp").forward(request, response);
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
