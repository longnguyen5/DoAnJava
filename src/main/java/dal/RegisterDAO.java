package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;
import model.User;
import dal.DBContext;

public class RegisterDAO extends DBContext {

    public boolean usernameExists(String username) throws SQLException {
        String sql = "SELECT * FROM account WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet resultSet = ps.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public boolean emailExists(String email) throws SQLException {
        String sql = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet resultSet = ps.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public void registerUser(User user, Account account) throws SQLException {
        String insertAccountSQL = "INSERT INTO account (username, password, role) VALUES (?, ?, 1)";
        String insertUserSQL = "INSERT INTO user (firstname, lastname, email, address, phone, Id) VALUES (?, ?, ?, ?, ?, ?)";

        try (
            PreparedStatement accountStatement = connection.prepareStatement(insertAccountSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement userStatement = connection.prepareStatement(insertUserSQL)
        ) {
            accountStatement.setString(1, account.getusername());
            accountStatement.setString(2, account.getpassword());

            int affectedRows = accountStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating account failed, no rows affected.");
            }

            try (ResultSet generatedKeys = accountStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int accountId = generatedKeys.getInt(1);

                    userStatement.setString(1, user.getFirstName());
                    userStatement.setString(2, user.getLastName());
                    userStatement.setString(3, user.getEmail());
                    userStatement.setString(4, user.getAddress());
                    userStatement.setString(5, user.getPhone());
                    userStatement.setInt(6, accountId);

                    userStatement.executeUpdate();
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }
        }
    }
}