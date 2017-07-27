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

	public List<UserDTO> getAllUsers() {
		List<UserDTO> listOfUsers = userService.getAllUsers();
		return listOfUsers;
	}

	// delete pe bune
	public void deleteUser(Long id) throws JBugsBusinessException {
		userService.deleteUser1(id);
	}

	// dezactivare user

	public void deactivateUser(Long id) throws JBugsBusinessException {
		userService.deleteUser(id);
	}

	// activare user

	public void activateUser(Long id) throws JBugsBusinessException {
		userService.activateUser(id);
	}

}
