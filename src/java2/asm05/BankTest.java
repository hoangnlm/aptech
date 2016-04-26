package mainPkg;

import java.util.Scanner;

public class BankTest extends IOUtils2 {

	public static void main(String[] args) {
		BankTest bankTest = new BankTest();
		bankTest.run();
//		System.out.println("hoàng nguyễn");
	}

	private Bank bank;
	private Scanner s;
	private String input;

	public BankTest() {
		super();
	}
	
	public void run() {
		run(0);
	}

	private void run(int item) {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			createAccount();
			break;
		case 2:
			displayAccountDetails();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			deposit();
			break;
		case 5:
			displayAll();
			break;
		default:
			exit();
			return;
		}

		run(showMenu());
	}

	private void initialize() {
		bank = readObjectStream();
		bank = bank==null?new Bank(): bank;
		s = new Scanner(System.in);
	}

	private void exit() {
		System.out.println("\nGoodbye! See you again! ^^");
	}

	private int showMenu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " BANKING PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		System.out.printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Create a new account.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "2.", " ", "Display an account details.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Withdraw money.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Deposit money.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "5.", " ", "Display list.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "6.", " ", "Exit.");
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			System.out.printf("%1$8s%2$-15s", " ", "Input 1 - 6:");
			input = s.nextLine().trim();
		} while (!input.matches("[1-6]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(input);
	}

	private void createAccount() {
		do {
			try {
				System.out.println("\nCREATE AN ACCOUNT:");
				String accountNumber = bank.getLastAccountNumber();
				System.out.print("Customer name: ");
				String customerName = s.nextLine().trim();
				System.out.print("Balance: ");
				double accountBalance = Double.parseDouble(s.nextLine());
				Account account = new Account(accountNumber, customerName, accountBalance);
				bank.addAccount(account);
				writeObjectStream(bank);
				System.out.println("\nCreate account succeeded...");
				System.out.println("ACCOUNT DETAILS: "+bank.extractAccountDetails(bank.getAccounts().get(bank.getAccounts().size()-1).getAccountNumber()));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				System.out.print("Add more? <y/n> ");
			}
		} while (s.nextLine().trim().toLowerCase().matches("y"));
	}

	private void displayAll(){
		if (bank.getAccounts().size() == 0) {
			System.out.println("Account list empty!");
		} else {
			System.out.println(bank.toString());
		}
	}
	private void displayAccountDetails() {
		if (bank.getAccounts().size() == 0) {
			System.out.println("Account list empty!");
		} else {
			do {
				try {
					System.out.println("\nDISPLAY AN ACCOUNT DETAILS:");
					System.out.print("Input account number: ");
					String tmp = bank.extractAccountDetails(s.nextLine().trim().toUpperCase());
					System.out.println(tmp);
				} catch (Exception e) {
					System.out.println("Account not found!");
				} finally {
					System.out.print("\nDisplay more? <y/n> ");
				}
			} while (s.nextLine().trim().toLowerCase().matches("y"));
		}
	}

	private void withdraw() {
		if (bank.getAccounts().size() == 0) {
			System.out.println("Account list empty!");
		} else {
			do {
				try {
					System.out.println("\nWITHDRAW MONEY:");
					System.out.print("Input account number: ");
					String accNo = s.nextLine().trim();
					System.out.println("Input amount to withdraw: ");
					double amt = Double.parseDouble(s.nextLine());
					bank.withdraw(accNo, amt);
					writeObjectStream(bank);
					System.out.println("\nWithdraw succeeded...");
					System.out.println("ACCCOUNT DETAILS: \n" + bank.extractAccountDetails(accNo));
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				} finally {
					System.out.print("\nWithdraw more? <y/n> ");
				}
			} while (s.nextLine().trim().toLowerCase().matches("y"));
		}
	}

	private void deposit() {
		if (bank.getAccounts().size() == 0) {
			System.out.println("Account list empty!");
		} else {
			do {
				try {
					System.out.println("\nDEPOSIT MONEY:");
					System.out.print("Input account number: ");
					String accNo = s.nextLine();
					System.out.println("Input amount to deposit: ");
					double amt = Double.parseDouble(s.nextLine());
					bank.deposit(accNo, amt);
					writeObjectStream(bank);
					System.out.println("\nDeposit succeeded...");
					System.out.println("ACCCOUNT DETAILS: \n" + bank.extractAccountDetails(accNo));
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				} finally {
					System.out.print("\nDeposit more? <y/n> ");
				}
			} while (s.nextLine().trim().toLowerCase().matches("y"));
		}
	}
}
