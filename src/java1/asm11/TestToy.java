package java1.asm11;

import java.util.ArrayList;
import java.util.Scanner;

public class TestToy {
	public static void main(String[] args) {
		TestToy testToy = new TestToy();
		testToy.run();
	}

	private ArrayList<Toy> toys;
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
			addToy();
			break;
		case 2:
			viewToyList();
			break;
		case 3:
			buyToy();
			break;
		case 4:
			checkOrder();
			break;
		case 5:
			checkStock();
			break;
		default:
			exit();
			return;
		}

		run(showMenu());
	}

	private void initialize() {
		toys = new ArrayList<>();
		orders = new ArrayList<>();
		s = new Scanner(System.in);
	}

	private void exit() {
		System.out.println("\nGoodbye! See you again! ^^");
	}

	private int showMenu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " TOY PURCHASE PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		System.out.printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Add a TOY.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "2.", " ", "View TOY list.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Buy TOY(s).");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Check an order.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "5.", " ", "Check a toy stock.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "6.", " ", "Exit.");
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			System.out.printf("%1$8s%2$-15s", " ", "Input 1 - 6:");
			input = s.nextLine().trim();
		} while (!input.matches("[1-6]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(input);
	}

	private void addToy() {
		Toy toy;

		try {
			toy = new Toy();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		System.out.println(String.format("%2s", " ").replace(" ", "-") + " ADD A TOY "
		+ String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-14s", "1.", " ", "Toy name:");
				input = s.nextLine().trim();
				toy.setName(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-14s", "2.", " ", "Toy color:");
				input = s.nextLine().trim();
				toy.setColor(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "3.", " ", "Toy type:");
				input = s.nextLine().trim();
				toy.setType(input);
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "4.", " ", "Toy price:");
				input = s.nextLine();
				toy.setPrice(Double.parseDouble(input));
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		do {
			try {
				System.out.printf("%1$5s%2$5s%3$-15s", "4.", " ", "Toy stock:");
				input = s.nextLine();
				toy.setStock(Integer.parseInt(input));
				break;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (true);

		toys.add(toy);

		do {
			System.out.print("\nAdding 01 toy successfully! Add more? (y/n)  ");
			input = s.nextLine().trim().toLowerCase();
		} while (!input.matches("[yn]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		if (input.equals("y")) {
			addToy();
		}
	}

	private void viewToyList() {
		if (toys.size() > 0) {
			System.out.println(String.format("%34s", " ").replace(" ", "-") + " TOY LIST "
			+ String.format("%35s", " ").replace(" ", "-"));
			System.out.println(String.format("%100s", " ").replace(" ", "-"));
			System.out.printf("%s\t%s\t\t%s\t%s\t%s\t%s\t%s\n", "No.", "ID", "Name", "Color",
			"Type", "Price", "Stock");
			System.out.println(String.format("%100s", " ").replace(" ", "-"));

			for (int i = 0; i < toys.size(); i++) {
				Toy t = toys.get(i);
				System.out.printf("%s\t%s\t\t%s\t%s\t%s\t%.2f\t%d\n", (i + 1) + ".", t.getId(),
				t.getName(), t.getColor(), t.getType(), t.getPrice(), t.getStock());
			}
		} else {
			System.out.println("Toy list is EMPTY! Please add some toys first!");
		}

		System.out.println(String.format("%100s", " ").replace(" ", "-"));
	}

	private void buyToy() {
		Order order;

		try {
			order = new Order();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		if (toys.size() > 0) {
			System.out.println(String.format("%10s", " ").replace(" ", "-") + " BUY A TOY "
			+ String.format("%10s", " ").replace(" ", "-"));
			System.out.println(String.format("%40s", " ").replace(" ", "-"));

			do {
				boolean found = false; // Tim thay toy trong toy list hay khong
				boolean succeed = false; // Add toy vao order thanh cong hay
											// khong
				OrderToy orderToy = null;

				// Tim toy theo id hoac name
				do {
					System.out.printf("%1$5s%2$5s%3$-15s", "1.", " ", "TOY ID/name to buy: ");
					input = s.nextLine().trim();

					for (Toy t : toys) {
						if (t.getId().matches(input.toUpperCase())
						|| t.getName().matches(input)) {
							try {
								orderToy = new OrderToy(t, 1);
								orderToy.setId(t.getId());
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
							System.out.print("Toy not found! Try again? (y/n) ");
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
							"Toy quantity to buy:  ");
							input = s.nextLine().trim();
							orderToy.setOrderQty(Integer.parseInt(input));
							break;
						} catch (Exception e) {
							System.out.println("Error: " + e.getMessage());
						}
					} while (true);
				}

				// Add cd da chon vao database
				try {
					order.addToy(orderToy);
					succeed = true;
				} catch (Exception e) {
					// System.out.println("Error: " + e.getMessage());
				}

				// Hoi co mua tiep toy nua khong?
				do {
					if (succeed) {
						System.out.print("\nAdded " + order.getTotalQuantity()
						+ " toy to your order! Buy more toy? (y/n) ");
					} else {
						System.out.print("\nTry buying another toy? (y/n) ");
					}

					input = s.nextLine().trim().toLowerCase();
				} while (!input.matches("[yn]"));
			} while (input.equals("y"));

			if (order.getOrderToys().size() > 0) {
				orders.add(order);
				System.out.println("\nBuying toys successfully! Please review your order:");
				order.showDetails();
			} else {
				System.out.println("\nBuying failed...");
			}
		} else {
			System.out.println("Toy list is EMPTY! Please add some toys first!");
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
	}

	private void checkOrder() {
		if (orders.size() == 0) {
			System.out.println("Order list is EMPTY! Please buy some toys first!");
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

	private void checkStock() {
		if (toys.size() == 0) {
			System.out.println("Empty toy list! Please add some toys first!");
		} else {
			do {
				boolean found = false;
				System.out.println("Input toy id to check stock: ");
				input = s.nextLine().trim().toUpperCase();

				for (Order order : orders) {
					Order.Stock stock = order.new Stock();
					try {
						System.out
						.println("Stock of toy \"" + input + "\": " + stock.getStock(input));
						found = true;
						break;
					} catch (Exception e) {

					}
				}

				if (!found) {
					System.out.println("Toy not found!");
				}

				do {
					System.out.print("\nCheck again? (y/n) ");
					input = s.nextLine().trim().toLowerCase();
				} while (!input.matches("[yn]"));
			} while (input.equals("y"));
		}

		System.out.println(String.format("%92s", " ").replace(" ", "-"));
	}
}