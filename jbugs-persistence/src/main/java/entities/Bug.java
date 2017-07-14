package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bug")
public class Bug implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBug")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "target_date")
	private Timestamp targetDate;

	@Column(name = "severuty")
	private BugSeverity severity;

	@Column(name = "status")
	private BugStatus status;

	public Bug() {

	}

	public Bug(String title, String description, Timestamp targetDate, BugSeverity severity, BugStatus status) {
		super();
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
		this.severity = severity;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Timestamp targetDate) {
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

	
}
