package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO extends DBContext {
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		try {
			String sSql = "select * from `categories`";
			PreparedStatement ps = connection.prepareStatement(sSql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("categoryId");
				String name = rs.getString("categoryName");
				String link = rs.getString("link");
				int status = rs.getInt("status");
				Category category = new Category(id, name, link, status);
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category getCategoryById(int id) {
		try {
			String sSql = "select * from `categories` where `categoryId` = ?";
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("categoryName");
				String link = rs.getString("link");
				int status = rs.getInt("status");
				return new Category(id, name, link, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Category c) {
		String sql = "INSERT INTO `store2023`.`categories`\r\n"
				+ "(`categoryId`,\r\n"
				+ "`categoryName`,\r\n"
				+ "`link`,\r\n"
				+ "`status`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?);";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, c.getCategoryId());
			ps.setString(2, c.getCategoryName());
			ps.setString(3, c.getLink());
			ps.setInt(4, c.getStatus());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Category c) {
		String sql = "UPDATE `store2023`.`categories`\r\n"
				+ "SET\r\n"
				+ "`categoryName` = ?,\r\n"
				+ "`link` = ?,\r\n"
				+ "`status` = ?\r\n"
				+ "WHERE `categoryId` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, c.getCategoryName());
			ps.setString(2, c.getLink());
			ps.setInt(3, c.getStatus());
			ps.setInt(4, c.getCategoryId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM `store2023`.`categories`\r\n"
				+ "WHERE `categoryId` =?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}