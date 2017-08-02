package edu.msg.ro.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.service.PermissionService;
import edu.msg.ro.business.user.service.RoleService;

/**
 *
 * @author Alexa G, msg systems
 *
 */
@Named
@SessionScoped
public class RoleBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 9072800298129446620L;

	@EJB
	private RoleService roleService;

	@EJB
	private PermissionService permissionService;

	private RoleDTO roleDTO = new RoleDTO();

	private PermissionDTO permissionDTO = new PermissionDTO();

	private List<PermissionDTO> permissionsDTOList = new ArrayList<>();

	private Map<String, RoleDTO> myRoles;

	@PostConstruct
	public void init() {
		myRoles = new HashMap<String, RoleDTO>();

	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(final RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public PermissionDTO getPermissionDTO() {
		return permissionDTO;
	}

	public void setPermissionDTO(final PermissionDTO permissionDTO) {
		this.permissionDTO = permissionDTO;
	}

	public List<RoleDTO> getAllRoles() {
		final List<RoleDTO> roles = roleService.getAllRoles();
		return roles;
	}

	public Map<String, RoleDTO> getYourRoleNames() {

		final List<RoleDTO> roleNames = roleService.getAllRoles();

		for (final RoleDTO roleDTO : roleNames) {
			myRoles.put(roleDTO.getRoleName(), roleDTO);
		}

		return myRoles;
	}

	public List<PermissionDTO> getPermissionsDTOList() {
		return permissionsDTOList;
	}

	public void setPermissionsDTOList(final List<PermissionDTO> permissionsDTOList) {
		this.permissionsDTOList = permissionsDTOList;
	}

	public void getAllPermOfaRole(final String roleName) {

		System.out.println("IN get all perm role");
		if (roleName != null) {
			this.permissionsDTOList = roleService.getAllPermissionsOfRole(roleName);
			// for (final PermissionDTO permissionDTO : permissions) {
			// System.out.println("permissionName: " +
			// permissionDTO.getPermissionName());
			// return permissions;
			// }
		}
		System.out.println("before null");
	}

}
