package java2.asm01;

public class Account {
	private static int ac_count;
	private String accountNumber, customerName;
	private double accountBalance;

	public static final int MAX_ACCOUNT = 999;
	public static final double INI_BALANCE = 100;

	public Account() throws Exception {
		this("unknown", INI_BALANCE);
	}

	public Account(String customerName, double accountBalance) throws Exception {
		setAccountNumber();
		setCustomerName(customerName);

		if (accountBalance < INI_BALANCE)
			throw new IllegalArgumentException(
			"Initializing balance must from " + INI_BALANCE + ".");

		setBalance(accountBalance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber() throws Exception {
		if (ac_count > MAX_ACCOUNT)
			throw new IllegalArgumentException("Max " + MAX_ACCOUNT + " accounts!");

		this.accountNumber = String
		.format("AC%0" + Integer.toString(MAX_ACCOUNT).length() + "d", ++ac_count);
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
			throw new InsufficientFundsException("Balance must >= 0!");

		this.accountBalance = balance;
	}
}
