package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.SubCategory;

public class SubCategoryDAO extends DBContext {
	public List<SubCategory> getAll() {
		List<SubCategory> list = new ArrayList<>();
		String sSql = "Select * from `subcategories`;";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int subcategoryId = rs.getInt("subcategoryId");
				String name = rs.getString("subcategoryName");
				String link = rs.getString("link");

				int categoryId = rs.getInt("categoryId");
				CategoryDAO cd = new CategoryDAO();
				Category c = cd.getCategoryById(categoryId);

				SubCategory sc = new SubCategory(subcategoryId, name, link, c);
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public SubCategory getSubCategoryById(int id) {
		String sSql = "Select * from `subcategories` where `subcategoryId` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("subcategoryName");
				String link = rs.getString("link");

				int categoryId = rs.getInt("categoryId");
				CategoryDAO cd = new CategoryDAO();
				Category c = cd.getCategoryById(categoryId);

				return new SubCategory(id, name, link, c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
