package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DBContext{
	public List<User> getAllUser(){
		List<User> list = new ArrayList<>();
		String sql = "select * from `user`";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("Id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address"); 
				String phone = rs.getString("phone");
				User u = new User(userId, firstName, lastName, email, address, phone);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
