package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/userdatabase";

	static final String USER = "msg";
	static final String PASS = "msg";

	public static void createTable (Statement stmt, Connection conn){
		
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS USER"
					+ "(ID INT auto_increment,"
					+ "FIRSTNAME VARCHAR(40),"
					+ "LASTNAME VARCHAR(40),"
					+ "PHONE VARCHAR(40),"
					+ "EMAIL VARCHAR(40),"
					+ "USERNAME VARCHAR(40),"
					+ "PASSWORD VARCHAR(40),"
					+ "STATUS int,"
					+ "PRIMARY KEY(ID)"
					+ ");";
			
			boolean result = stmt.execute(sql);

			System.out.println("Table created successfully -->" + result);
			
			

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if (stmt !=null)
					conn.close();
			}catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
}