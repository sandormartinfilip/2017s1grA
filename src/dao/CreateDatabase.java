package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import model.User;

public class CreateDatabase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost";
	static final String USER = "msg";
	static final String PASS = "msg";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to the database");

			stmt = conn.createStatement();

			String sql = "create database if not exists userdatabase ";
			boolean result = stmt.execute(sql);

			System.out.println("Database created successfully");

			CreateTable.createTable(stmt, conn);

			System.out.println("back in main --- table created");

			UserDAO userDAO = new UserDAO();

			User user1 = new User(9, "Alex", "Noja", "0757783938", "noja.alex@gmail.com", "noja", "parola", 1);

			userDAO.createUser(user1);
			//
			ArrayList<User> users = userDAO.getUsers();
			 for (User u : users){
			 System.out.println("Id: "+u.getId());
			 System.out.println("First Name: "+u.getFirstName());
			 System.out.println("Last Name: "+u.getLastName());
			 System.out.println("Username : "+u.getUsername());
			 System.out.println("==============");
			 }

			user1.setLastName("Nojaaaaaaa");
			System.out.println(user1.getLastName() + "<------ new last name");
			userDAO.updateUser(user1);

			System.out.println("AFTER UPDATE!");
			users = userDAO.getUsers();
			for (User u : users) {
				System.out.println("Id: " + u.getId());
				System.out.println("First Name: " + u.getFirstName());
				System.out.println("Last Name: " + u.getLastName());
				System.out.println("Username : " + u.getUsername());
				System.out.println("==============");
			}

			//userDAO.deleteUser(6);

			System.out.println("AFTER DELETE!");
			users = userDAO.getUsers();
			for (User u : users) {
				System.out.println("Id: " + u.getId());
				System.out.println("First Name: " + u.getFirstName());
				System.out.println("Last Name: " + u.getLastName());
				System.out.println("Username : " + u.getUsername());
				System.out.println("==============");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
