package java2.asm11;

public class Product {
	private String name;
	private int id, number;

	public Product(String name, int number) {
		setName(name);
		setNumber(number);
	}

	public Product(int id, String name, int number) {
		setId(id);
		setName(name);
		setNumber(number);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product["+getName()+", "+getNumber()+"]";
	}
}
