package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.ObjectNotFoundException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.user.dao.UserDao;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class UserService {

	final static String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "msggroup.com";
	final static int LAST_NAME_INDEX = 5;
	final static int FIRST_NAME_INDEX = 1;

	@EJB
	private UserDao userDao;

	@EJB
	private UserDTOMapper userMapper;

	public void saveNewUser(final String firstName, final String lastName) {
		final User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setActive(true);

		userDao.persistUser(newUser);
	}

	public List<UserDTO> getUserByLastName(final String lastName) {
		final List<User> users = userDao.getUserByLastName(lastName);

		return users.stream().map(userEntity -> userMapper.mapToDTO(userEntity)).collect(Collectors.toList());
	}

	/**
	 * Delete the user with the given {@code userId}.
	 *
	 * @param userId
	 *            todo
	 * @return todo
	 * @throws JBugsBusinessException
	 *             if user with given id is not found
	 */
	public boolean deleteUser(final Long userId) throws JBugsBusinessException {
		final User user = userDao.findById(userId);
		if (user == null) {
			// TODO: maybe is better to return only false value!?
			throw new ObjectNotFoundException("User with id " + userId + " not found!");
		}
		// TODO
		// validate business constraints (Nu se pot sterge utilizatorii care au
		// asignate taskuri care nu sunt inca terminate / inchise) - in caz
		// contrar aruncam BusinessValidationException

		user.setActive(false);

		return true;
	}

	public void addUser(String firstName, String lastName, String phoneNumber, String email, String password) {

		if (isEmailValid(email))
			if (isPhoneNumberValid(phoneNumber)) {

				String username = createUsername(firstName, lastName, LAST_NAME_INDEX, FIRST_NAME_INDEX);

				boolean userInDB = true;

				int indexLast = LAST_NAME_INDEX;
				int indexFirst = FIRST_NAME_INDEX;

				User user = new User();

				int nrOfUsers = 0;
				List<User> usersFromDB = userDao.getUserForUsername(username);

				nrOfUsers = usersFromDB.size();
				System.out.println("================ " + usersFromDB.size() + "================== AICICICICICICCI");
				while (userInDB == true) {

					if (nrOfUsers <= 0) {
						user = new User();
						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setPhoneNumber(phoneNumber);
						user.setEmail(email);
						user.setPassword(password);
						user.setUsername(username);
						user.setActive(true);
						userDao.persistUser(user);

						userInDB = false;
					}
					nrOfUsers--;
					indexLast--;
					indexFirst++;
				}

				username = createUsername(firstName, lastName, indexLast, indexFirst);

			}
	}

	public String createUsername(String firstName, String lastName, int lastNameIndex, int endIndex) {

		String username;
		username = lastName.substring(0, Math.min(lastName.length(), lastNameIndex)) + firstName.substring(0, endIndex);
		return username;
	}

	public boolean isEmailValid(String email) {

		if (email.matches(EMAIL_REGEX))
			return true;
		return false;
	}

	public boolean isPhoneNumberValid(String phone) {

		if (phone.startsWith("+40") && (phone.length() == 12))
			return true;
		if (phone.startsWith("+49") && (phone.length() >= 5 && phone.length() <= 14))
			return true;
		return false;

	}

}
