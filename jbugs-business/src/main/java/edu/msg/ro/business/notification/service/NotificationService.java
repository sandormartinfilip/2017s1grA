package edu.msg.ro.business.notification.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.persistence.notification.dao.NotificationDao;

/**
 * 
 * TODO: make CDI Interceptor/decorator?
 *
 */
@Stateless
public class NotificationService {

	@EJB
	private NotificationDao notificationDao;

	// @EJB
	// private NotificationDTOMapper notificationMapper;

	/**
	 * TODO extend it
	 */
	// public Notification createNotification(final NotificationType
	// notificationType) {
	// return new Notification();
	// }
	//
	//
	// public void saveNewUser(final String firstName, final String lastName) {
	// final User newUser = new User();
	// newUser.setFirstName(firstName);
	// newUser.setLastName(lastName);
	// newUser.setActive(true);
	//
	// userDao.persistUser(newUser);
	// }
	//
	// public boolean deleteUser(Long id) {
	// userDao.deleteUser(id);
	// return true;
	// }
	//
	// public UserDTO getUserByUsername(String userName) {
	// User user = userDao.getUserByUsername(userName);
	// if (user != null) {
	// return userMapper.mapToDTO(user);
	// } else
	// return null;
	// }
	//
	// public void addUser(String firstName, String lastName, String
	// phoneNumber, String email) {
	//
	// }

}
