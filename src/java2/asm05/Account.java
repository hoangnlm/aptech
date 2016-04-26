package java2.asm05;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNumber, customerName;
	private double accountBalance;

	public static final double INI_BALANCE = 100;

//	public Account() throws Exception {
//		this("unknown", INI_BALANCE);
//	}

	public Account(String accountNumber, String customerName, double accountBalance) throws Exception {
		setAccountNumber(accountNumber);
		setCustomerName(customerName);

		if (accountBalance < INI_BALANCE)
			throw new IllegalArgumentException(
			"Initializing balance must from " + INI_BALANCE + ".");

		setBalance(accountBalance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) throws Exception {
		accountNumber = accountNumber.trim().toUpperCase();
		
		if (!accountNumber.matches("AC\\d{3}"))
			throw new IllegalArgumentException("Valid account number format [ACxxx]!");

		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) throws Exception {
		customerName = customerName.trim();

		if (customerName.isEmpty())
			throw new IllegalArgumentException("Customer name cannot be empty!");

		if (!customerName.matches("[A-z ]{3,12}"))
			throw new IllegalArgumentException(
			"Customer name must contain 3-12 alphabet characters.");

		this.customerName = customerName;
	}

	public double getBalance() {
		return accountBalance;
	}

	public void setBalance(double balance) throws Exception
	{
		if (balance < 0)
			throw new Exception("Balance must >= 0!");

		this.accountBalance = balance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account ["+getAccountNumber()+", "+getCustomerName()+", "+getBalance()+"]\n";
	}
}
