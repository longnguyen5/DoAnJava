package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO extends DBContext {

    public Account check(String username, String password) {
        String sql = "SELECT username, password, role FROM account WHERE username = ? AND password = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("username");
                String pass = rs.getString("password");
                int rol = rs.getInt("role");

                // Create an Account object with the retrieved data
                Account a = new Account(name, pass, rol);
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

