package java2.asm01;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		BankTest bankTest = new BankTest();
		bankTest.run();
//		System.out.println("hoàng nguyễn");
	}

	private Bank bank;
	private Scanner s;
	private String input;

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
		default:
			exit();
			return;
		}

		run(showMenu());
	}

	private void initialize() {
		bank = new Bank();
		s = new Scanner(System.in);
	}

	private void exit() {
		System.out.println("\nGoodbye! See you again! ^^");
	}

	private int showMenu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " BANKING PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		System.out.printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Create an account.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "2.", " ", "Display an account details.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Withdraw money.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Deposit money.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "5.", " ", "Exit.");
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			System.out.printf("%1$8s%2$-15s", " ", "Input 1 - 5:");
			input = s.nextLine().trim();
		} while (!input.matches("[1-5]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(input);
	}

	private void createAccount() {
		do {
			try {
				String customerName;
				double accountBalance;
				
				System.out.println("\nCREATE AN ACCOUNT:");
				System.out.print("Customer name: ");
				customerName = s.nextLine().trim();
				System.out.print("Balance: ");
				accountBalance = Double.parseDouble(s.nextLine());
				bank.addAccount(customerName, accountBalance);
				System.out.println("\nCreate account succeeded...");
				System.out.println("ACCOUNT DETAILS: "+bank.extractAccountDetails(bank.getAccounts().get(bank.getAccounts().size()-1).getAccountNumber()));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				System.out.print("Add more? <y/n> ");
			}
		} while (s.nextLine().trim().toLowerCase().matches("y"));
	}

	private void displayAccountDetails() {
		if (bank.getAccounts().size() == 0) {
			System.out.println("Account list empty!");
		} else {
			do {
				try {
					System.out.println("\nDISPLAY AN ACCOUNT DETAILS:");
					System.out.print("Input account number: ");
					String tmp = bank.extractAccountDetails(s.nextLine().trim());
					System.out.println(tmp.isEmpty()?"Account not found!":tmp);
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
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
