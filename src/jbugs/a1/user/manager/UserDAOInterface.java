package jbugs.a1.user.manager;

import java.sql.Connection;
import java.util.List;

/**
 * DAO-Interface for the different ProductDAO-implementations. Defines the
 * CRUD-operations.
 */

public interface UserDAOInterface {

	public boolean createUser(User u, Connection conn);

	public User readUser(int id, Connection conn);

	public boolean updateUser(User user, Connection conn);

	public boolean deleteUser(User user, Connection conn);

	public List<User> readAll(Connection conn);
}
