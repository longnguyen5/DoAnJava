package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class EmailDAO extends DBContext {

    public User checkEmailExists(String email) {
        try {
            String sql = "SELECT * FROM user WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                // Create and return the User object
                return new User(Id, email, firstName, lastName, address, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if the email is not found
    }
}

