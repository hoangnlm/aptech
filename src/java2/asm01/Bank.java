package mainPkg;

import java.util.ArrayList;

public class Bank {
	private String bankName, branch;
	private ArrayList<Account> accounts;
	public static final double MIN_WITHDRAW = 100; 
	public static final double MIN_DEPOSIT = 100; 

	public Bank() {
		this("bank", "branch1");
	}

	public Bank(String bankName, String branch) {
		accounts = new ArrayList<>();
		setBankName(bankName);
		setBranch(branch);
	}

	public void addAccount(String customerName, double accountBalance) throws Exception {
		Account account = new Account(customerName, accountBalance);
		accounts.add(account);
	}

	public String extractAccountDetails(String accountNumber) {
		accountNumber = accountNumber.trim().toUpperCase();
		String result = "";

		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				result += "\nAccount number: " + account.getAccountNumber();
				result += "\nCustomer name: " + account.getCustomerName();
				result += "\nBalance: " + account.getBalance();
			}
		}

		return result;
	}

	public void withdraw(String accountNumber, double amount) throws Exception {
		accountNumber = accountNumber.trim().toUpperCase();
		boolean found = false;

		if (amount < MIN_WITHDRAW)
			throw new InsufficientFundsException(
			"Withdraw amount minimum: " + MIN_WITHDRAW + "!");

		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				if (amount > account.getBalance())
					throw new InsufficientFundsException(
					"Withdraw amount cannot exceed balance!");

				account.setBalance(account.getBalance() - amount);
				found = true;
				break;
			}
		}

		if (!found)
			throw new IllegalArgumentException("Account not found!");
	}

	public void deposit(String accountNumber, double amount) throws Exception {
		accountNumber = accountNumber.trim().toUpperCase();
		boolean found = false;

		if (amount < MIN_DEPOSIT)
			throw new InsufficientFundsException(
			"Deposit amount minimum: " + MIN_DEPOSIT + "!");

		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				account.setBalance(account.getBalance() + amount);
				found = true;
			}
		}

		if (!found)
			throw new IllegalArgumentException("Account not found!");
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
}
