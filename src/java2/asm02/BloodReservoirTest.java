package mainPkg;

public class BloodReservoirTest extends ConsoleUtils {
	public static void main(String[] args) {
		BloodReservoirTest bloodReservoirTest = new BloodReservoirTest();
		bloodReservoirTest.run();
	}

	private int totalVolume, emerVolume, counterNo, wantedVolume;
	private static int totalSoldVolume;
	private BloodReservoir counter1;
	private BloodReservoir counter2;
	private BloodReservoir counter3;

	public void run() {
		run(0);
	}

	private void run(int item) {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			inputInfo();
			break;
		case 2:
			sellFromCounter();
			break;
		case 3:
			trackSales();
			break;
		case 4:
			printSummary();
			break;
		default:
			exit();
			return;
		}

		run(showMenu());
	}

	private void initialize() {
		counter1 = new BloodReservoir();
		counter2 = new BloodReservoir();
		counter3 = new BloodReservoir();
	}

	private int showMenu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " BANKING PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		println(String.format("%40s", " ").replace(" ", "-"));
		printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Input information.");
		printf("%1$10s%2$5s%3$-20s\n", "2.", " ", "Sell from counter.");
		printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Track the sales.");
		printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Print summary.");
		printf("%1$10s%2$5s%3$-20s\n", "5.", " ", "Exit.");
		println(String.format("%40s", " ").replace(" ", "-"));

		do {
			printf("%1$8s%2$-15s", " ", "Input 1 - 5:");
			consoleInput = sc.nextLine().trim();
		} while (!consoleInput.matches("[1-5]"));

		println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(consoleInput);
	}

	private void inputInfo() {
		do {
			try {
				println("\nINPUT REQUIRED INFORMATION:");
				totalVolume = Integer.parseInt(read("Total units: "));
				emerVolume = Integer.parseInt(read("Emergency units: "));
				counter1.setCostPerUnit(Double.parseDouble(read("Price of counter 1: ")));
				counter2.setCostPerUnit(Double.parseDouble(read("Price of counter 2: ")));
				counter3.setCostPerUnit(Double.parseDouble(read("Price of counter 3: ")));
				break;
			} catch (Exception e) {
				printt("Error: " + e.getMessage());
				print("Try again? <y/n> ");
			}
		} while (sc.nextLine().trim().toLowerCase().matches("y"));
	}

	private void sellFromCounter() {
		if (totalVolume == 0) {
			print("\nPlease input some info first!");
		} else {
			do {
				try {
					println("\nINPUT SALES INFORMATION:");
					counterNo = Integer.parseInt(read("Counter number to sell [1-3]: "));
					wantedVolume = Integer.parseInt(read("Units to sell: "));

					if (wantedVolume < 30)
						throw new Exception("Sales only MORE THAN 30 Pints!");

					if (wantedVolume > (totalVolume + emerVolume - totalSoldVolume))
						throw new Exception("Sales exceeds total volume!");

					totalSoldVolume += wantedVolume;

					switch (counterNo) {
					case 1:
						counter1.addTotalUnits(wantedVolume);
						break;
					case 2:
						counter2.addTotalUnits(wantedVolume);
						break;
					case 3:
						counter3.addTotalUnits(wantedVolume);
						break;
					}

					println("\nSelling succeeded...");
				} catch (Exception e) {
					println("Error: " + e.getMessage());
				}

				print("Sell more? <y/n> ");
			} while (sc.nextLine().trim().toLowerCase().matches("y"));
		}
	}

	private void trackSales() {
		if (totalVolume == 0) {
			print("\nPlease input some info first!");
		} else {
			do {
				try {
					println("\nTRACK COUNTER SALES:");
					counterNo = Integer.parseInt(read("Input counter number [1-3]: "));

					switch (counterNo) {
					case 1:
						println(counter1.extractInfo());
						break;
					case 2:
						println(counter2.extractInfo());
						break;
					case 3:
						println(counter3.extractInfo());
						break;
					}

				} catch (Exception e) {
					println("Error: " + e.getMessage());
				}

				print("Track more? <y/n> ");
			} while (sc.nextLine().trim().toLowerCase().matches("y"));
		}
	}

	private void printSummary() {
		if (totalVolume == 0) {
			print("\nPlease input some info first!");
		} else {
			println("\nDAILY SUMMARY INFORMATION:");
			println("--Counter 1:");
			println("\tTotal sold units: "+counter1.getTotalUnits());
			println("\tTotal sales: "+counter1.getTotalIncome());
			println("--Counter 2:");
			println("\tTotal sold units: "+counter2.getTotalUnits());
			println("\tTotal sales: "+counter2.getTotalIncome());
			println("--Counter 3:");
			println("\tTotal sold units: "+counter3.getTotalUnits());
			println("\tTotal sales: "+counter3.getTotalIncome());
			println("-------------------");
			println("--Total blood units of bank: "+(totalVolume+emerVolume));
			println("--Total sold blood units today: "+totalSoldVolume);
			println("--Today balance units: "+(totalVolume+emerVolume-totalSoldVolume));
		}
	}
}
