package edu.msg.ro.business.notification.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.persistence.entity.Notification;

@Stateless
public class NotificationDTOMapper {

	public NotificationDTO mapToDTO(final Notification notificationEntity) {
		final NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO.setBug(notificationEntity.getBug());
		notificationDTO.setCreationDate(notificationEntity.getCreationDate());
		notificationDTO.setDestinationUser(notificationEntity.getDestinationUser());
		notificationDTO.setId(notificationEntity.getId());
		notificationDTO.setNotificationType(notificationEntity.getNotificationType());
		return notificationDTO;
	}

	public Notification mapToEntity(final NotificationDTO notificationDTO) {
		final Notification notificationEntity = new Notification();
		notificationEntity.setBug(notificationDTO.getBug());
		notificationEntity.setCreationDate(notificationDTO.getCreationDate());
		notificationEntity.setDestinationUser(notificationDTO.getDestinationUser());
		notificationEntity.setId(notificationDTO.getId());
		notificationEntity.setNotificationType(notificationDTO.getNotificationType());
		return notificationEntity;
	}

}
