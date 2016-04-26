package java1.asm11;

public class Toy implements ITesting {
	private static int count;
	private int stock;
	private String id, name, color, type;
	private double price;

	public Toy() throws Exception {
		this("unknown", "white", "a", 1, 1);
	}

	public Toy(String name, String color, String type, double price, int stock) throws Exception{
		setId();
		setName(name);
		setColor(color);
		setType(type);
		setPrice(price);
		setStock(stock);
	}

	public String showDetails() {
		String kq = "\nToy ID:\t"+getId() + "\n";
		kq += "Toy name:\t"+getName() + "\n";
		kq += "Toy color:\t"+getColor() + "\n";
		kq += "Toy type:\t"+getType() + "\n";
		kq += "Toy price:\t"+getPrice() + "$\n";
		kq += "Toy stock:\t"+getStock() + "\n";
		
		return kq;
	}
	
	@Override
	public void moveObject() {
		// TODO Auto-generated method stub
		System.out.println("Toy has been moved...");
	}

	@Override
	public void stopObject() {
		// TODO Auto-generated method stub
		System.out.println("Toy has been stopped...");

	}

	@Override
	public void startObject() {
		// TODO Auto-generated method stub
		System.out.println("Toy has been started...");

	}

	@Override
	public void turnObject() {
		// TODO Auto-generated method stub
		System.out.println("Toy has been turned...");

	}

	public String getId() {
		return id;
	}

	public void setId() throws Exception {
		if (count > 999)
			throw new IllegalArgumentException("Maximum 999 toys!");
		id = String.format("TO%03d", ++count);
	}
	
	public void setId(String id) throws Exception {
		id = id.trim().toUpperCase();
		if (!id.matches("TO\\d{3}"))
			throw new IllegalArgumentException("Toy id format [TOxxx]!");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		name = name.trim();

		if (name.isEmpty())
			throw new IllegalArgumentException("Toy name cannot be empty!");

		if (!name.matches("[\\dA-z ]{3,12}"))
			throw new IllegalArgumentException("Toy name contains 3-12 normal characters!");

		this.name = name;
	}

	public String getColor() {
		return color.toUpperCase();
	}

	public void setColor(String color) throws Exception {
		color = color.trim().toLowerCase();

		if (color.isEmpty())
			throw new IllegalArgumentException("Toy color cannot be empty!");

		if (!color.matches("white|black|yellow|green"))
			throw new IllegalArgumentException("Toy color: white, black, yellow, green only!");

		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws Exception {
		type = type.trim().toUpperCase();

		if (type.isEmpty())
			throw new IllegalArgumentException("Toy type cannot be empty!");

		if (!type.matches("[ABCD]"))
			throw new IllegalArgumentException("Toy type: A, B, C, D only!");

		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if (!(0 < price && price <= 1000))
			throw new IllegalArgumentException("Price must >0 and <=1000!");

		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (!(0 <= stock && stock <= 999))
			throw new IllegalArgumentException("Stock must be between [0,999]!");
		this.stock = stock;
	}

}
