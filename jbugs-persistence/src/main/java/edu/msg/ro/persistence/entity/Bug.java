package edu.msg.ro.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
		@NamedQuery(name = Bug.FIND_BUG_BY_SEVERITY, query = "SELECT b from Bug b where b.severity = :severity"),
		@NamedQuery(name = Bug.FIND_BUG_BY_STATUS, query = "SELECT b from Bug b where b.status = :status"),
		@NamedQuery(name = Bug.FIND_ALL_BUGS, query = "SELECT b from Bug b"), })

@Entity
public class Bug extends AbstractEntity {

	public static final String FIND_BUG_BY_SEVERITY = "Bug.findBugBySeverity";
	public static final String FIND_BUG_BY_STATUS = "Bug.findBugByStatus";
	public static final String FIND_ALL_BUGS = "Bug.findAllBugs";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "targetDate")
	private Date targetDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "severity")
	private BugSeverity severity;

	@Enumerated(EnumType.STRING)
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

	@OneToOne(mappedBy = "bug")
	private Notification notification;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bug other = (Bug) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
