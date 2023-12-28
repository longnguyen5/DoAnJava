package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Manufacturer;
import model.Product;
import model.SubCategory;

public class ProductDAO extends DBContext {
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products`;";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				String sku = rs.getString(3);
				String description = rs.getString(4);
				double price = rs.getDouble(5);
				int quantityInStock = rs.getInt(6);
				int manufacturerId = rs.getInt(7);
				ManufacturerDAO md = new ManufacturerDAO();
				Manufacturer manufacturer = md.getManufacturerById(manufacturerId);
				String productionDate = rs.getString(8);
				String expirationDate = rs.getString(9);
				int subcategoryId = rs.getInt(10);
				SubCategoryDAO sd = new SubCategoryDAO();
				SubCategory subcategory = sd.getSubCategoryById(subcategoryId);
				String imageUrl = rs.getString(11);
				String status = rs.getString(12);
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, subcategory, imageUrl, status);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lấy danh sách sản phẩm từ subcategoryId và manufacturerId
	public List<Product> getProductsByCMid(int cid, int mid) {
		List<Product> list = new ArrayList<>();
		SubCategoryDAO cd = new SubCategoryDAO();
		ManufacturerDAO cm = new ManufacturerDAO();
		String sSql = "select * from `products` where 1 = 1";
		if (cid != 0 && mid != 0) {
			sSql = sSql + " AND `subcategoryId` = ? AND `manufacturerId` = ?";
		}
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, cid);
			ps.setInt(2, mid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				String sku = rs.getString(3);
				String description = rs.getString(4);
				double price = rs.getDouble(5);
				int quantityInStock = rs.getInt(6);
				Manufacturer manufacturer = cm.getManufacturerById(mid);
				String productionDate = rs.getString(8);
				String expirationDate = rs.getString(9);
				SubCategory category = cd.getSubCategoryById(cid);
				String imageUrl = rs.getString(11);
				String status = rs.getString(12);
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, category, imageUrl, status);
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductsByCid(int cid) {
		List<Product> list = new ArrayList<>();
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		String sSql = "SELECT p.* FROM `products` p "
				+ "JOIN `subcategories` sc ON p.`subcategoryId` = sc.`subcategoryId` " + "WHERE 1 = 1";

		if (cid != 0) {
			sSql = sSql + " AND sc.`categoryId` = ?";
		}

		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				String sku = rs.getString(3);
				String description = rs.getString(4);
				double price = rs.getDouble(5);
				int quantityInStock = rs.getInt(6);
				ManufacturerDAO cm = new ManufacturerDAO();
				Manufacturer manufacturer = cm.getManufacturerById(rs.getInt(7));
				String productionDate = rs.getString(8);
				String expirationDate = rs.getString(9);

				// Lấy thông tin SubCategory dựa trên subcategoryId
				SubCategory subCategory = subCategoryDAO.getSubCategoryById(rs.getInt("subcategoryId"));

				String imageUrl = rs.getString(11);
				String status = rs.getString(12);

				// Tạo đối tượng Product và thêm vào danh sách
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, subCategory, imageUrl, status);
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
