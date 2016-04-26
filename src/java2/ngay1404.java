package java2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ngay1404 {

	public static void main(String[] args) throws SQLException {
//		String cn = "jdbc:sqlserver://10.211.55.7;user=sa;password=111;databaseName=SHOE_STORE";
//		String sql = "SELECT * FROM GIAY";
//		Connection connection = DriverManager.getConnection(cn);
//		Statement statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(sql);
//	
//		while(resultSet.next()){
//			System.out.println(resultSet.getString(2));
//		}
//		
//		connection.close();
//		System.out.println("test");
//		System.out.println(-5%3);
		
		byte b = 1;
		b = (byte) 128;
		System.out.println(b);
	}
}
