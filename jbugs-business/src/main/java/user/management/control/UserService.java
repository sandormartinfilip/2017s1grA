package user.management.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.UserDAO;
import entities.User;

@Stateless
public class UserService {

	@EJB
	UserDAO userDAO;

	// @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	// public void addUser(User user) {
	//
	// user.setFirstName("Alexa");
	// user.setLastName("Ghiurau");
	//
	// String username = createUsername("Alexa", "Ghiurau", 5, 1);
	//
	// user.setUsername(username);
	// user.setEmail("alexa.ghiurau@msggroup.com");
	//
	// userDAO.addUser(user);
	// }

	public List<User> getUsers() {

		return userDAO.getAllUsers();
	}

	public String createUsernameFromUser(User user) {
		return null;
	}

	public String createUsername(String firstName, String lastName, int lastNameIndex, int endIndex) {

		String username;
		username = lastName.substring(0, Math.min(lastName.length(), lastNameIndex)) + firstName.substring(0, endIndex);
		return username;
	}

}
