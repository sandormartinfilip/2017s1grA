package jbugs.a1.user.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	public int createUser(User u, Connection conn) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			preparedStatement = conn.prepareStatement("insert into `user` (`iduser`, `firstName`, `lastName`, `phoneNumber`, `email`, `username`, `password`, `status` ) values(?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, u.getId());
			preparedStatement.execute();
			
			result = preparedStatement.getGeneratedKeys();

			if (result.next() && result != null) {
				return result.getInt(1);
			} else {
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
			} catch (Exception rse) {
				System.out.println(rse.getMessage());
			}
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
		return -1;

	}
}
