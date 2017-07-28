package edu.msg.ro.persistence.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bug extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "target_date")
	private LocalDateTime targetDate;

	@Column(name = "severity")
	private BugSeverity severity;

	@Column(name = "status")
	private BugStatus status;

	@Column(name = "versionFound")
	private String versionFound;

	@Column(name = "versionFixed")
	private String versionFixed;

	@ManyToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "id")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "assignedTo", referencedColumnName = "id")
	private User assignedTo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bugId")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bugId")
	private List<Attachment> attachments;

	@OneToOne(mappedBy = "bugId")
	private Notification notification;

	public Bug() {

	}

	public Bug(final String title, final String description, final LocalDateTime targetDate, final BugSeverity severity,
			final BugStatus status) {
		super();
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
		this.severity = severity;
		this.status = status;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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

	public LocalDateTime getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(final LocalDateTime targetDate) {
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

}
