package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

@Named
@SessionScoped
public class UserManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8770276369676943814L;

	@EJB
	private UserService userService;

	private UserDTO newUser = new UserDTO();

	private UserDTO editedUser = new UserDTO();

	private Long editedUserId;

	public UserDTO getNewUser() {
		return newUser;
	}

	public void setNewUser(UserDTO newUser) {
		this.newUser = newUser;
	}

	public UserDTO getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(UserDTO editedUser) {
		this.editedUser = editedUser;
	}

	public List<UserDTO> getAllUsers() {

		List<UserDTO> users = userService.getAllUsers();
		return users;
	}

	public String deleteUser(Long id) {
		userService.deleteUser(id);
		return "users";
	}

	public String deactivateUser(String username) {
		userService.changeUserStatus(username, false);
		return "users";
	}

	public String activateUser(String username) {
		userService.changeUserStatus(username, true);
		return "users";
	}

	public Long getEditedUserId() {
		return editedUserId;
	}

	public String enableEditMode(Long id) {
		editedUserId = id;
		return "users";
	}

	public String disableEditMode() {
		editedUserId = null;
		return "users";
	}

	public String doSave() {
		System.out.println(editedUser.getFirstName());
		userService.updateUser(editedUser);
		return "users";
	}

	public String doCreateUser() {
		userService.saveNewUser(newUser.getFirstName(), newUser.getLastName());
		return "users";
	}

}
