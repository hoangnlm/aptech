package java1.test;

public class Book {
	private String type, title;
	private int price, edition;
	
	public Book() {
		this("unknown", "unknown", 0, 1);
	}

	public Book(String type, String title, int price, int edition) {
		setType(type);
		setTitle(title);
		setPrice(price);
		setEdition(edition);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}
}
