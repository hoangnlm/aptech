package mainPkg;

import java.util.ArrayList;

public class Order {
	private static int order_count;
	private String orderId;
	private ArrayList<OrderToy> orderToys = new ArrayList<>();

	public Order() throws Exception {
		setOrderId();
	}

	public void showDetails() {
		System.out.println(String.format("%34s", " ").replace(" ", "-") + " ORDER DETAILS  "
		+ String.format("%35s", " ").replace(" ", "-"));
		System.out.println(String.format("%92s", " ").replace(" ", "-"));
		System.out.printf("%s\t%s\t\t%s\t%s\t%s\t%s\t%s\t%s\n", "No.", "Id", "Name", "Color", "Type", "Price", "OrderQty", "Stock");

		int no = 1;

		for (OrderToy t : getOrderToys()) {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\t%s\t%s\t%s\n",
			no++ + ".", t.getId(), t.getName(), t.getColor(), t.getType(), t.getPrice(), t.getOrderQty(), t.getStock());
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
		System.out.println("Order ID: " + getOrderId());
		System.out.println("Total CD quantity: " + getTotalQuantity());
		System.out
		.println("Total payable amount: " + String.format("$%,.2f", getPayableAmt()));
	}

	public void addToy(OrderToy orderToy ) throws Exception {
		if (orderToy == null)
			throw new IllegalArgumentException("CD cannot be null!");
		orderToys.add(orderToy);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId() throws Exception {
		if (order_count > 999)
			throw new IllegalArgumentException("Maximum 999 orders!");
		orderId = String.format("OR%03d", ++order_count);
	}

	public ArrayList<OrderToy> getOrderToys() {
		return orderToys;
	}

	public void setOrderCds(ArrayList<OrderToy> orderCds) throws Exception {
		if (orderCds.size() == 0)
			throw new IllegalArgumentException("Order cd array size cannot be zero!");

		this.orderToys = orderCds;
	}

	public int getTotalQuantity() {
		int sum = 0;

		for (OrderToy t : getOrderToys()) {
			sum += t.getOrderQty();
		}

		return sum;
	}

	public double getPayableAmt() {
		double payableAmt = 0;

		for (OrderToy t : getOrderToys()) {
			payableAmt += t.getPrice() * t.getOrderQty();
		}

		return payableAmt;
	}
	
	public class Stock{
		public int getStock(String toyId) throws Exception{
			OrderToy orderToy = null;
			
			for (OrderToy o : orderToys) {
				if(o.getId().matches(toyId)){
					orderToy = o;
					break;
				}
			}
			
			if(orderToy == null)
				throw new IllegalArgumentException("Toy ID invalid. Toy not found!");
			
			return orderToy.getStock();
		}
	}
}

class OrderToy extends Toy{
	private int orderQty;

	public OrderToy() throws Exception {
		super();
		setOrderQty(1);
	}
	
	public OrderToy(Toy toy, int orderQty) throws Exception {
		super(toy.getName(), toy.getColor(), toy.getType(), toy.getPrice(), toy.getStock());
		setOrderQty(orderQty);
	}
	
	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) throws Exception {
		if (!(1 <= orderQty && orderQty <= 999))
			throw new IllegalArgumentException("Order quantity must be between [1,999]!");
		this.orderQty = orderQty;
	}
}
