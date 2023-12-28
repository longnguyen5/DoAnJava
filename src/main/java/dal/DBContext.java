package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	protected Connection connection;

	public DBContext() {
		String name = "root";
		String pass = "LONG.DepTrai1VuTru";
		String url = "jdbc:mysql://localhost:3306/store2023";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
