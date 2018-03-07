package cl.startToken.dao.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection con = null;
	private static String bd = "javacrud";
	private static String login = "root";
	private static String pass = "toor";
	private static String url = "jdbc:mysql://127.0.0.1:3306/";
	private static String dsn = url + bd;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dsn, login, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
