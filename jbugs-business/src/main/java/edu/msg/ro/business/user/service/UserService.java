package edu.msg.ro.business.user.service;

import java.util.ArrayList;
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

	public boolean isValidUser(UserDTO loginUser) {
		UserDTO savedUser = getUserByUsername(loginUser.getUsername());
		if (savedUser != null && savedUser.getPassword() != null) {

			return savedUser.getPassword().equals(loginUser.getPassword());
		}
		return false;
	};

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
	// public boolean deleteUser(final Long userId) throws
	// JBugsBusinessException {
	// final User user = userDao.findById(userId);
	// if (user == null) {
	// // TODO: maybe is better to return only false value!?
	// throw new ObjectNotFoundException("User with id " + userId + " not
	// found!");
	// }
	// // TODO
	// // validate business constraints (Nu se pot sterge utilizatorii care au
	// // asignate taskuri care nu sunt inca terminate / inchise) - in caz
	// // contrar aruncam BusinessValidationException
	//
	// user.setActive(false);
	//
	// return true;
	// }

	public boolean changeUserStatus(String username, boolean status) {
		User user = userDao.getUserByUsername(username);
		if (user == null) {
			try {
				throw new ObjectNotFoundException("User " + username + " not found!");
			} catch (ObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO
		// validate business constraints (Nu se pot sterge utilizatorii care au
		// asignate taskuri care nu sunt inca terminate / inchise) - in caz
		// contrar aruncam BusinessValidationException

		user.setActive(status);

		userDao.updateUser(user);
		return true;
	}

	public boolean deleteUser(Long id) {
		userDao.deleteUser(id);
		return true;
	}

	public UserDTO getUserByUsername(String userName) {
		User user = userDao.getUserByUsername(userName);
		if (user != null) {
			return userMapper.mapToDTO(user);
		} else
			return null;
	}

	public List<UserDTO> getAllUsers() {
		final List<User> allUsers = userDao.getAll();
		List<UserDTO> allUsersDTO = new ArrayList<UserDTO>();

		for (User u : allUsers) {
			allUsersDTO.add(userMapper.mapToDTO(u));
		}
		// return allUsers.stream().map(userEntity ->
		// userMapper.mapToDTO(userEntity)).collect(Collectors.toList());
		return allUsersDTO;
	}

	public void updateUser(UserDTO userDTO) {
		User user = userDao.findById(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPassword(userDTO.getPassword());
		user.setActive(userDTO.isActive());

		userDao.updateUser(user);
	}

	public void addUser(String firstName, String lastName, String phoneNumber, String email) {

		if (isEmailValid(email))
			if (isPhoneNumberValid(phoneNumber)) {

				String username = createUsername(firstName, lastName, LAST_NAME_INDEX, FIRST_NAME_INDEX);

				boolean ok = true;
				int nrOfUsers = 0;
				int nrOfUserslimit = 6;
				int numberInUsername = 1;
				int indexLast = LAST_NAME_INDEX;
				int indexFirst = FIRST_NAME_INDEX;

				User user = new User();
				User userFromDB = null;
				while (ok) {
					userFromDB = userDao.getUserByUsername(username);

					// if no user in DB with current username
					if (userFromDB == null) {
						user = new User();
						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setPhoneNumber(phoneNumber);
						user.setEmail(email);
						user.setUsername(username);
						user.setActive(true);
						user.setPassword(createPassword(username));
						userDao.persistUser(user);
						ok = false;
					} else {
						System.out.println(username + "=============");
						nrOfUsers++;
						indexLast--;
						indexFirst++;
						if (nrOfUsers < nrOfUserslimit) {
							username = createUsername(firstName, lastName, indexLast, indexFirst);
						} else {
							username = createUsername(firstName, numberInUsername);
							numberInUsername++;
						}
					}
				}
			}

	}

	private String createUsername(String firstName, String lastName, int lastNameIndex, int endIndex) {

		String username;
		username = lastName.substring(0, Math.min(lastName.length(), lastNameIndex)) + firstName.substring(0, endIndex);
		return username;
	}

	private String createUsername(String firstName, int index) {
		String username = firstName + index;
		return username;
	}

	private boolean isEmailValid(String email) {

		if (email.matches(EMAIL_REGEX))
			return true;
		return false;
	}

	private boolean isPhoneNumberValid(String phone) {
		if (phone.substring(1).matches("[0-9]+") && phone.substring(0, 1).equals("+"))
			if (phone.startsWith("+40") && (phone.length() == 12))
				return true;
		if (phone.startsWith("+49") && (phone.length() >= 5 && phone.length() <= 14))
			return true;
		return false;

	}

	private String createPassword(String username) {
		String password = username + "Test123.";
		return password;
	}
}
