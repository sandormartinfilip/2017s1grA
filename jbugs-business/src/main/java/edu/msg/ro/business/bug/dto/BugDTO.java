package edu.msg.ro.business.bug.dto;

import java.util.Date;

import edu.msg.ro.business.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.BugSeverity;
import edu.msg.ro.persistence.user.entity.BugStatus;
import edu.msg.ro.persistence.user.entity.User;

public class BugDTO extends AbstractDTO {

	private String title;
	private String description;
	private Date targetDate;
	private BugSeverity severity;
	private BugStatus status;
	private String versionFound;
	private String versionFixed;
	private User createdBy;
	private User assignedTo;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final User createdBy) {
		this.createdBy = createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(final User assignedTo) {
		this.assignedTo = assignedTo;
	}

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

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(final Date targetDate) {
		this.targetDate = targetDate;
	}

	public BugSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(final BugSeverity severity) {
		this.severity = severity;
	}

	public BugStatus getStatus() {
		return status;
	}

	public void setStatus(final BugStatus status) {
		this.status = status;
	}

	public String getVersionFound() {
		return versionFound;
	}

	public void setVersionFound(final String versionFound) {
		this.versionFound = versionFound;
	}

	public String getVersionFixed() {
		return versionFixed;
	}

	public void setVersionFixed(final String versionFixed) {
		this.versionFixed = versionFixed;
	}

	@Override
	public String toString() {
		return "BugDTO [getId()=" + getId() + "]";
	}

}
