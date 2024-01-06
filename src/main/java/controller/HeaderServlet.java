package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Cover;
import model.Item;
import model.Product;
import model.SubCategory;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import dal.CategoryDAO;
import dal.CoverDAO;
import dal.ProductDAO;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        ProductDAO d = new ProductDAO();
        List<Product> list = d.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie cookie : arr) {
                if (cookie.getName().equals("cart")) {
                    txt += cookie.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, list);
        List<Item> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else
            n = 0;
        request.getSession().setAttribute("size", n);
    
        // request.setAttribute("data", list);
//        request.getRequestDispatcher("header.jsp").forward(request, response);

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
