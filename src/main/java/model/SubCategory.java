package model;

public class SubCategory {
	private int subcategoryId;
	private String subcategoryName;
	private String link;
	private Category category;

	public SubCategory() {
	}

	public SubCategory(int subcategoryId, String subcategoryName, String link, Category category) {
		super();
		this.subcategoryId = subcategoryId;
		this.subcategoryName = subcategoryName;
		this.link = link;
		this.category = category;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subcategoryId=" + subcategoryId + ", subcategoryName=" + subcategoryName + ", link=" + link + ", category="
				+ category + "]";
	}
}
