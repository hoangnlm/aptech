package orderPkg;

import java.util.ArrayList;
import java.util.Scanner;

import cdPkg.CompactDisc;

public class BuyCD {
	public static void main(String[] args) {
		BuyCD buyCD = new BuyCD();
		buyCD.run();

	}

	private ArrayList<CompactDisc> cds;
	private ArrayList<Order> orders;
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
			addCd();
			break;
		case 2:
			viewCDList();
			break;
		case 3:
			buyCd();
			break;
		case 4:
			checkOrder();
			break;
		default:
			exit();
			return;
		}
		
		run(showMenu());
	}

	private void initialize() {
		cds = new ArrayList<>();
		orders = new ArrayList<>();
		s = new Scanner(System.in);
	}

	private void exit() {
		System.out.println("\nGoodbye! See you again! ^^");
	}

	private int showMenu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " CD PURCHASE PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		System.out.printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Add a CD.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "2.", " ", "View CD list.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Buy CD(s).");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Check an order.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "5.", " ", "Exit.");
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			System.out.printf("%1$8s%2$-15s", " ", "Input 1 - 5:");
			input = s.nextLine().trim();
		} while (!input.matches("[1-5]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(input);
	}

	private void addCd() {
		CompactDisc cd;

		try {
			cd = new CompactDisc();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		System.out.println(String.format("%2s", " ").replace(" ", "-") + " ADD A CD "
		+ String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-14s", "1.", " ", "CD name:");
				input = s.nextLine().trim();
				cd.setName(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "2.", " ", "CD type:");
				input = s.nextLine().trim();
				cd.setType(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "3.", " ", "CD artist:");
				input = s.nextLine().trim();
				cd.setArtist(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "4.", " ", "CD price:");
				input = s.nextLine();
				cd.setPrice(Double.parseDouble(input));
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		cds.add(cd);

		do {
			System.out.print("\nAdding 01 CD successfully! Wanna add more? (y/n)  ");
			input = s.nextLine().trim().toLowerCase();
		} while (!input.matches("[yn]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		if (input.equals("y")) {
			addCd();
		}
	}

	private void viewCDList() {
		if (cds.size() > 0) {
			System.out.println(String.format("%34s", " ").replace(" ", "-") + " CD LIST "
			+ String.format("%35s", " ").replace(" ", "-"));
			System.out.println(String.format("%100s", " ").replace(" ", "-"));
			System.out.printf("%1$-10s%2$-12s%3$-15s%4$-10s%5$-15s%6$12s%7$15s\n", "No.",
			"CD_ID", "CD_Name", "CD_Type", "CD_Price", "CD_Dis", "CD_Artist");
			System.out.println(String.format("%100s", " ").replace(" ", "-"));

			for (int i = 0; i < cds.size(); i++) {
				CompactDisc cd = cds.get(i);
				System.out.printf("%1$-8s%2$-15s%3$-15s%4$-10s$%5$-10.2f%6$10.0f%%%7$15s\n",
				(i + 1) + ".", cd.getId(), cd.getName(), cd.getType(), cd.getPrice(),
				cd.getDiscount() * 100, cd.getArtist());
			}
		} else {
			System.out.println("CD list is EMPTY! Please add some CDs first!");
		}

		System.out.println(String.format("%100s", " ").replace(" ", "-"));
	}

	private void buyCd() {
		Order order;

		try {
			order = new Order();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		if (cds.size() > 0) {
			System.out.println(String.format("%10s", " ").replace(" ", "-") + " BUY A CD "
			+ String.format("%10s", " ").replace(" ", "-"));
			System.out.println(String.format("%40s", " ").replace(" ", "-"));

			do {
				try {
					System.out.printf("%1$5s%2$5s%3$-15s", "1.", " ", "Customer name:");
					input = s.nextLine().trim();
					order.setCustName(input);
					break;
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
			} while (true);

			do {
				boolean found = false; // Tim thay CD trong CD list hay khong
				boolean succeed = false; // Add CD vao order thanh cong hay
											// khong
				OrderToy orderCd = null;

				// Tim CD theo id hoac name
				do {
					System.out.printf("%1$5s%2$5s%3$-15s", "2.", " ", "CD ID/name to buy: ");
					input = s.nextLine().trim();

					for (CompactDisc cd : cds) {
						if (cd.getId().matches(input.toUpperCase())
						|| cd.getName().matches(input)) {
							try {
								orderCd = new OrderToy(cd.getId(), cd.getName(), cd.getType(),
								cd.getArtist(), cd.getPrice(), 1);
							} catch (Exception e1) {
								System.out.println("Error: " + e1.getMessage());
								return;
							}
							found = true;
							break;
						}
					}

					if (!found) {
						do {
							System.out.print("CD not found! Try again? (y/n) ");
							input = s.nextLine().trim().toLowerCase();
						} while (!input.matches("[yn]"));

						if (input.equals("n")) {
							break;
						}
					}
				} while (!found);

				// Neu cancel tim cd thi khong cho nhap quantity
				if (found) {
					do {
						try {
							System.out.printf("%1$5s%2$5s%3$-15s", "3.", " ",
							"CD quantity to buy:  ");
							input = s.nextLine().trim();
							orderCd.setQty(Integer.parseInt(input));
							break;
						} catch (Exception e) {
							System.out.println("Error: " + e.getMessage());
						}
					} while (true);
				}

				// Add cd da chon vao database
				try {
					order.addCd(orderCd);
					succeed = true;
				} catch (Exception e) {
					// System.out.println("Error: " + e.getMessage());
				}

				// Hoi co mua tiep CD nua khong?
				do {
					if (succeed) {
						System.out.print("\nAdded " + order.getTotalQuantity()
						+ " CD to your order! Buy more CD? (y/n) ");
					} else {
						System.out.print("\nTry buying another CD? (y/n) ");
					}

					input = s.nextLine().trim().toLowerCase();
				} while (!input.matches("[yn]"));
			} while (input.equals("y"));

			if (order.getOrderCds().size() > 0) {
				orders.add(order);
				System.out.println("\nBuying CD successfully! Please review your order:");
				order.showDetails();
			} else {
				System.out.println("\nBuying failed...");
			}
		} else {
			System.out.println("CD list is EMPTY! Please add some CDs first!");
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
	}

	private void checkOrder() {
		if (orders.size() == 0) {
			System.out.println("Order list is EMPTY! Please buy some CDs first!");
		} else {
			do {
				System.out.print("Input order ID to check: ");
				input = s.nextLine().trim().toUpperCase();
				boolean found = false;

				for (Order o : orders) {
					if (o.getOrderId().matches(input)) {
						o.showDetails();
						found = true;
						break;
					}
				}

				do {
					if (!found) {
						System.out.print("\nOrder ID not found! Try again? (y/n) ");
					} else {
						System.out.print("\nCheck another order? (y/n) ");
					}

					input = s.nextLine().trim().toLowerCase();
				} while (!input.matches("[yn]"));
			} while (input.equals("y"));
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
	}
}