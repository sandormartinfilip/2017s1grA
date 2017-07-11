package UserManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	public void addUser(User user, Connection conn){
		Statement stmt = null;
		
		String sql = "INSERT INTO user (idUser, firstName, lastName, phoneNumber, email, username, password, status) "
				+ "VALUES ( " + user.getIdUser()+ ", '" + user.getFirstName() + "', '" + user.getLastName() 
				+ "', '" + user.getPhoneNumber() + "', '" + user.getEmail() + "', '" + user.getUsername() + "', '"
				+ user.getPassword() + "', " + user.getStatus() + ");";
				
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
