package utilPkg;

import java.util.Scanner;

public class ConsoleUtils {
	protected static Scanner sc = new Scanner(System.in);
	protected static String consoleInput;

	/**
	 * Print menu to console and return inputted value.
	 * First string arg is TITLE. Last string arg is EXIT.
	 * 
	 * @param args
	 * @return inputted value
	 */
	protected static int printMenu(String... args) {
		println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " "+ args[0] +" " + String.format("%2s", " ").replace(" ", "-"));
		println(String.format("%40s", " ").replace(" ", "-"));
		
		for (int i = 1; i < args.length; i++) {
			printf("%1$10s%2$5s%3$-20s\n", i+".", " ", args[i]);
		}
		
		println(String.format("%40s", " ").replace(" ", "-"));

		int maxInput = args.length - 1;
		do {
			printf("%1$8s%2$-15s", " ", "Input [1 - "+maxInput+"]:");
			consoleInput = sc.nextLine().trim();
		} while (!consoleInput.matches("[1-"+maxInput+"]"));

		println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(consoleInput);
	}

	protected static void print(String text) {
		System.out.print(text);
	}

	protected static void println(String text) {
		System.out.println(text);
	}

	protected static void printf(String s, Object... args) {
		System.out.printf(s, args);
	}

	protected static void printt(String title) {
		System.err.print(title);
		System.out.println();
	}

	protected static String read(String s) {
		System.out.print(s);
		return sc.nextLine().trim();
	}

	protected static String readf(String s, Object... args) {
		System.out.printf(s, args);
		return sc.nextLine().trim();
	}

	protected static String readln(String s) {
		System.out.println(s);
		return sc.nextLine().trim();
	}

	protected static String readt(String s) {
		System.err.print(s);
		String kq = sc.nextLine().trim();
		System.out.println();
		return kq;
	}
}