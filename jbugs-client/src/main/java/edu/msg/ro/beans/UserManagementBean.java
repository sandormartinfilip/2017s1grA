package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.user.dto.UserDTO;
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

	private UserDTO newUser = new UserDTO();

	private UserDTO editedUser;

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

		List<UserDTO> users = userService.getAllUsers();

		for (UserDTO u : users) {
			u.toString();
		}
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

	public String doSave() {
		System.out.println(editedUser.getFirstName());
		userService.updateUser(editedUser);
		return "users";
	}

	public String doCreateUser() {
		// userService.saveNewUser(newUser.getFirstName(),
		// newUser.getLastName());

		userService.addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getPhoneNumber(),
				newUser.getEmail());
		return "users";
	}

}
