package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dal.DBContext;
import model.User;

public class RecoverDAO extends DBContext {

    public int getUserIdByEmail(String email) throws SQLException {
        try (
             PreparedStatement ps = connection.prepareStatement("SELECT Id FROM user WHERE email = ?")) {

            ps.setString(1, email);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Id");
                }
            }
        }
        return -1; // Return -1 if the user with the given email is not found
    }

    public boolean updatePassword(int Id, String newPassword) throws SQLException {
        try (
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE account SET password = ? WHERE Id = ?")) {

            ps.setString(1, newPassword);
            ps.setInt(2, Id);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
