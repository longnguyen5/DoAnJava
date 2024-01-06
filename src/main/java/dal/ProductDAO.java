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
	public List<Product> getProductByKeyword(String m) {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` where `productName` like '%"+m+"%'";
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
	
	public List<Product> spNoiBat(){
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` order by productId desc limit 0,5;";
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

	public Product getProductById(int id) {
		String sSql = "Select * from `products` where `productId` = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
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
				return product;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public List<Product> getProductsBySubCid(int id) {
		List<Product> list = new ArrayList<>();
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		String sSql = "Select * from `products` where `subcategoryId` = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ps.setInt(1, id);
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
				SubCategory subcategory = sd.getSubCategoryById(id);
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

	public List<Product> getProductByPrice(double min, double max) {
		List<Product> list = new ArrayList<>();
		String sSql = "Select * from `products` where `price` between ? and ?";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sSql);
			ps.setDouble(1, min);
			ps.setDouble(2, max);

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

				SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
				SubCategory subCategory = subCategoryDAO.getSubCategoryById(rs.getInt(10));

				String imageUrl = rs.getString(11);
				String status = rs.getString(12);

				// Tạo đối tượng Product và thêm vào danh sách
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, subCategory, imageUrl, status);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProducts(int currentPage, int pageSize) {
		// Tính toán vị trí bắt đầu của sản phẩm trong kết quả truy vấn
		int startIdx = (currentPage - 1) * pageSize;
		List<Product> products = new ArrayList<>();

		// Thực hiện truy vấn SQL
		// Ví dụ sử dụng JDBC:
		String sql = "SELECT * FROM `products` LIMIT ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, startIdx);
			statement.setInt(2, pageSize);

			ResultSet rs = statement.executeQuery();

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

				SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
				SubCategory subCategory = subCategoryDAO.getSubCategoryById(rs.getInt(10));

				String imageUrl = rs.getString(11);
				String status = rs.getString(12);

				// Tạo đối tượng Product và thêm vào danh sách
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, subCategory, imageUrl, status);
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int getTotalProducts() {
		String sSql = "select count(*) from `products`";
		try {
			PreparedStatement ps = connection.prepareStatement(sSql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public List<Product> getProductsBySubCategoryId(int subcategoryId, int currentPage, int pageSize) {
		// Tính offset để lấy sản phẩm từ vị trí thích hợp
		int offset = (currentPage - 1) * pageSize;
		List<Product> list = new ArrayList<>();
		// Sử dụng offset và pageSize trong truy vấn SQL
		String query = "SELECT * FROM `products` WHERE `subcategoryId` = ? LIMIT ?, ?";

		try {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, subcategoryId);
			preparedStatement.setInt(2, offset);
			preparedStatement.setInt(3, pageSize);
			
			ResultSet rs = preparedStatement.executeQuery();

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

				SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
				SubCategory subCategory = subCategoryDAO.getSubCategoryById(subcategoryId);

				String imageUrl = rs.getString(11);
				String status = rs.getString(12);

				// Tạo đối tượng Product và thêm vào danh sách
				Product product = new Product(productId, productName, sku, description, price, quantityInStock,
						manufacturer, productionDate, expirationDate, subCategory, imageUrl, status);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalProductsBySubCategoryId(int subcategoryId) {
		String query = "SELECT COUNT(*) FROM products WHERE subcategoryId = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, subcategoryId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					// Trả về tổng số sản phẩm của danh mục
					return resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
    public String getFilteredProductHtml(double minPrice, double maxPrice) {
        List<Product> filteredProducts = getProductByPrice(minPrice, maxPrice);

        StringBuilder filteredProductHtml = new StringBuilder();

        for (Product product : filteredProducts) {
            filteredProductHtml.append("<div class=\"col-sm-6 col-lg-4 mb-4\" data-aos=\"fade-up\">");
            filteredProductHtml.append("<div class=\"block-4 text-center border\">");
            filteredProductHtml.append("<figure class=\"block-4-image\">");
            filteredProductHtml.append("<a href=\"ProductDetailsServlet?productId=")
                    .append(product.getProductId()).append("\"><img src=\"").append(product.getImageUrl())
                    .append("\" alt=\"").append(product.getProductName()).append("\" class=\"img-fluid\"></a>");
            filteredProductHtml.append("</figure>");
            filteredProductHtml.append("<div class=\"block-4-text p-4\">");
            filteredProductHtml.append("<h3><a href=\"ProductDetailsServlet?productId=")
                    .append(product.getProductId()).append("\">")
                    .append(product.getProductName().length() > 20 ?
                            product.getProductName().substring(0, 20) + "..." : product.getProductName())
                    .append("</a></h3>");
            filteredProductHtml.append("<p class=\"mb-0\">")
                    .append(product.getDescription().length() > 50 ?
                            product.getDescription().substring(0, 50) + "..." : product.getDescription())
                    .append("</p>");
            filteredProductHtml.append("<p class=\"text-primary font-weight-bold\">")
                    .append(product.getPrice()).append(" VNĐ</p>");
            filteredProductHtml.append("</div></div></div>");
        }

        return filteredProductHtml.toString();
    }
    
    public String getSortedProductsHtml(List<Product> sortedProducts) {
    	StringBuilder filteredProductHtml = new StringBuilder();
    	for (Product product : sortedProducts) {
            filteredProductHtml.append("<div class=\"col-sm-6 col-lg-4 mb-4\" data-aos=\"fade-up\">");
            filteredProductHtml.append("<div class=\"block-4 text-center border\">");
            filteredProductHtml.append("<figure class=\"block-4-image\">");
            filteredProductHtml.append("<a href=\"ProductDetailsServlet?productId=")
                    .append(product.getProductId()).append("\"><img src=\"").append(product.getImageUrl())
                    .append("\" alt=\"").append(product.getProductName()).append("\" class=\"img-fluid\"></a>");
            filteredProductHtml.append("</figure>");
            filteredProductHtml.append("<div class=\"block-4-text p-4\">");
            filteredProductHtml.append("<h3><a href=\"ProductDetailsServlet?productId=")
                    .append(product.getProductId()).append("\">")
                    .append(product.getProductName().length() > 20 ?
                            product.getProductName().substring(0, 20) + "..." : product.getProductName())
                    .append("</a></h3>");
            filteredProductHtml.append("<p class=\"mb-0\">")
                    .append(product.getDescription().length() > 50 ?
                            product.getDescription().substring(0, 50) + "..." : product.getDescription())
                    .append("</p>");
            filteredProductHtml.append("<p class=\"text-primary font-weight-bold\">")
                    .append(product.getPrice()).append(" VNĐ</p>");
            filteredProductHtml.append("</div></div></div>");
        }
    	return filteredProductHtml.toString();
    }
    
    public List<Product> getProductNameAcs() {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` order by productName asc;";
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
    public List<Product> getProductNameDesc() {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` order by productName desc;";
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
    public List<Product> getProductPriceAcs() {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` order by price asc;";
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
    public List<Product> getProductPriceDesc() {
		List<Product> list = new ArrayList<>();
		String sSql = "select * from `products` order by price desc;";
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
}
