package edu.msg.ro.persistence.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Notification extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private NotificationType notificationType;

	@Column
	private LocalDateTime creationDate;

	@ManyToOne
	@JoinColumn(name = "destinationUser", referencedColumnName = "id")
	private User destinationUser;

	@OneToOne
	@JoinColumn(name = "bugId")
	private Bug bugId;

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
