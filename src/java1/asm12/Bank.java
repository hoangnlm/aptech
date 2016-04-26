package java1.asm12;

import java.util.ArrayList;

public class Bank {
	private int bankId;
	private String bankName, branch;
	private ArrayList<Account> accounts;

	public Bank() {
		this(123, "bank", "branch1");
	}

	public Bank(int bankId, String bankName, String branch) {
		setBankId(bankId);
		setBankName(bankName);
		setBranch(branch);
	}

	public void createAccount(String customerName, double accountBalance) throws Exception {
		Account account = new Account(customerName, accountBalance);
		accounts.add(account);
	}

	public String displayAccountDetails(int accountNumber) {
		String result = "";

		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				result += "\nAccount number: " + account.getAccountNumber();
				result += "\nCustomer name: " + account.getCustomerName();
				result += "\nBalance: " + account.getBalance();
				result += "\nBank id: " + getBankId();
				result += "\nBank name: " + getBankName();
				result += "\nBank branch: " + getBranch();
			}
		}

		return result;
	}

	public double withdraw(int accountNumber, double amount) throws Exception {
		double result = 0;
		boolean found = false;

		if (amount < 100)
			throw new IllegalArgumentException("Amount must >= 100!");

		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				if (amount > account.getBalance())
					throw new IllegalArgumentException("Amount must <= balance!");

				account.setBalance(account.getBalance() - amount);
				result = account.getBalance();
				found = true;
				break;
			}
		}

		if (!found)
			throw new IllegalArgumentException("Account not found!");
		
		return result;
	}

	public double deposit(int accountNumber, double amount) throws Exception {
		double result = 0;
		boolean found = false;
		
		if (amount <= 0)
			throw new IllegalArgumentException("Amount must > 0!");

		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				account.setBalance(account.getBalance() + amount);
				System.out.println("Deposit succeeded...");
				System.out.println("Current balance: " + account.getBalance());
				result = account.getBalance();
				found = true;
			}
		}

		if (!found)
			throw new IllegalArgumentException("Account not found!");

		return result;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
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

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
}
