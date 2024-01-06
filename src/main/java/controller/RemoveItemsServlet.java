package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Servlet implementation class RemoveItemsServlet
 */
public class RemoveItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String productId = request.getParameter("id");
        System.out.println(productId);
        if (productId != null) {
            // Thực hiện xóa sản phẩm từ giỏ hàng ở đây
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        String cartValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        String[] items = cartValue.split(",");
                        StringBuilder updatedCartValue = new StringBuilder();

                        for (String item : items) {
                            String[] itemInfo = item.split(":");
                            if (itemInfo.length >= 2 && itemInfo[0].equals(productId)) {
                            	// 1:3 cần xóa
                            	// item[1] cần xóa 
                                // Bỏ qua sản phẩm cần xóa
                                continue;
                            }

                            updatedCartValue.append(item).append(",");
                        }

                        // Xóa dấu ',' cuối cùng nếu có
                        if (updatedCartValue.length() > 0) {
                            updatedCartValue.deleteCharAt(updatedCartValue.length() - 1);
                        }

                        // Cập nhật giá trị của cookie giỏ hàng
                        cookie.setValue(URLEncoder.encode(updatedCartValue.toString(), "UTF-8"));
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }

        // Chuyển hướng về trang giỏ hàng
        request.getRequestDispatcher("CartServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
