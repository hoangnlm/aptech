package mainPkg;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lastAccountNumber = 1;
	private ArrayList<Account> accounts;
	public static final double MIN_WITHDRAW = 100; 
	public static final double MIN_DEPOSIT = 100; 

	public Bank() {
		accounts = new ArrayList<>();
	}

	public String getLastAccountNumber() {
		return String.format("AC%03d", lastAccountNumber++);
	}

	public void addAccount(Account account) throws Exception {
		accounts.add(account);
		
	}

	public String extractAccountDetails(String accountNumber) {
//		String result = "";
//
//		for (Account account : accounts) {
//			if (account.getAccountNumber().equals(accountNumber)) {
//				result += "\nAccount number: " + account.getAccountNumber();
//				result += "\nCustomer name: " + account.getCustomerName();
//				result += "\nBalance: " + account.getBalance();
//			}
//		}

		return accounts.stream().filter(a->a.getAccountNumber().equals(accountNumber)).toArray()[0].toString();
	}

	public void withdraw(String accountNumber, double amount) throws Exception {
		accountNumber = accountNumber.trim().toUpperCase();
		boolean found = false;

		if (amount < MIN_WITHDRAW)
			throw new Exception(
			"Withdraw amount minimum: " + MIN_WITHDRAW + "!");

		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				if (amount > account.getBalance())
					throw new Exception(
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
			throw new Exception(
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String kq = "";
		for (Account account : accounts) {
			kq += account.toString();
		}
		
		return kq;
	}
}
