package java1;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java2.DataStructure;

public class ngay2403 {
	public static void main(String[] args) {
		// Ass08
		// garments.addGarment(s);
		// garments.showDetails();

//		String t1 = "cbcdec";
//		String t2 = "12345";
//		String t3 = "derb er cerf erm er ver dem";
		// System.out.println(t1.replace('c', '0'));
		// System.out.println(t1.replace("bcd", t2));
		// System.out.println(Arrays.toString(t3.split("\\ser\\s")));

		// Scanner s = new Scanner(new BufferedInputStream(System.in));
		// StringBuilder str = new StringBuilder(1024);
		// System.out.println("Input string (^q to quit): ");
		//
		// while (s.hasNext()) {
		// str.append(s.nextLine()+"\n");
		//
		// if (str.indexOf("^q")!=-1) {
		// str.setLength(str.indexOf("^q"));
		// break;
		// }
		// }
		//
		// System.out.println(str);
		// System.out.println(1|2|5);
		StringBuilder s = new StringBuilder("01234567890123456789");
//		 s.ensureCapacity(19);
//		s.append("asdfgd");
		 System.out.println(s.capacity());

		// Integer k1 = new Integer(123);
		// int k2 = 123;
		// System.out.println(k1==k2);
		//
		// String c1 = new String("abc");
		// String c2 = "abc";
		// c1 = c2;
		// System.out.println(c1==c2);
		 
		 
		 
		
		
	}
	
}



// Ass 8
class Garment {
	private String id;
	private static int id_count;
	private int stock, orderQty;
	private double price, sales;
	private String type;

	public Garment(Scanner s) {
		setID();
		setStock(s);
		setOrderQty(s);
		setPrice(s);
		setType(s);
		setSales();
	}

	public String showInfo() {
		String kq = "ID:\t\t" + getID() + "\n";
		kq += "Type:\t" + getType() + "\n";
		kq += "Stock:\t" + getStock() + "\n";
		kq += "Price:\t" + String.format("%.2f", getPrice()) + "\n";
		kq += "Quantity:\t" + getOrderQty() + "\n";
		kq += "Sales:\t" + String.format("%.2f", getSales()) + "\n";
		return kq;
	}

	public String getID() {
		return id;
	}

	public void setID() {
		id = String.format("GA%04d", ++id_count);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(Scanner s) {
		String str = "";

		do {
			System.out.println("Input stock: ");
			str = s.nextLine().trim();
		} while (!validateStock(str));

		stock = Integer.parseInt(str);
	}

	public boolean validateStock(String s) {
		String re = "\\d+";
		boolean kq = false;

		if (s.matches(re)) {
			int so = Integer.parseInt(s);
			if (0 < so && so <= 1000) {
				kq = true;
			} else {
				System.out.println("Stock phai >0 va <=1000.");
			}
		} else {
			System.out.println("Stock phai nhap dang so nguyen!");
		}

		return kq;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Scanner s) {
		String str = "";

		do {
			System.out.println("Input order quantity: ");
			str = s.nextLine().trim();
		} while (!validateOrderQty(str));

		orderQty = Integer.parseInt(str);
	}

	public boolean validateOrderQty(String s) {
		String re = "\\d+";
		boolean kq = false;

		if (s.matches(re)) {
			int so = Integer.parseInt(s);
			if (0 < so && so <= 1000) {
				kq = true;
			} else {
				System.out.println("Qty phai >0 va <=1000.");
			}
		} else {
			System.out.println("Qty phai nhap dang so nguyen!");
		}

		return kq;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Scanner s) {
		String str = "";

		do {
			System.out.println("Input price: ");
			str = s.nextLine().trim();
		} while (!validatePrice(str));

		price = Double.parseDouble(str);
	}

	public boolean validatePrice(String s) {
		String re = "^\\d*\\.?\\d*$";
		boolean kq = false;

		if (s.matches(re)) {
			double so = Double.parseDouble(s);
			if (0 < so && so <= 1000) {
				kq = true;
			} else {
				System.out.println("Price phai >0 va <=1000.");
			}
		} else {
			System.out.println("Price phai nhap dang so thap phan!");
		}

		return kq;
	}

	// Type chi duoc 2 loai: A hoac B
	public String getType() {
		return type;
	}

	public void setType(Scanner s) {
		String str = "";

		do {
			System.out.println("Input type: ");
			str = s.nextLine().trim().toUpperCase();
		} while (!validateType(str));

		type = str;
	}

	public boolean validateType(String s) {
		String re = "[AB]";
		boolean kq = false;

		if (s.matches(re)) {
			kq = true;
		} else {
			System.out.println("Type chi duoc 2 loai: A, B!");
		}

		return kq;
	}

	public double getSales() {
		return sales;
	}

	public void setSales() {
		sales = orderQty * price;
	}
}

class Garments {
	private Garment g;
	private ArrayList<Garment> a = new ArrayList<Garment>();

	public void addGarment(Scanner s) {
		String str = "";

		do {
			System.out.println("Input how many garments (1-10 only): ");
			str = s.nextLine().trim();
		} while (!str.matches("[1-9]|10"));

		for (int i = 0; i < Integer.parseInt(str); i++) {
			System.out.println("--------------------------------");
			System.out.println("Input item No." + (i + 1) + ": ");
			g = new Garment(s);
			a.add(g);
		}
	}

	public void showDetails() {
		System.out.println("--------------------------------");
		System.out.println("List garments in the stock: ");

		for (Garment i : a) {
			System.out.println(i.showInfo());
		}
	}
}
