package java1.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookStore {

	public static void main(String[] args) throws Exception {
		BookStore bookStore = new BookStore(2);
		bookStore.run();

	}

	private int nextBook; // So luong book toi da co the nhap
	private int count; // Dem so luong book da nhap
	private String search, input;
	private Book[] books;
	private Scanner s;

	public BookStore(int nextBook) throws Exception {
		setNextBook(nextBook);
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
			addBook();
			break;
		case 2:
			displayBook();
			break;
		case 3:
			searchBook();
			break;
		default:
			exit();
			return;
		}

		run(menu());
	}

	private void initialize() {
		s = new Scanner(System.in);
		books = new Book[getNextBook()];
	}

	private void exit() {
		System.out.println("\nGoodbye! See you again! ^^");
	}

	private int menu() {
		System.out.println("\n" + String.format("%2s", " ").replace(" ", "-")
		+ " BOOK MANAGEMENT PROGRAM  " + String.format("%2s", " ").replace(" ", "-"));
		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		System.out.printf("%1$10s%2$5s%3$-20s\n", "1.", " ", "Adding new book.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "2.", " ",
		"Displaying all details of books.");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "3.", " ", "Searching book by title");
		System.out.printf("%1$10s%2$5s%3$-20s\n", "4.", " ", "Exit.");
		System.out.println(String.format("%40s", " ").replace(" ", "-"));

		do {
			System.out.printf("%1$8s%2$-15s", " ", "Input 1 - 4:");
			input = s.nextLine().trim();
		} while (!input.matches("[1-4]"));

		System.out.println(String.format("%40s", " ").replace(" ", "-"));
		return Integer.parseInt(input);
	}

	private void addBook() {
		do {
			try {
				if (count >= books.length) {
					throw new ArrayIndexOutOfBoundsException(
					"Unable to add book! \nCan input only " + books.length + " book(s)!");
				}

				Book book = new Book();
				System.out.println("\nADD A BOOK:");
				System.out.print("Book type: ");
				book.setType(s.nextLine().trim());
				System.out.print("Book title: ");
				book.setTitle(s.nextLine().trim());
				System.out.print("Book price: ");
				book.setPrice(Integer.parseInt(s.nextLine().trim()));
				System.out.print("Book edition: ");
				book.setEdition(Integer.parseInt(s.nextLine().trim()));
				books[count++] = book;
				System.out.println("\nAdding book succeeded...");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());

				if (e.getMessage().contains("Unable to add book!"))
					break;
			}
			
			System.out.print("Add more? <y/n> ");
		} while (s.nextLine().trim().toLowerCase().matches("y"));
	}

	private void displayBook() {
		try {
			if (count == 0)
				throw new Exception("No book to display!");

			System.out.println(String.format("%34s", " ").replace(" ", "-") + " BOOK LIST "
			+ String.format("%35s", " ").replace(" ", "-"));
			System.out.println(String.format("%100s", " ").replace(" ", "-"));
			System.out.printf("%s\t%s\t\t%s\t\t%s\t%s\n", "No.", "Type", "Title", "Price",
			"Edition");
			System.out.println(String.format("%100s", " ").replace(" ", "-"));

			for (int i = 0; i < books.length; i++) {
				if (books[i] != null) {
					System.out.printf("%s\t\t%s\t\t%s\t\t%d\t\t%s\t\n", (i + 1) + ".",
					books[i].getType(), books[i].getTitle(), books[i].getPrice(),
					books[i].getEdition());
				}
			}

			System.out.println(String.format("%100s", " ").replace(" ", "-"));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void searchBook() {
		boolean empty = false;

		do {
			try {
				if (count == 0) {
					empty = true;
					throw new Exception("Book list is empty!");
				}

				System.out.println("\nSEARCH A BOOK BY TITLE:");
				System.out.print("Input title to search: ");
				search = s.nextLine().trim().toLowerCase();

				ArrayList<Book> tmp_books = new ArrayList<>();
				for (Book b : books) {
					if (b != null) {
						if (b.getTitle().toLowerCase().contains(search)) {
							tmp_books.add(b);
						}
					}
				}

				if (tmp_books.size() == 0)
					throw new IllegalArgumentException("No book to dislay!");

				System.out.println("\nFound " + tmp_books.size() + " book(s).");
				System.out.println(String.format("%100s", " ").replace(" ", "-"));
				System.out.printf("%s\t%s\t\t%s\t\t%s\t%s\n", "No.", "Type", "Title", "Price",
				"Edition");
				System.out.println(String.format("%100s", " ").replace(" ", "-"));

				for (int i = 0; i < tmp_books.size(); i++) {
					Book b = tmp_books.get(i);
					System.out.printf("%s\t%s\t\t%s\t\t%d\t\t%s\t\n", (i + 1) + ".",
					b.getType(), b.getTitle(), b.getPrice(), b.getEdition());
				}

				System.out.println(String.format("%100s", " ").replace(" ", "-"));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				if (!empty)
					System.out.print("Search more? <y/n> ");
			}
		} while (!empty && s.nextLine().trim().toLowerCase().matches("y"));

	}

	private int getNextBook() {
		return nextBook;
	}

	private void setNextBook(int nextBook) throws Exception {
		if (nextBook < 1)
			throw new IllegalArgumentException("So luong sach phai >=1!");

		this.nextBook = nextBook;
	}
}
