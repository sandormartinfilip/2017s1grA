package edu.msg.ro.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
		@NamedQuery(name = Notification.FIND_NOTIFICATIONS_FOR_USER, query = "SELECT n from Notification n WHERE n.destinationUser = :userid"), })

@Entity
public class Notification extends AbstractEntity {

	public static final String FIND_NOTIFICATIONS_FOR_USER = "Notification.findNotificationsForUser";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private NotificationType notificationType;

	@Column
	private LocalDateTime creationDate;

	@Column
	private String text;

	@ManyToOne
	@JoinColumn(name = "destinationUser", referencedColumnName = "id")
	private User destinationUser;

	@OneToOne
	@JoinColumn(name = "bugId")
	private Bug bug;

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getDestinationUser() {
		return destinationUser;
	}

	public void setDestinationUser(User destinationUser) {
		this.destinationUser = destinationUser;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
