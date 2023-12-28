package model;

public class SubCategory {
	private int subcategoryId;
	private String name;
	private String link;
	private Category category;

	public SubCategory() {
	}

	public SubCategory(int subcategoryId, String name, String link, Category category) {
		super();
		this.subcategoryId = subcategoryId;
		this.name = name;
		this.link = link;
		this.category = category;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "SubCategory [subcategoryId=" + subcategoryId + ", name=" + name + ", link=" + link + ", category="
				+ category + "]";
	}
}
