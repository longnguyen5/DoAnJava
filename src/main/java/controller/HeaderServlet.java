package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Cover;
import model.SubCategory;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import dal.CategoryDAO;
import dal.CoverDAO;
import dal.SubCategoryDAO;

/**
 * Servlet implementation class HeaderServlet
 */
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		
		// Lấy danh sách categories từ database
        CategoryDAO cd = new CategoryDAO();
        List<model.Category> categories = cd.getAllCategory();
        
        CoverDAO cadao = new CoverDAO();
        Cover c = cadao.getCoverbyStatus();
        
        request.setAttribute("cover", c);
        
        request.setAttribute("account", account);

        // Lưu danh sách vào Session
        request.getSession().setAttribute("categories", categories);

        // Chuyển hướng đến index.jsp hoặc trang chính của bạn
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
