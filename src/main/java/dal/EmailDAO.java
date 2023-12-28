package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class EmailDAO extends DBContext {

	public User checkEmailExists(String email) {
	    try {
	        String sql = "SELECT * FROM users WHERE email = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, email);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int userId = resultSet.getInt("userId");
	            String firstName = resultSet.getString("firstName");
	            String lastName = resultSet.getString("lastName");
	            String address = resultSet.getString("address");
	            String phone = resultSet.getString("phone");


	            return new User(userId, email, firstName, lastName, address, phone);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}


//    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
//        try {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (preparedStatement != null) {
//                preparedStatement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
