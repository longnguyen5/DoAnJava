package model;

public class Category {
	private int categoryId;
	private String categoryName;
	private String link;
	private int status;
	
	
	public Category() {
	}


	public Category(int categoryId, String categoryName, String link, int status) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.link = link;
		this.status = status;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", link=" + link + ", status="
				+ status + "]";
	}

	

}
