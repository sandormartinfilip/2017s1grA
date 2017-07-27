package edu.msg.ro.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

@Named
@RequestScoped
public class UserManagementBean {

	@Inject
	private UserService userService;

	private UserDTO userDTO = new UserDTO();

	private UserDTO editedUser = new UserDTO();

	private Long editedUserId;

	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	public String deleteUser(final Long id) throws JBugsBusinessException {
		userService.deleteUserr(id);
		return "users";
	}

	public String activateUser(final Long id) throws JBugsBusinessException {
		userService.activateUser(id);
		return "users";
	}

	public Long getEditedUserId() {
		return editedUserId;
	}

	public String deactivateUser(final Long id) throws JBugsBusinessException {
		userService.deactivateUser(id);
		return "users";
	}

	public String enableEditMode(final Long id) {
		if (editedUserId == null)
			editedUserId = id;
		return "users";
	}

	public String disableEditMode(final Long id) {
		editedUserId = null;
		return "users";
	}

	public Long getEditedUserId(final Long id) {
		return editedUserId;
	}

	public String doSave() {
		userService.updateUser(editedUser);
		return "users";
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(final UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String doCreateUser() {
		userService.saveNewUser(userDTO.getFirstName(), userDTO.getLastName());
		return "users";
	}

	public UserDTO getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(final UserDTO editedUser) {
		this.editedUser = editedUser;
	}

}
