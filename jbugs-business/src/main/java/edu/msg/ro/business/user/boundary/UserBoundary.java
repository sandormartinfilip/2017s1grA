package edu.msg.ro.business.user.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Boundary for User Management.
 *
 * @author Andrei Floricel, msg systems ag
 *
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class UserBoundary {

	// private UserService userService;
	//
	// private NotificationService notificationService;
	//
	// public boolean deleteUser(final Long userId) {
	// try {
	// final boolean deletionSuccessful = userService.deleteUser(userId);
	//
	// if (deletionSuccessful) {
	// notificationService.createNotification(NotificationType.USER_DELETED);
	// // TODO send notification to client
	// }
	//
	// return deletionSuccessful;
	// } catch (final JBugsBusinessException e) {
	// // TODO add exception handling interceptor
	// // TODO add logger decorator?
	// e.printStackTrace();
	// return false;
	// }
	// }

}
