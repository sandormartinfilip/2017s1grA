package jdbc_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserCRUD {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbc_example";
	
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "");

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, info);
			System.out.println("Connected database successfully");
			conn.setAutoCommit(false);

			String sql = "INSERT INTO users (first_name, last_name, phone_number, email, user_name, password, stat)  VALUES (?, ?, ?,?,?,?,?)";
			
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPhoneNumber());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getUserName());
			stmt.setString(6, user.getPassword());
			stmt.setBoolean(7, user.isStatus());

			stmt.executeUpdate();

			conn.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.out.println(s.getErrorCode());
				System.out.println(s.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "");

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, info);
			System.out.println("Connected database successfully");
			conn.setAutoCommit(false);

			String sql = "DELETE from USERS where idusers = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);

			stmt.executeUpdate();

			conn.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.out.println(s.getErrorCode());
				System.out.println(s.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUserFirstName(int id, String firstName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "");

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, info);
			System.out.println("Connected database successfully");
			conn.setAutoCommit(false);

			String sql = "update USERS set first_name=? where idusers=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setInt(2, id);

			stmt.executeUpdate();

			conn.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.out.println(s.getErrorCode());
				System.out.println(s.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List readAll(){
		Connection conn = null;
		Statement stmt = null;
		
		List<User> users = new ArrayList<User>(); 
		
		try {
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "");

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, info);
			System.out.println("Connected database successfully");
			conn.setAutoCommit(false);

			stmt = conn.createStatement();
			String sql = "select * from users";
			

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				User user= new User();
				user.setId(rs.getInt("idusers"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getBoolean("stat"));
				
				users.add(user);
			}

			conn.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.out.println(s.getErrorCode());
				System.out.println(s.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static void main(String[] args) {
		UserCRUD userProc = new UserCRUD();
		
		User user = new User("Filip", "Sandor", "0729908045", "filip_sandor@yahoo.com", "sandorfilip","filip.pass", true);
		//userProc.insertUser(user);
		
		//userProc.deleteUser(1);
		userProc.updateUserFirstName(2, "Marian");
		
		List<User> users = userProc.readAll();
		for(User u:users){
			System.out.println(u.toString());
		}
		
	}
}
