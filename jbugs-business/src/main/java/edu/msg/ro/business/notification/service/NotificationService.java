package edu.msg.ro.business.notification.service;

import javax.ejb.Stateless;

import edu.msg.ro.persistence.user.entity.Notification;
import edu.msg.ro.persistence.user.entity.NotificationType;

/**
 *
 * TODO: make CDI Interceptor/decorator?
 *
 */
@Stateless
public class NotificationService {

	/**
	 * TODO extend it
	 */
	public Notification createNotification(final NotificationType notificationType) {
		return new Notification();
	}

}
