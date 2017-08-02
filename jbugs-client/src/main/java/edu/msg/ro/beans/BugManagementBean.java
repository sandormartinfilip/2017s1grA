package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.service.BugService;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.business.user.service.UserService;
import edu.msg.ro.persistence.entity.User;

@Named
@SessionScoped
public class BugManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private BugService bugService;

	@EJB
	private UserService userService;

	@EJB
	private UserDTOMapper userMapper;

	private Long editedBugId;
	private BugDTO editedBug = new BugDTO();
	private BugDTO newBug = new BugDTO();
	private String severity;
	private BugDTO selectedBug;

	public BugDTO getSelectedBug() {
		return selectedBug;
	}

	public void setSelectedBug(BugDTO selectedBug) {
		this.selectedBug = selectedBug;
	}

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
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		String usernameOfLoggedUser = (String) session.getAttribute("username");

		System.out.println(usernameOfLoggedUser);

		User user = userService.getUserByUsername(usernameOfLoggedUser);

		bugService.saveNewBug(newBug.getTitle(), newBug.getDescription(), newBug.getTargetDate(), newBug.getSeverity(),
				newBug.getVersionFound(), user);
		return "bugs";
	}

}
