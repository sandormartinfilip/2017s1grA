package UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbc_example";  //include the new (created) database in URL
	
	//database credentials
	
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		Connection conn = null;
	
		UserDAO userDAO = new UserDAO();
		
					try {
						Class.forName(JDBC_DRIVER);
						
						conn = DriverManager.getConnection(DB_URL, USER, PASS );
						System.out.println("Connected database successfully...");
						
						userDAO.addUser(new User(1, "Damira", "Petrean", "0741101456", "mail@mail.com", "damirapetrean", "dami", 1) , conn);
						
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
		System.out.println("Goodbye!");
	}
}
