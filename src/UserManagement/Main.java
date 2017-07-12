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
						
						//insert into database
						//userDAO.addUser(new User(1, "Damira", "Petrean", "0741101456", "mail@mail.com", "damirapetrean", "dami", 1) , conn);
						//userDAO.addUser(new User(2, "Alexa", "Ghiurau", "0745147369", "alexa@mail.com", "alexa", "alexa", 1) , conn);
						//update the phone number
						//userDAO.updateUser(1, "0744631784", conn);
						
						//delete from database
						//userDAO.deleteUser(1, conn);
						
						//show all the records
						userDAO.showTheUsers(conn);
						
						conn.close();
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
		System.out.println("\n \nGoodbye!");
	}
}
