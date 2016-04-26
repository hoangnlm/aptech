package java2.test;

import java.util.ArrayList;

public class ManageEvents extends IOUtils2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManageEvents events = new ManageEvents();
		events.run();
	}

	private ArrayList<Event> events;

	public void run() {
		run(0);
	}

	private void run(int item) {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			add();
			break;
		case 2:
			open();
			break;
		case 3:
			save();
			break;
		case 4:
			ignore();
			break;
		case 5:
			delete();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("EVENTS PROGRAM", "Add", "Open", "Save", "Ignore", "Delete", "Exit"));
	}

	private void delete() {
		printt("Delete all data in ArrayList...");
		events.clear();
	}

	private void ignore() {
		println("You choice ignore option.");
	}

	private void save() {
		String filename = read("Input file name to save: ").trim();
		setFilePath("/Users/Hoang/Documents/Eclipse/workspace/com.aptech.java2.test/src/mainPkg/" + filename);
		writeObjectStream(events);
	}

	private void open() {
		String filename = read("Input file name to open: ").trim();
		setFilePath("/Users/Hoang/Documents/Eclipse/workspace/com.aptech.java2.test/src/mainPkg/" + filename);
		events = (ArrayList<Event>) readObjectStream();

		if (events != null) {
			if (events.size() == 0) {
				println("Event list empty!");
			} else {
				for (Event event : events) {
					println(event.toString());
				}
			}
		} else {
			println("Event list empty!");
		}
	}

	private void add() {
		println("ADD EVENT OBJECT TO ARRAYLIST:");

		do {
			try {
				events.add(new Event(read("Time: ").trim(), read("Place: ").trim(), read("Content: ").trim()));
				// writeObjectStream(events);
				println("\nAdding succeeded...");
			} catch (Exception e) {
				printt("Error: " + e.getMessage());
			}
		} while (read("Add more? <y/n> ").trim().toLowerCase().equals("y"));
	}

	private void initialize() {
		events = new ArrayList<Event>();
	}

	private void exit() {
		printt("\nThank you! Good luck! ^^");
	}

}
