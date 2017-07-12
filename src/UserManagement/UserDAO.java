package UserManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	public void addUser(User user, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();

		String sql = "INSERT INTO user (idUser, firstName, lastName, phoneNumber, email, username, password, status) "
				+ "VALUES ( " + user.getIdUser() + ", '" + user.getFirstName() + "', '" + user.getLastName() + "', '"
				+ user.getPhoneNumber() + "', '" + user.getEmail() + "', '" + user.getUsername() + "', '"
				+ user.getPassword() + "', " + user.getStatus() + ");";

		try {
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(int idUser, String newPhone, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();

		String sql = "UPDATE user " + "SET phoneNumber = '" + newPhone + "'  WHERE idUser= " + idUser + ";";
		stmt.executeUpdate(sql);

		try {
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int idUser, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();

		String sql = "DELETE FROM user WHERE idUser= " + idUser + ";";
		stmt.executeUpdate(sql);

		try {
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showTheUsers(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();

		String sql = "SELECT idUser, firstName, lastName, phoneNumber, email, username, password, status FROM user";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			// Retrieve by column name
			int id = rs.getInt("idUser");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			String username = rs.getString("username");
			String password = rs.getString("password");
			int status = rs.getInt("status");

			// Display values
			System.out.println();
			System.out.print("ID: " + id);
			System.out.print(", first name: " + firstName);
			System.out.print(", last name: " + lastName);
			System.out.print(", phone number: " + phoneNumber);
			System.out.print(", email: " + email);
			System.out.print(", username: " + username);
			System.out.print(", password: " + password);
			System.out.print(", status: " + status);

		}
		rs.close();
	}
}
