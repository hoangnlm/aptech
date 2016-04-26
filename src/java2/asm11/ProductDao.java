package java2.asm11;

import java.sql.SQLException;

public interface ProductDao {
	void display() throws SQLException;
	void displayAll() throws SQLException;
	void insert() throws SQLException;
	void delete() throws SQLException;
	void modify() throws SQLException;
}
