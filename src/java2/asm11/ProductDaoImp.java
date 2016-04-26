package java2.asm11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImp extends ConsoleUtils implements ProductDao {
	public static void main(String[] args) {
		ProductDaoImp daoImp = new ProductDaoImp();
		try {
			daoImp.run();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final String DB_URL = "jdbc:sqlserver://10.211.55.7;user=sa;password=111;databaseName=PRODUCTS";
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String sql;
	private List<Product> products;

	public void run() throws SQLException {
		run(0);
	}

	private void run(int item) throws SQLException {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			display();
			break;
		case 2:
			displayAll();
			break;
		case 3:
			insert();
			break;
		case 4:
			delete();
			break;
		case 5:
			modify();
			break;
		default:
			exit();
			return;
		}

		run(
		printMenu("PRODUCT MANAGEMENT SERVICE", "Display 1 product.", "Display all products.",
		"Insert a product.", "Delete a product.", "Modify a product.", "Exit."));
	}

	private void initialize() throws SQLException {
		products = new LinkedList<Product>();
		connection = DriverManager.getConnection(DB_URL);
	}

	private void exit() throws SQLException {
		if (connection != null)
			connection.close();
		if (statement != null)
			statement.close();
		if (resultSet != null)
			resultSet.close();
		printt("\nGoodbye! See you again! ^^");
	}

	@Override
	public void display() throws SQLException {
		println("DISPLAY PRODUCT DETAILS:");

		int searchId = Integer.parseInt(read("Input ID: "));
		sql = "SELECT * FROM PRODUCTS WHERE ID=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, searchId);
		resultSet = statement.executeQuery();
		boolean found = false;

		while (resultSet.next()) {
			found = true;
			println("\nID: " + resultSet.getInt(1));
			println("Name: " + resultSet.getString(2));
			println("Number: " + resultSet.getInt(3));
			println("-----------------");
		}

		if (!found)
			printt("Not found!");
	}

	@Override
	public void displayAll() throws SQLException {
		printt("DISPLAY ALL PRODUCTS IN LIST:");
		sql = "SELECT * FROM PRODUCTS";
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();

		while (resultSet.next()) {
			println("\nID: " + resultSet.getInt(1));
			println("Name: " + resultSet.getString(2));
			println("Number: " + resultSet.getInt(3));
			println("-----------------");
		}
	}

	@Override
	public void insert() throws SQLException {
		printt("INSERT A NEW PRODUCT:");
		products = new LinkedList<Product>();

		do {
			try {
				products.add(new Product(read("Name: "), Integer.parseInt(read("Number: "))));
			} catch (Exception e) {
				printt("Error: " + e.getMessage());
			}
		} while (read("Add more? <y/n> ").trim().toLowerCase().equals("y"));

		sql = "INSERT PRODUCTS(NAME,NUMBER) VALUES(?,?)";
		statement = connection.prepareStatement(sql);
		int rows = 0;

		for (Product product : products) {
			statement.setString(1, product.getName());
			statement.setInt(2, product.getNumber());
			statement.executeUpdate();
			rows++;
		}

		printt("Insert successfully " + rows + " records!");
	}

	@Override
	public void delete() throws SQLException {
		printt("DELETE A PRODUCT:");
		int searchId = 0;

		do {
			do {
				try {
					searchId = Integer.parseInt(read("Input ID: "));
					break;
				} catch (Exception e) {
					printt("Error: " + e.getMessage());
				}
			} while (read("Try again? <y/n> ").trim().toLowerCase().equals("y"));

			sql = "SELECT * FROM PRODUCTS WHERE ID=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchId);
			resultSet = statement.executeQuery();

			if (!resultSet.next()) {
				printt("Product not found!");
			} else {
				sql = "DELETE PRODUCTS WHERE ID=?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, searchId);
				statement.executeUpdate();
				printt("Delete successfully 1 record!");
			}
		} while (read("Try again? <y/n> ").trim().toLowerCase().equals("y"));
	}

	@Override
	public void modify() throws SQLException {
		printt("MODIFY A PRODUCT:");
		int searchId = 0;

		do {
			try {
				searchId = Integer.parseInt(read("Input ID: "));
				break;
			} catch (Exception e) {
				printt("Error: " + e.getMessage());
			}
		} while (read("Try again? <y/n> ").trim().toLowerCase().equals("y"));

		sql = "SELECT NAME, NUMBER FROM PRODUCTS WHERE ID=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, searchId);
		resultSet = statement.executeQuery();

		if (!resultSet.next()) {
			printt("Product not found!");
		} else {
			String name = "";
			int number = 0;

			do {
				try {
					name = read("Input name (old name: " + resultSet.getString(1) + "): ");
					number = Integer.parseInt(
					read("Input number (old number: " + resultSet.getInt(2) + "): "));
					break;
				} catch (Exception e) {
					printt("Error: " + e.getMessage());
				}
			} while (read("Try again? <y/n> ").trim().toLowerCase().equals("y"));

			sql = "UPDATE PRODUCTS SET NAME=?, NUMBER=? WHERE ID=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name.trim().equals("") ? resultSet.getString(1) : name);
			statement.setInt(2, number == 0 ? resultSet.getInt(2) : number);
			statement.setInt(3, searchId);
			statement.executeUpdate();
			printt("Modify successfully 1 record!");
		}
	}
}
