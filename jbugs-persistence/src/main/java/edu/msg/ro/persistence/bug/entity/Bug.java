package edu.msg.ro.persistence.bug.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.msg.ro.persistence.user.entity.AbstractEntity;

@Entity
public class Bug extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Override
	public Long getId() {
		return this.id;
	}

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Timestamp targetDate;

	@Column
	private BugSeverityType severity;

	@Column
	private BugStatusType status;

	// @ManyToOne
	// @JoinColumn(name = "id", nullable = false)
	// private User assignedTo;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Timestamp getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(final Timestamp targetDate) {
		this.targetDate = targetDate;
	}

	public BugSeverityType getSeverity() {
		return severity;
	}

	public void setSeverity(final BugSeverityType severity) {
		this.severity = severity;
	}

	public BugStatusType getStatus() {
		return status;
	}

	public void setStatus(final BugStatusType status) {
		this.status = status;
	}

	// public User getAssignedTo() {
	// return assignedTo;
	// }
	//
	// public void setAssignedTo(final User assignedTo) {
	// this.assignedTo = assignedTo;
	// }

}
