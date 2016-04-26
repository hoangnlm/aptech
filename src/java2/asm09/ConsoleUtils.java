package java2.asm09;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for input/output console.
 * 
 * @author HoangNLM
 * @version 1.1
 */
public class ConsoleUtils {
	//For testing
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		a.add("hehe");
		a.add("hihi");
		a.add("huhu");
		String b = "test";
	}
	
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

	protected static void print(Object obj){
		System.out.print(obj.toString());
	}

	protected static void println() {
		System.out.println();
	}

	protected static void println(Object obj) {
		System.out.println(obj.toString());
	}

	protected static void printf(String s, Object... args) {
		System.out.printf(s, args);
	}

	protected static void printt(Object obj) {
		System.err.print(obj.toString());
		System.out.println();
	}

	protected static String read(Object obj) {
		System.out.print(obj.toString());
		return sc.nextLine().trim();
	}

	protected static String readf(String s, Object... args) {
		System.out.printf(s, args);
		return sc.nextLine().trim();
	}

	protected static String readln(Object obj) {
		System.out.println(obj.toString());
		return sc.nextLine().trim();
	}

	protected static String readt(Object obj) {
		System.err.print(obj.toString());
		String kq = sc.nextLine().trim();
		System.out.println();
		return kq;
	}
}