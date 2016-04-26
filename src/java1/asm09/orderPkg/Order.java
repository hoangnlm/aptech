package orderPkg;

import java.util.ArrayList;

import cdPkg.CompactDisc;

public class Order {
	private static int order_count, cust_count;
	private String orderId, custId, custName;
	private ArrayList<OrderToy> orderCds = new ArrayList<>();

	public Order() throws Exception {
		this("unknown");
	}

	public Order(String custName) throws Exception {
		setOrderId();
		setCustId();
		setCustName(custName);
	}

	public void showDetails() {
		System.out.println(String.format("%34s", " ").replace(" ", "-") + " ORDER DETAILS  "
		+ String.format("%35s", " ").replace(" ", "-"));
		System.out.println(String.format("%92s", " ").replace(" ", "-"));
		System.out.printf("%1$-5s%2$-12s%3$-9s%4$-8s%5$-8s%6$-10s%7$-15s%8$-10s\n", "No.", "CD_Name",
		"CD_Type", "CD_Dis", "CD_Qty", "CD_Price", "CD_Pay", "CD_ID");
		System.out.println(String.format("%92s", " ").replace(" ", "-"));

		int no = 1;

		for (OrderToy cd : getOrderCds()) {
			System.out.printf("%1$-6s%2$-15s%3$-10s%4$-10.2f%5$-8d$%6$-,8.2f$%7$-,15.2f%8$-10s\n",
			no++ + ".", cd.getName(), cd.getType(), cd.getDiscount(), cd.getQty(),
			cd.getPrice(), cd.getPrice() * cd.getQty() * (1 - cd.getDiscount()), cd.getId());
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
		System.out.println("Order ID: " + getOrderId());
		System.out.println("Customer ID: " + getCustId());
		System.out.println("Customer name: " + getCustName());
		System.out.println("Total CD quantity: " + getTotalQuantity());
		System.out
		.println("Total payable amount: " + String.format("$%,.2f", getPayableAmt()));
	}

	public void addCd(OrderToy cd) throws Exception {
		if (cd == null)
			throw new IllegalArgumentException("CD cannot be null!");
		orderCds.add(cd);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId() throws Exception {
		if (order_count > 999)
			throw new IllegalArgumentException("Maximum 999 orders!");
		orderId = String.format("OR%03d", ++order_count);
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId() throws Exception {
		if (cust_count > 999)
			throw new IllegalArgumentException("Maximum 999 customers!");
		custId = String.format("CU%03d", ++cust_count);
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) throws Exception {
		custName = custName.trim();

		if (custName.isEmpty())
			throw new IllegalArgumentException("Customer name cannot be empty!");

		if (!custName.matches("[\\dA-z ]+"))
			throw new IllegalArgumentException(
			"Customer name cannot contain special characters!");

		if (!custName.matches(".{3,12}"))
			throw new IllegalArgumentException("Customer name only 3-12 characters!");

		this.custName = custName;
	}

	public ArrayList<OrderToy> getOrderCds() {
		return orderCds;
	}

	public void setOrderCds(ArrayList<OrderToy> orderCds) throws Exception {
		if (orderCds.size() == 0)
			throw new IllegalArgumentException("Order cd array size cannot be zero!");

		this.orderCds = orderCds;
	}

	public int getTotalQuantity() {
		int sum = 0;

		for (OrderToy cd : getOrderCds()) {
			sum += cd.getQty();
		}

		return sum;
	}

	public double getPayableAmt() {
		double payableAmt = 0;

		for (OrderToy cd : getOrderCds()) {
			payableAmt += cd.getPrice() * cd.getQty() * (1 - cd.getDiscount());
		}

		return payableAmt;
	}
}
