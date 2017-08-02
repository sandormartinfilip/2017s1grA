package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.RoleService;
import edu.msg.ro.business.user.service.UserService;

@ManagedBean
@ViewScoped
public class UserManagementBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8770276369676943814L;

	@EJB
	private UserService userService;

	@EJB
	private RoleService roleService;

	private UserDTO newUser = new UserDTO();

	private UserDTO editedUser;

	private List<RoleDTO> selectedRoles = new ArrayList<>();

	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(final List<RoleDTO> rolesSelected) {
		this.selectedRoles = rolesSelected;
	}

	public UserDTO getNewUser() {
		return newUser;
	}

	public void setNewUser(final UserDTO newUser) {
		this.newUser = newUser;
	}

	public UserDTO getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(final UserDTO editedUser) {
		System.out.println("in setEditedUser() " + editedUser.getFirstName() + " + " + editedUser.getLastName());
		this.editedUser = editedUser;
	}

	public String doSaveEditedUser() {
		System.err.println("Editing the User " + editedUser.getFirstName() + " + " + editedUser.getLastName());
		userService.updateUser(editedUser);
		editedUser = null;
		return "users";
	}

	public List<UserDTO> getAllUsers() {

		final List<UserDTO> users = userService.getAllUsers();
		return users;
	}

	public List<RoleDTO> getAllRoles() {

		final List<RoleDTO> roles = roleService.getAllRoles();
		return roles;

	}

	public String deactivateUser(final String username) {
		userService.changeUserStatus(username, false);
		return "users";
	}

	public String activateUser(final String username) {
		userService.changeUserStatus(username, true);
		return "users";
	}

	public String doSave() {
		System.out.println(editedUser.getFirstName());
		userService.updateUser(editedUser);
		return "users";
	}

	public String doCreateUser() {
		// userService.saveNewUser(newUser.getFirstName(),
		// newUser.getLastName());
		System.out.println(selectedRoles.toString());

		userService.addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getPhoneNumber(), newUser.getEmail(),
				selectedRoles);

		return "users";
	}

	public void onCellEdit(final CellEditEvent event) {
		System.out.println("On CELL EDIT");
		final Object oldValue = event.getOldValue();
		final Object newValue = event.getNewValue();
		System.out.println(newValue.toString());

		if (newValue != null && !newValue.equals(oldValue)) {
			final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			System.out.println("Cell changed: Old" + oldValue + " New: " + newValue);
		}
	}

}
