package ejb;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.UserDao;
import dto.UserDTO;
import dto.mapper.UserDTOMapper;
import entities.User;

@Stateless
public class UserService {

	@EJB
	private UserDao userDao;

	@EJB
	private UserDTOMapper userMapper;

	// parametrul aici va fi DTO-ul, de ex UserDTO (nu String firstName)
	public void saveNewUser(final String firstName, final String lastName) {

		final User newUser = new User();
		newUser.setFirstName(firstName + lastName);
		newUser.setLastName(lastName);

		String username = lastName.substring(0, Math.min(lastName.length(), 5)) + firstName.substring(0, 1);
		newUser.setUsername(username);

		userDao.persistUser(newUser);
	}

	public List<UserDTO> getUserByLastName(final String lastName) {
		List<User> users = userDao.getUserByLastName(lastName);

		return users.stream().map(userEntity -> userMapper.mapToDTO(userEntity)).collect(Collectors.toList());
	}

}
