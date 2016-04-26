package java1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Regex {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		do {
			Pattern pattern1;
			
			do {
				try {
					System.out.println("\nEnter expression: ");
					pattern1 = Pattern.compile(s.nextLine().trim(), Pattern.CASE_INSENSITIVE);
					System.out.println(Pattern.CASE_INSENSITIVE);
					break;
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				} 
			} while (true);
			
			System.out.println("Enter string to search: ");
			Matcher matcher1 = pattern1.matcher(s.nextLine().trim());
			System.out.println();
			boolean found = false;

			while (found=matcher1.find()) {
				System.out.format(
				"Found the text" + " \"%s\" starting at "
				+ "index %d and ending at index %d.%n", matcher1.group(), matcher1.start(),
				matcher1.end());
			}
			
			if (!found)
				System.out.println("No match found!");

			System.out.print("\nTry again ? <y/n>");
		}while(s.nextLine().trim().toLowerCase().equals("y"));
	}
}
