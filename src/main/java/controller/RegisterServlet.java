package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dal.RegisterDAO;
import model.Account;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    String confirmPassword = request.getParameter("confirmPassword");
		    String email = request.getParameter("email");
		    String firstName = request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String address = request.getParameter("address");
		    String phone = request.getParameter("phone");

		    // Check if passwords match
		    if (!password.equals(confirmPassword)) {
		        request.setAttribute("error", "Passwords do not match");
		        request.getRequestDispatcher("create-account.html").forward(request, response);
		        return;
		    }

		    // Create Account and User objects
		    Account account = new Account(username, password, 1); // Assuming role 1 is a regular user
		    User user = new User(0, email, firstName, lastName, address, phone);

		    RegisterDAO registerDAO = new RegisterDAO();

		    try {
		        if (registerDAO.usernameExists(username)) {
		            request.setAttribute("error", "Username already exists");
		            request.getRequestDispatcher("create-account.html").forward(request, response);
		        } else {
		            registerDAO.registerUser(user, account);
		            response.sendRedirect("registration-success.html");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        request.setAttribute("error", "Registration failed. Please try again.");
		        request.getRequestDispatcher("create-account.html").forward(request, response);
		    }
		}
	}

