package ai.business.analytics.model;

public class Report {
	
	private Long id;
	private String title;
	private String data;

	// Constructors
	public Report() {
	}

	public Report(Long id, String title, String data) {
		this.id = id;
		this.title = title;
		this.data = data;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}