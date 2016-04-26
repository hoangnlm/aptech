package java2.asm02;

import java.util.Scanner;

public class ConsoleUtils {
	protected static Scanner sc = new Scanner(System.in);
	protected static String consoleInput;

	protected void print(String text) {
		System.out.print(text);
	}
	
	protected void println(String text) {
		System.out.println(text);
	}

	protected void printf(String s, Object... args) {
		System.out.printf(s, args);
	}

	protected void printt(String title) {
		System.err.println(title);
	}

	protected String read(String s) {
		System.out.print(s);
		return sc.nextLine().trim();
	}

	protected String readf(String s, Object... args) {
		System.out.printf(s, args);
		return sc.nextLine().trim();
	}

	protected String readln(String s) {
		System.out.println(s);
		return sc.nextLine().trim();
	}
	
	protected String readt(String s) {
		System.err.print(s);
		return sc.nextLine().trim();
	}
	
	protected void exit() {
		printt("\nGoodbye! See you again! ^^");
	}
}
