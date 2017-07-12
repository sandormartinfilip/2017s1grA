import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jbugger";

	static final String  USER = "msg";
	static final String PASS = "msg";
	
	public static void addUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "INSERT INTO user (id, firstname, lastname, mobilenumber, email, username, password, active) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getFirstname());
			pstmt.setString(3, user.getLastname());
			pstmt.setString(4, user.getMobilenumber());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getUsername());
			pstmt.setString(7, user.getPassword());
			pstmt.setBoolean(8, user.isActive());
			
			int affectedRows = pstmt.executeUpdate();
			System.out.println("addUser affected rows: " + affectedRows);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> list = new ArrayList();
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("firstname"), 
						rs.getString("lastname"), rs.getString("mobilenumber"), 
						rs.getString("email"), rs.getString("username"), 
						rs.getString("password"), rs.getBoolean("active"));
				list.add(user);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void deleteUser(User user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "DELETE FROM user WHERE id=" + user.getId();
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "UPDATE user SET firstname=?, lastname=?, mobilenumber=?,"+
					"email=?, username=?, password=?, active=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getMobilenumber());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getPassword());
			pstmt.setBoolean(7, user.isActive());
			pstmt.setInt(8, user.getId());
			
			int affectedRows = pstmt.executeUpdate();
			System.out.println("updateUser affected rows: " + affectedRows);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserDAO() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1, "Csongor", "Nemes", "0744000123", "a@b.com", "pass", true);
		System.out.println(user.getUsername());
		
		
//		UserDAO.addUser(user);
//		System.out.println("Added user to DB.");
		
		ArrayList<User> allUsers = UserDAO.getAllUsers();
		for (User u:allUsers) System.out.println(u.getId() + " " + u.getUsername() + " " + u.getEmail());
		
//		UserDAO.deleteUser(allUsers.get(0));
		
//		User userToBeAltered = allUsers.get(0);
//		userToBeAltered.setEmail("igazi@email.cim");
//		updateUser(userToBeAltered);
		
	}

}
