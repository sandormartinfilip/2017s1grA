package edu.msg.ro.persistence.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Notification extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private NotificationType notificationType;

	@Column
	private Timestamp creationDate;

	@Override
	public Long getId() {
		return this.id;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
