package dao;

import java.io.Serializable;
import java.util.List;

import entities.User;

public interface UserDaoI extends Serializable {

	public void persistUser(final User user);

	public List<User> getUserByLastName(final String lastName);

}
