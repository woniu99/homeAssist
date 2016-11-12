package dataServlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbforMySql {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/data";
	private String user = "root";
	//private String password = "zxx";
	private String password = "";
	static Connection conn = null;

	public Connection getConnectionInstance() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	};
	
	
}
