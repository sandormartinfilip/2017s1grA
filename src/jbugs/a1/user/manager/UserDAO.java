package jbugs.a1.user.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInterface{

	public boolean createUser(User u, Connection conn) {

		PreparedStatement preparedStatement = null;
		// ResultSet result = null;

		try {

			preparedStatement = conn.prepareStatement(
					"insert into `user` (`iduser`, `firstName`, `lastName`, `phoneNumber`,"
							+ " `email`, `username`, `password`, `status` ) values(?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, u.getId());
			preparedStatement.setString(2, u.getFirstName());
			preparedStatement.setString(3, u.getLastName());
			preparedStatement.setString(4, u.getPhoneNumber());
			preparedStatement.setString(5, u.getEmail());
			preparedStatement.setString(6, u.getUsername());
			preparedStatement.setString(7, u.getPassword());
			preparedStatement.setBoolean(8, u.getStatus());

			// preparedStatement.execute();
			// result = preparedStatement.getGeneratedKeys();
			preparedStatement.getGeneratedKeys();
			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				System.out.println(sse.getMessage());
			}
			try {
				conn.close();
			} catch (Exception cse) {
				System.out.println(cse.getMessage());
			}
		}
		return false;

	}

	public User readUser(int id, Connection conn) {

		try {
			User user = new User();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from `user` where `iduser` =?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt("iduser"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getBoolean("status"));
			}

			System.out.println("user: id " + user.getId() + ", " + "firstName " + user.getFirstName() + ", "
					+ "lastName " + user.getLastName());
			return user;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public boolean updateUser(User user, Connection conn) {

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("update  `user` set `firstName`=?, `lastName`=?, `phoneNumber`=?, "
							+ "`email`=?, `username`=?, `password`=? where `iduser` =?");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setBoolean(7, user.getStatus());

			return preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public boolean deleteUser(User user, Connection conn) {

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("delete from `user` where `iduser`=?");
			preparedStatement.setInt(1, user.getId());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> readAll(Connection conn) {
		
		try {
			List<User> userlist = new ArrayList<>();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from `user`");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				User user = new User();

				user.setId(resultSet.getInt("iduser"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getBoolean("status"));

				userlist.add(user);
			}
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
