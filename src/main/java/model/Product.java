package model;

public class Product {
	private int productId;
	private String productName;
	private String sku; // sku là mã sản phẩm đi cùng với ngày sản xuất và ngày hết hạn của sản phẩm
	private String description;
	private double price;
	private int quantityInStock;
	private Manufacturer manufacturer;
	private String productionDate;
	private String expirationDate;
	private SubCategory subcategory;
	private String imageUrl;
	private String status; // có sẵn, hết hàng, đang giảm giá

	public Product() {
	}

	public Product(int productId, String productName, String sku, String description, double price, int quantityInStock,
			Manufacturer manufacturer, String productionDate, String expirationDate, SubCategory subcategory,
			String imageUrl, String status) {
		this.productId = productId;
		this.productName = productName;
		this.sku = sku;
		this.description = description;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.manufacturer = manufacturer;
		this.productionDate = productionDate;
		this.expirationDate = expirationDate;
		this.subcategory = subcategory;
		this.imageUrl = imageUrl;
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public SubCategory getSubCategory() {
		return subcategory;
	}

	public void setCategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", sku=" + sku + ", description="
				+ description + ", price=" + price + ", quantityInStock=" + quantityInStock + ", manufacturer="
				+ manufacturer + ", productionDate=" + productionDate + ", expirationDate=" + expirationDate
				+ ", subcategory=" + subcategory + ", imageUrl=" + imageUrl + ", status=" + status + "]";
	}
}
