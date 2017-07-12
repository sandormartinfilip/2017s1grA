package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {

	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/userdb";
	
	static final String USER="msg";
	static final String PASS="msg";
	
	public void create(User user){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			
			String sql = "INSERT INTO user(iduser, firstName, lastName, phoneNumber, email, username, password, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getIdUser());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getPhoneNumber());
			stmt.setString(7, user.getFirstName());
			stmt.setBoolean(8, user.isStatus());
			stmt.executeUpdate();
			
		} catch (SQLException se){
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(stmt!=null)
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void update(User user){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			
			String sql = "UPDATE user set firstName=?,lastName=?,phoneNumber=?,email=?,username=?,password=?,status=? where idUser=?";
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(6, user.getFirstName());
			stmt.setBoolean(7, user.isStatus());
			stmt.setInt(8, user.getIdUser());
			stmt.executeUpdate();
			
		} catch (SQLException se){
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(stmt!=null)
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int id){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			
			String sql = "delete from user where idUser=?";
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		} catch (SQLException se){
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(stmt!=null)
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<User> view(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			
			String sql = "select * from user";
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.prepareStatement(sql);
	//		stmt.setInt(1, id);
			ResultSet aa = stmt.executeQuery();
			List<User> users = new ArrayList<>();
			User user;
			while(aa.next()){
				user = new User();
				user.setFirstName(aa.getString("firstName"));
				user.setLastName(aa.getString("lastName"));
				user.setEmail(aa.getString("email"));
				user.setPassword(aa.getString("password"));
				user.setIdUser(aa.getInt("idUser"));
				user.setPhoneNumber(aa.getString("phoneNumber"));
				user.setStatus(aa.getBoolean("status"));
				users.add(user);
			}
			return users;
			
		} catch (SQLException se){
			System.out.println(se.getErrorCode());
			System.out.println(se.getMessage());
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				if(stmt!=null)
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
