package java1.asm12;

import java.util.Random;

public class Account {
	private int accountNumber;
	private String customerName;
	private double accountBalance;
	
	public Account() throws Exception {
		this(123, "unknown", 0);
		Random random = new Random();
		setAccountNumber(random.nextInt(899)+100);
	}

	public Account(String customerName, double accountBalance) throws Exception{
		Random random = new Random();
		setAccountNumber(random.nextInt(899)+100);
		setCustomerName(customerName);
		
		if(accountBalance<100)
			throw new IllegalArgumentException("Initializing balance must from 100.");
		
		setBalance(accountBalance);
	}
	
	public Account(int accountNumber, String customerName, double accountBalance) throws Exception{
		setAccountNumber(accountNumber);
		setCustomerName(customerName);
		
		if(accountBalance<100)
			throw new IllegalArgumentException("Initializing balance must from 100.");
		
		setBalance(accountBalance);
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) throws Exception {
		customerName = customerName.trim();
		
		if(customerName.isEmpty())
			throw new IllegalArgumentException("Customer name cannot be empty!");
		
		if(!customerName.matches("[A-z\\d ]{3,12}"))
			throw new IllegalArgumentException("Customer name contains 3-12 normal characters.");
		
		this.customerName = customerName;
	}

	public double getBalance() {
		return accountBalance;
	}

	public void setBalance(double balance) throws Exception{
		if(balance <0)
			throw new IllegalArgumentException("Balance must >=0!");
		
		this.accountBalance = balance;
	}
}
