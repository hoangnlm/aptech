package java1;

import java.util.Scanner;

//Ass 06
class Book {
	private static int bookID = 0;
	private int numberOfTickets;
	private double price;
	private String departureDate, cabinType, destination;

	Book(int numberOfTickets, double price, String departureDate, String cabinType, String destination) {
		bookID++;
		this.numberOfTickets = numberOfTickets;
		this.price = price;
		this.departureDate = departureDate;
		this.cabinType = cabinType;
		this.destination = destination;
	}

	public double totalPrice() {
		return numberOfTickets * price;
	}

	public void ticketConfirmation() {
		System.out.println("---------------");
		System.out.println("Booking information: ");
		System.out.println("Booking ID: " + bookID);
		System.out.println("Number of tickets: " + numberOfTickets);
		System.out.println("Price: " + price);
		System.out.println("Departure date: " + departureDate);
		System.out.println("Cabin type: " + cabinType);
		System.out.println("Destination: " + destination);
		System.out.println("Total price: " + totalPrice());
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}

// Ass 07
class Login {
	private String username, password, designation;

	public Login() {

	}

	public Login(String username, String password, String designation) {
		this.username = username;
		this.password = password;
		this.designation = designation;
	}

	/**
	 * Function validate existing username and password.
	 */
	public void validate() {
		if (!username.equals("hoang")) {
			System.out.println("Invalid username!");
		} else if (!password.equals("12345")) {
			System.out.println("Invalid password!");
		} else {
			System.out.println("Successful validation!");
		}
	}

	public String getUsername() {
		return username;
	}

	public boolean setUsername(String username) {
		boolean kq = true;
		if (username.isEmpty()) {
			System.out.println("Username khong duoc rong!");
			kq = false;
		} else if (username.length() < 5) {
			System.out.println("Username phai tu 5 ky tu tro len!");
			kq = false;
		} else {
			this.username = username;
		}
		return kq;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		boolean kq = true;
		if (password.isEmpty()) {
			System.out.println("Password khong duoc rong!");
			kq = false;
		} else if (password.length() < 5) {
			System.out.println("Password phai tu 5 ky tu tro len!");
			kq = false;
		} else {
			this.password = password;
		}
		return kq;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}

public class ngay2203 {

	public static void main(String[] args) {
		// Book book = new Book(2, 12.23, "2016/03/03", "A", "Tokyo");
		// book.ticketConfirmation();
		// Book book2 = new Book(2, 12.23, "2016/03/03", "A", "Tokyo");
		// book2.ticketConfirmation();
		//
		// System.out.println("-------------------");
		// Login login = new Login("hoang", "123", "employee");
		// login.validate();

		Login login = new Login();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Input username: ");
		} while (!login.setUsername(scanner.nextLine().trim()));

		do {
			System.out.println("Input password: ");
		} while (!login.setPassword(scanner.nextLine().trim()));

		login.validate();

	}

}
