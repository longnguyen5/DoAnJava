package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.Item;
import model.Product;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import dal.ProductDAO;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");

        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = null;

        // Tìm cookie giỏ hàng hiện tại
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cartCookie = cookie;
                    break;
                }
            }
        }

        // Xử lý giá trị cookie giỏ hàng
        if (cartCookie == null) {
            // Nếu không có giỏ hàng, tạo cookie mới
            cartCookie = new Cookie("cart", URLEncoder.encode(productId + ":" + quantity, "UTF-8"));
        } else {
            // Nếu đã có giỏ hàng, cập nhật giá trị cookie
        	String cartValue = URLDecoder.decode(cartCookie.getValue(), "UTF-8");
			/*
			 * String[] items = cartValue.split(","); boolean productExists = false;
			 * 
			 * for (int i = 0; i < items.length; i++) { String[] itemInfo =
			 * items[i].split(":"); if (itemInfo.length >= 2 &&
			 * itemInfo[0].equals(productId)) { // Sản phẩm đã có trong giỏ hàng, tăng số
			 * lượng int newQuantity = Integer.parseInt(itemInfo[1]) +
			 * Integer.parseInt(quantity); items[i] = productId + ":" + newQuantity;
			 * productExists = true; break; } }
			 * 
			 * if (!productExists) { // Sản phẩm mới, thêm vào danh sách cartValue += "," +
			 * productId + ":" + quantity; }
			 * 
			 * // Đặt giá trị mới cho cookie
			 * cartCookie.setValue(URLEncoder.encode(cartValue, "UTF-8"));
			 * System.out.println(cartValue);
			 */
        	String decodedCartValue = URLDecoder.decode(cartValue, "UTF-8");
        	String oridecodedCartValue = decodedCartValue;
        	System.out.println("Decoded Cart Value: " + decodedCartValue);

        	String[] items = decodedCartValue.split(",");
        	boolean productExists = false;
        	int i;
        	for (i = 0; i < items.length; i++) {
        	    String[] itemInfo = items[i].split(":");
        	    if (itemInfo.length >= 2 && itemInfo[0].equals(productId)) {
        	        // Sản phẩm đã có trong giỏ hàng, tăng số lượng
        	        int newQuantity = Integer.parseInt(itemInfo[1]) + Integer.parseInt(quantity);
        	        items[i] = productId + ":" + newQuantity;
        	        
        	        System.out.println(items[i]);
        	        productExists = true;
        	        break;
        	    }
        	}
        	
        	decodedCartValue = String.join(",", items);
        	if (!productExists) {
        		oridecodedCartValue += "," + productId + ":" + quantity;
        		decodedCartValue = oridecodedCartValue;
        	}

        	// Đặt giá trị mới cho cookie
        	cartCookie.setValue(URLEncoder.encode(decodedCartValue, "UTF-8"));
        	System.out.println("Updated Cart Value: " + decodedCartValue);
        }

        // Thiết lập thời gian sống của cookie (ví dụ: 1 ngày)
        cartCookie.setMaxAge(2 * 24 * 60 * 60);

        // Thêm hoặc cập nhật cookie vào phản hồi
        response.addCookie(cartCookie);

        // Chuyển hướng đến trang chi tiết sản phẩm
        response.sendRedirect("ProductDetailsServlet?productId=" + productId);
    }

}
