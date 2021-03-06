package edu.msg.ro.business.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.ObjectNotFoundException;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistance.bug.dao.BugDao;
import edu.msg.ro.persistence.entity.Bug;
import edu.msg.ro.persistence.entity.LoginHistory;
import edu.msg.ro.persistence.entity.Role;
import edu.msg.ro.persistence.entity.User;
import edu.msg.ro.persistence.user.dao.LoginHistoryDao;
import edu.msg.ro.persistence.user.dao.RoleDao;
import edu.msg.ro.persistence.user.dao.UserDao;

/**
 * 
 * @author cotete
 *
 */
@Stateless
public class UserService {

	final static String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "msggroup.com";
	final static int LAST_NAME_INDEX = 5;
	final static int FIRST_NAME_INDEX = 1;

	@EJB
	private UserDao userDao;

	@EJB
	private RoleDao roleDao;

	@EJB
	private BugDao bugDao;

	@EJB
	private LoginHistoryDao loginHistoryDao;

	@EJB
	private UserDTOMapper userMapper;

	@EJB
	private RoleDTOMapper roleMapper;

	public boolean isValidUser(UserDTO loginUser) {
		UserDTO savedUser = getUserDTOByUsername(loginUser.getUsername());
		if (savedUser != null && savedUser.getPassword() != null) {

			return savedUser.getPassword().equals(loginUser.getPassword());
		}
		return false;
	};

	public boolean isActiveUser(UserDTO loginUser) {
		UserDTO savedUser = getUserDTOByUsername(loginUser.getUsername());
		return savedUser.isActive();
	}

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
		List<Bug> assignedBugs = bugDao.getBugsByAssignedTo(user);
		// TODO: A message that user cannot be updated if still has tasks
		if (status == false) {
			if (assignedBugs.size() == 0)

				user.setActive(status);
		} else {
			user.setActive(status);
		}

		userDao.updateUser(user);
		return true;
	}

	public boolean deleteUser(Long id) {
		userDao.deleteUser(id);
		return true;
	}

	public UserDTO getUserDTOByUsername(String userName) {
		User user = userDao.getUserByUsername(userName);
		if (user != null) {
			return userMapper.mapToDTO(user);
		} else
			return null;
	}

	public User getUserByUsername(String userName) {
		return userDao.getUserByUsername(userName);
	}

	public List<UserDTO> getAllUsers() {
		final List<User> allUsers = userDao.getAll();

		return allUsers.stream().map(userEntity -> userMapper.mapToDTO(userEntity)).collect(Collectors.toList());

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

	public void addUser(String firstName, String lastName, String phoneNumber, String email, List<RoleDTO> rolesDTO) {

		if (isEmailValid(email))
			if (isPhoneNumberValid(phoneNumber)) {

				String username = createUsername(firstName, lastName, LAST_NAME_INDEX, FIRST_NAME_INDEX);

				boolean ok = true;
				int nrOfUsers = 0;
				int nrOfUserslimit = 6;
				int numberInUsername = 1;
				int indexLast = LAST_NAME_INDEX;
				int indexFirst = FIRST_NAME_INDEX;
				List<Role> roles = new ArrayList<>();

				roles = getRolesFromDB(rolesDTO);

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
						user.setRoles(roles);
						userDao.persistUser(user);
						ok = false;
					} else {
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

	private List<Role> getRolesFromDB(List<RoleDTO> rolesDTO) {

		List<Role> roles = new ArrayList<>();
		for (RoleDTO r : rolesDTO) {
			Role role = roleDao.getRoleByRoleName(r.getRoleName());
			roles.add(role);
			System.out.println("Role Id: " + role.getId() + " Name: " + role.getRoleName());
		}
		return roles;
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
		if (phone.matches("[0-9]+"))
			if ((phone.startsWith("40") || phone.startsWith("49")) && (phone.length() == 11))
				return true;
		return false;

	}

	private String createPassword(String username) {
		String password = username + "Test123.";
		return password;
	}

	public int checkNoOfFails(String userName) {
		int failsNumber = 0;

		List<LoginHistory> loginHistoryList = loginHistoryDao.getLoginHistoryByUsername(userName);

		for (LoginHistory loginHistory : loginHistoryList) {
			if (!loginHistory.isSucces()) {
				failsNumber++;
			}

		}

		return failsNumber;
	}

	public void tryToLogin(String userName, boolean succes) {
		loginHistoryDao.tryToLogin(userName, succes);
	}

}
