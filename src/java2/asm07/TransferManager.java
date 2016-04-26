package java2.asm07;

public class TransferManager {
	private CustomerAccount account1, account2;
	private int transferAmt;

	public TransferManager() {
		// TODO Auto-generated constructor stub
	}

	public TransferManager(CustomerAccount account1, CustomerAccount account2,
	int transferAmt) {
		setAccount1(account1);
		setAccount2(account2);
		setTransferAmt(transferAmt);
	}

	@Override
	public String toString() {
		return "Transfer amount: " + getTransferAmt() + "\n" + getAccount1().toString() + "\n"
		+ getAccount2().toString();
	}

	public void run() {
		// TODO Auto-generated method stub
		getAccount1().setBalance(getAccount1().getBalance()-getTransferAmt());
		getAccount2().setBalance(getAccount2().getBalance()+getTransferAmt());
	}

	public int getTransferAmt() {
		return transferAmt;
	}

	public void setTransferAmt(int transferAmt) {
		this.transferAmt = transferAmt;
	}

	public CustomerAccount getAccount1() {
		return account1;
	}

	public void setAccount1(CustomerAccount account1) {
		this.account1 = account1;
	}

	public CustomerAccount getAccount2() {
		return account2;
	}

	public void setAccount2(CustomerAccount account2) {
		this.account2 = account2;
	}
}
