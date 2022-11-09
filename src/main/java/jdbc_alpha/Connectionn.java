package jdbc_alpha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionn {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root","4NM15ec008@");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {

		}
		return null;

	}

}
