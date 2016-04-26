package cdPkg;

public class CompactDisc {
	private static int cd_count;
	private String id, name, type, artist;
	private double price;

	public CompactDisc() throws Exception {
		this("unknown", "a", "unknown", 1);
	}

	public CompactDisc(String name, String type, String artist, double price)
	throws Exception {
		setId();
		setName(name);
		setType(type);
		setArtist(artist);
		setPrice(price);
	}
	
	public CompactDisc(String id, String name, String type, String artist, double price)
	throws Exception {
		setId(id);
		setName(name);
		setType(type);
		setArtist(artist);
		setPrice(price);
	}

	public String extractInfo() {
		String kq = "ID:\t\t\t" + getId() + "\n";
		kq += "Name:\t\t" + getName() + "\n";
		kq += "Type:\t\t" + getType() + "\n";
		kq += "Artist:\t\t" + getArtist() + "\n";
		kq += "Price:\t\t" + String.format("%.2f$", getPrice()) + "\n";
		kq += "Discount:\t\t" + String.format("%.0f", getDiscount() * 100) + "%\n";
		return kq;
	}

	public String getId() {
		return id;
	}

	public void setId() throws Exception {
		if (cd_count > 999)
			throw new IllegalArgumentException("Maximum 999 CD!");
		id = String.format("CD%03d", ++cd_count);
	}
	
	public void setId(String id) throws Exception {
		id = id.trim().toUpperCase();
		
		if (!id.matches("CD\\d{3}"))
			throw new IllegalArgumentException("CD ID format [CDxxx]!");
		
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		name = name.trim();

		if (name.isEmpty())
			throw new IllegalArgumentException("CD name cannot be empty!");

		if (!name.matches("[\\dA-z ]{3,12}"))
			throw new IllegalArgumentException("CD name contains 3-12 normal characters!");

		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws Exception {
		type = type.trim().toUpperCase();

		if (type.isEmpty())
			throw new IllegalArgumentException("CD type cannot be empty!");

		if (!type.matches("[ABCD]"))
			throw new IllegalArgumentException("CD type: A, B, C, D only!");

		this.type = type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) throws Exception {
		artist = artist.trim();

		if (artist.isEmpty())
			throw new IllegalArgumentException("Artist cannot be empty!");

		if (!artist.matches("[\\dA-z ]{3,12}"))
			throw new IllegalArgumentException("Artist name contains 3-12 normal characters!");

		this.artist = artist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if (!(0 < price && price <= 1000))
			throw new IllegalArgumentException("Price must >0 and <=1000!");

		this.price = price;
	}

	public double getDiscount() {
		double discount = 0;

		switch (type.toUpperCase()) {
		case "A":
			discount = 0;
			break;
		case "B":
			discount = 0.1;
			break;
		case "C":
			discount = 0.2;
			break;
		case "D":
			discount = 0.5;
			break;
		}

		return discount;
	}
}
