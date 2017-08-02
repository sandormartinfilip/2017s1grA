package edu.msg.ro.persistence.notification.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.entity.Notification;

/**
 * 
 * @author nemesc
 *
 */
@Stateless
public class NotificationDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistNotification(final Notification notification) {
		em.persist(notification);
	}

	public Notification findById(final Long id) {
		return this.em.find(Notification.class, id);
	}

	public List<Notification> getAllNotificationsForUser(Long userId) {
		final TypedQuery<Notification> query = em.createNamedQuery(Notification.FIND_NOTIFICATIONS_FOR_USER,
				Notification.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	public void deleteNotification(Long id) {
		Notification notification = em.find(Notification.class, id);
		em.remove(notification);
	}

	public Notification updateNotification(Notification notification) {
		em.merge(notification);
		return notification;
	}

}
