package model;

public class Cover {
	private int coverId;
	private String coverName;
	private String description;
	private String link;
	private int status;
	
	public Cover() {
	}
	
	public Cover(int coverId, String coverName, String description, String link, int status) {
		this.coverId = coverId;
		this.coverName = coverName;
		this.description = description;
		this.link = link;
		this.status = status;
	}

	public int getCoverId() {
		return coverId;
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId;
	}

	public String getCoverName() {
		return coverName;
	}

	public void setCoverName(String coverName) {
		this.coverName = coverName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Cover [coverId=" + coverId + ", coverName=" + coverName + ", description=" + description + ", link="
				+ link + ", status=" + status + "]";
	}
}
