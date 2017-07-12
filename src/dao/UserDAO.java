package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class UserDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/userdatabase";

	static final String USER = "msg";
	static final String PASS = "msg";

	public void createUser(User user) {
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			conn.setAutoCommit(false);

			String insertTableSQL = "INSERT INTO USER"
					+ "(FIRSTNAME, LASTNAME, PHONE, EMAIL, USERNAME, PASSWORD, STATUS) VALUES" + "(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, user.getStatus());

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			conn.commit();

			System.out.println("User created ! ");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void updateUser(User user) {
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			String update = "UPDATE USER SET FIRSTNAME = ?, LASTNAME = ?, PHONE = ?, EMAIL=? WHERE ID = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getId());

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			conn.commit();

			System.out.println("User updated ! ");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public ArrayList<User> getUsers() {
		Statement stmt=null;
		Connection conn=null;
		ArrayList<User> users = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			String sql = "select * from USER";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int status = rs.getInt("status");

				User user = new User(id, firstName, lastName, phone, email, username, password, status);

				users.add(user);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return users;
	}

	public void deleteUser(int id) {
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			String update = "DELETE FROM USER WHERE ID = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(update);

			preparedStatement.setInt(1, id);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			conn.commit();

			System.out.println("User deleted ! ");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
