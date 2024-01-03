package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dal.RecoverDAO;

public class RecoverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");

        Cookie[] cookies = request.getCookies();
        String email = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cemail".equals(cookie.getName())) {
                    email = cookie.getValue();
                    break;
                }
            }
        }

        if (email != null) {
            // Update the password in the 'account' table based on the email in the 'user' table
            RecoverDAO recoverDAO = new RecoverDAO();
            int Id = 0;
			try {
				Id = recoverDAO.getUserIdByEmail(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            if (Id != -1) {
                boolean passwordUpdated = false;
				try {
					passwordUpdated = recoverDAO.updatePassword(Id, newPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                if (passwordUpdated) {
                    // Password updated successfully, you might want to redirect to a login page
                    response.sendRedirect("login.html");
                } else {
                    // Password update failed
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().println("Failed to update password.");
                }
            } else {
                // User not found with the given email
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("User not found with the given email.");
            }
        } else {
            // Email not found in the cookie, handle accordingly
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Email not found in the cookie.");
        }
    }
}
