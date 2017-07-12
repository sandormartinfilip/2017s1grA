package jbugs.a1.user.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

			// stmt = conn.createStatement();

			// test create user
			UserDAO userDao = new UserDAO();
			 User user = new User(2, "Alex", "Ghiurau", "0745882003",
			 "alex.ghiurau@gmail.com", "alexuser",
			 "alexpass", true);

			 userDao.createUser(user, conn);

			User readUser = new User();
			// test read user
			readUser = userDao.readUser(1, conn);

			//readUser.setFirstName("change2");
			//readUser.setEmail("email_changed2@gmail.com");

			// test update user
			//userDao.updateUser(readUser, conn);

			//User deleteUser = new User();
			//deleteUser = userDao.readUser(3, conn);
			// test delete user
			//userDao.deleteUser(deleteUser, conn);
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
