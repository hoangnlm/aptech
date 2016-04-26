package java2.asm09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class EmployeeManager extends ConsoleUtils{

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		
//		try {
//			Connection cn = DriverManager.getConnection("jdbc:sqlserver://10.211.55.7;user=sa;password=111;databaseName=SHOE_STORE");
//			println(cn.getClientInfo());
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			employeeManager.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final String DB_URL = "jdbc:sqlserver://10.211.55.7;user=sa;password=111;databaseName=EMPDB";
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String sql;
	private LinkedList<Employee> employees;
	private LinkedList<Employee> employeesToAdd;
	
	public void run() throws SQLException {
		run(0);
	}

	private void run(int item) throws SQLException {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			addEmployee();
			break;
		case 2:
			displayAll();
			break;
		case 3:
			searchById();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("ABC MANAGEMENT SERVICE","Add new employee.","Display all.","Search by ID.","Exit."));
	}

	private void initialize() throws SQLException {
		employees = new LinkedList<Employee>();
		connection = DriverManager.getConnection(DB_URL);
	}

	private void exit() throws SQLException {
		if(connection!=null) connection.close();
		if(statement!=null) statement.close();
		if(resultSet!=null) resultSet.close();
		printt("\nGoodbye! See you again! ^^");
	}
	
	private void addEmployee() throws SQLException{
		employeesToAdd = new LinkedList<Employee>();
		printt("INPUT EMPLOYEE INFO:");
		
		do {
			try {
				employeesToAdd.add(new Employee(read("Name: "), read("Department: "),
				read("Designation: "), Double.parseDouble(read("Basic salary: "))));
				println("Adding succeeded...");
			} catch (Exception e) {
				printt("Error: " + e.getMessage());
			} 
		} while (read("Add more? <y/n> ").trim().toLowerCase().equals("y"));
		
		sql = "INSERT EMPLOYEES(NAME,DEPARTMENT,BASIC_SALARY,DESIGNATION) VALUES(?,?,?,?)";
		statement = connection.prepareStatement(sql);
		int rows = 0;
		
		for (Employee employee : employeesToAdd) {
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getDepartment());
			statement.setDouble(3, employee.getBasicSalary());
			statement.setString(4, employee.getDesignation());
			statement.executeUpdate();
			rows++;
		}
		
		employees.addAll(employeesToAdd);
		printt("Insert successfully "+rows+" records!");
	}
	
	private void displayAll() throws SQLException{
		printt("DISPLAY ALL EMPLOYEES IN LIST:");
		sql = "SELECT * FROM EMPLOYEES";
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			println("\nID: "+resultSet.getInt(5));
			println("Name: "+resultSet.getString(1));
			println("Department: "+resultSet.getString(2));
			println("Basic salary: "+resultSet.getDouble(3));
			println("Designation: "+resultSet.getString(4));
			println("-----------------");
		}
		
	}
	
	private void searchById(){
		println("SEARCH EMPLOYEE BY ID:");
		
		try {
			int searchId = Integer.parseInt(read("Input ID: "));
			sql = "SELECT * FROM EMPLOYEES WHERE ID=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchId);
			resultSet = statement.executeQuery();
			boolean found = false;
			
			while (resultSet.next()) {
				found = true;
				println("\nID: "+resultSet.getInt(5));
				println("Name: "+resultSet.getString(1));
				println("Department: "+resultSet.getString(2));
				println("Basic salary: "+resultSet.getDouble(3));
				println("Designation: "+resultSet.getString(4));
				println("-----------------");
			}
			
			if(!found) printt("Not found!");
		} catch (Exception e) {
			printt("Error: "+e.getMessage());
		}
	}
}
