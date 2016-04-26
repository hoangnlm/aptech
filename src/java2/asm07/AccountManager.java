package java2.asm07;

import java.util.Scanner;

public class AccountManager implements Runnable {
	TransferManager transferManager;
	
	public AccountManager(TransferManager transferManager) {
		// TODO Auto-generated constructor stub
		this.transferManager = transferManager;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so tien chuyen lan 1: ");
		int l1 = sc.nextInt();
		System.out.println("Nhap so tien chuyen lan 2: ");
		int l2 = sc.nextInt();
		
		CustomerAccount account1 = new CustomerAccount("Tom", 1000);
		CustomerAccount account2 = new CustomerAccount("Jerry", 2000);
		
		TransferManager transferManager1 = new TransferManager(account1, account2, l1);
		Thread thread1 = new Thread(new AccountManager(transferManager1));
		thread1.start();
		thread1.join();
		
		transferManager1.setTransferAmt(l2);
		Thread thread2 = new Thread(new AccountManager(transferManager1));
		thread2.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nBefore transfer: ");
		System.out.println(transferManager.toString());
		System.out.println();
		System.out.println("After transfer: ");
		transferManager.run();
		System.out.println(transferManager.toString());
	}
}
