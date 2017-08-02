package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.RoleService;
import edu.msg.ro.business.user.service.UserService;

@ManagedBean
@ViewScoped
/**
 * 
 * @author cotete
 *
 */
public class UserManagementBean implements Serializable {

	private static final long serialVersionUID = -8770276369676943814L;

	private static final String USERS_URL = "users";

	@EJB
	private UserService userService;

	@EJB
	private RoleService roleService;

	private UserDTO newUser = new UserDTO();

	// users in this list are the ones edited in users.xhtml
	private List<UserDTO> users;

	private List<RoleDTO> selectedRoles = new ArrayList<>();

	@PostConstruct
	public void init() {
		users = userService.getAllUsers();
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<RoleDTO> rolesSelected) {
		this.selectedRoles = rolesSelected;
	}

	public UserDTO getNewUser() {
		return newUser;
	}

	public void setNewUser(UserDTO newUser) {
		this.newUser = newUser;
	}

	public List<UserDTO> getAllUsers() {

		List<UserDTO> users = userService.getAllUsers();

		return users;
	}

	public List<RoleDTO> getAllRoles() {

		List<RoleDTO> roles = roleService.getAllRoles();
		return roles;

	}

	public String deactivateUser(String username) {
		userService.changeUserStatus(username, false);
		return USERS_URL;
	}

	public String activateUser(String username) {
		userService.changeUserStatus(username, true);
		return USERS_URL;
	}

	public String doCreateUser() {
		// userService.saveNewUser(newUser.getFirstName(),
		// newUser.getLastName());
		System.out.println(selectedRoles.toString());

		userService.addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getPhoneNumber(), newUser.getEmail(),
				selectedRoles);

		return USERS_URL;
	}

	public String onRowEdit(RowEditEvent event) {
		UserDTO user = (UserDTO) event.getObject();

		userService.updateUser(user);
		System.out.println(user.toString());
		FacesMessage msg = new FacesMessage("User Edited", ((UserDTO) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return USERS_URL;
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((UserDTO) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
