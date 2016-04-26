package mainPkg;

public class CustomerAccount {
	private String accountName;
	private int balance;
	
	public CustomerAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerAccount(String accountName, int balance) {
		this.accountName = accountName;
		this.balance = balance;
	}



	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Account name: "+getAccountName()+", balance: "+getBalance()+"]";
	}
}
