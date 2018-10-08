package cl.startToken.dao.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection con = null;
	private static String bd = "armusspa_armus";
	private static String login ="armusspa_adminAr";
	private static String pass = "Joe83949550";
//	private static String url = "jdbc:mysql://mysql3000.mochahost.com:3306/";
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
	
	
	public static void main(String[] arg){
		getConnection();
	}


}