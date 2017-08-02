package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.service.BugService;

@Named
@SessionScoped
public class BugManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private BugService bugService;

	private Long editedBugId;
	private BugDTO editedBug = new BugDTO();
	private BugDTO newBug = new BugDTO();
	private String severity;

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public BugDTO getNewBug() {
		return newBug;
	}

	public void setNewBug(BugDTO newBug) {
		this.newBug = newBug;
	}

	public BugDTO getEditedBug() {
		return editedBug;
	}

	public void setEditedBug(BugDTO editedBug) {
		this.editedBug = editedBug;
	}

	public Long getEditedBugId() {
		return editedBugId;
	}

	public String enableEditMode(Long id) {
		editedBugId = id;
		return "bugs";
	}

	public String disableEditMode() {
		editedBugId = null;
		return "bugs";
	}

	public List<BugDTO> getAllBugs() {
		List<BugDTO> bugs = bugService.getAllBugs();
		return bugs;
	}

	public String deleteBug(Long id) {
		bugService.deleteBug(id);
		return "bugs";
	}

	public String doSave() {
		System.out.println(editedBug.getTitle());
		bugService.updateBug(editedBug);
		return "bugs";
	}

	public String doCreateBug() {
		bugService.saveNewBug(newBug.getTitle(), newBug.getDescription(), newBug.getTargetDate(), newBug.getSeverity(),
				newBug.getVersionFound());
		return "bugs";
	}

}
