package edu.msg.ro.business.notification.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.notification.dto.mapper.NotificationDTOMapper;
import edu.msg.ro.persistence.entity.Notification;
import edu.msg.ro.persistence.notification.dao.NotificationDao;

/**
 * 
 * @author nemesc
 *
 */
@Stateless
public class NotificationService {

	@EJB
	private NotificationDao notificationDao;

	@EJB
	private NotificationDTOMapper notificationMapper;

	public void createNotification(NotificationDTO notificationDTO) {
		Notification notification = notificationMapper.mapToEntity(notificationDTO);
		notificationDao.persistNotification(notification);
	}

	public List<NotificationDTO> getNotificationsForUser(Long userId) {
		List<Notification> list = notificationDao.getAllNotificationsForUser(userId);
		return list.stream().map(entity -> notificationMapper.mapToDTO(entity)).collect(Collectors.toList());
	}

	public void deleteNotification(Long id) {
		notificationDao.deleteNotification(id);
	}

}
