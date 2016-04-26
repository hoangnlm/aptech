package orderPkg;

import cdPkg.CompactDisc;

public class OrderToy extends CompactDisc {
	private int qty;

	public OrderToy(String id, String name, String type, String artist, double price, int qty) throws Exception {
		super(id, name, type, artist, price);
		setQty(qty);
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) throws Exception {
		if (!(1 <= qty && qty <= 999))
			throw new IllegalArgumentException("Order quantity must be between [1,999]!");
		this.qty = qty;
	}
}
