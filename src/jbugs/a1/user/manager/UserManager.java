package jbugs.a1.user.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/user_management";

	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");


			// test create user
			UserDAOInterface userDao = new UserDAO();
			// User user = new User(2, "Alex", "Ghiurau", "0745882003",
			// "alex.ghiurau@gmail.com", "alexuser", "alexpass",true);
			// userDao.createUser(user, conn);

			// test read all users
			List<User> users=  new ArrayList<>();
			users = userDao.readAll(conn);
			
			for (User user : users) {
				System.out.println(user.toString());
			}
			// test read user one user
			
			// User readUser = new User();
			// readUser = userDao.readUser(1, conn);

			
			// test update user (read user and thean change them
			
			// readUser.setFirstName("change2");
			// readUser.setEmail("email_changed2@gmail.com");
			// userDao.updateUser(readUser, conn);

			
			// test delete user (with id 3)
			
			// User deleteUser = new User();
			// deleteUser = userDao.readUser(3, conn);
			// userDao.deleteUser(deleteUser, conn);
		}

		catch (SQLException se) {
			se.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

}
