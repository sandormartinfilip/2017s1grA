package edu.msg.ro.business.bug.dto;

import java.util.Date;

import edu.msg.ro.business.dto.AbstractoDTO;
import edu.msg.ro.persistence.user.entity.BugSeverity;
import edu.msg.ro.persistence.user.entity.BugStatus;
import edu.msg.ro.persistence.user.entity.User;

public class BugDTO extends AbstractoDTO {

	private String title;
	private String description;
	private Date targetDate;
	private BugSeverity severity;
	private BugStatus status;
	private Double versionFound;
	private Double versionFixed;
	private User createdBy;
	private User assignedTo;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public BugSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(BugSeverity severity) {
		this.severity = severity;
	}

	public BugStatus getStatus() {
		return status;
	}

	public void setStatus(BugStatus status) {
		this.status = status;
	}

	public Double getVersionFound() {
		return versionFound;
	}

	public void setVersionFound(Double versionFound) {
		this.versionFound = versionFound;
	}

	public Double getVersionFixed() {
		return versionFixed;
	}

	public void setVersionFixed(Double versionFixed) {
		this.versionFixed = versionFixed;
	}

	@Override
	public String toString() {
		return "BugDTO [getId()=" + getId() + "]";
	}

}
