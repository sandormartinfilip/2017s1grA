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

import org.primefaces.model.DualListModel;

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

	private DualListModel<PermissionDTO> allPermissions;

	@PostConstruct
	public void init() {
		myRoles = new HashMap<String, RoleDTO>();

		final List<PermissionDTO> allPermissionsSource = getAllPermissions();
		final List<PermissionDTO> allPermissionsTarget = new ArrayList<PermissionDTO>();

		allPermissions = new DualListModel<PermissionDTO>(allPermissionsSource, allPermissionsTarget);

	}

	public DualListModel<PermissionDTO> getAllPermissionsDual() {
		return allPermissions;
	}

	public void setAllPermissions(final DualListModel<PermissionDTO> allPermissions) {
		this.allPermissions = allPermissions;
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

	public List<PermissionDTO> getAllPermissions() {
		final List<PermissionDTO> permissions = permissionService.getAllPermisions();
		return permissions;
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

	/**
	 *
	 * @param roleName
	 * @return roles page if success, users page otherwise
	 *
	 *         Currently not used because there's a chance the query for getting
	 *         all the permissions of a role is not correct
	 *
	 */
	public String getAllPermissionsOfARoleUsingQuery(final String roleName) {

		if (roleName != null) {
			this.permissionsDTOList = roleService.getAllPermissionsOfRole(roleName);
			return "roles";
		}

		return "users";
	}

	/**
	 *
	 * @param roleName
	 * @return
	 */
	public String getAllPermissionsOfARoleNoQuerry(final String roleName) {

		System.out.println("IN get all perm role");
		if (roleName != null && !roleName.isEmpty()) {
			System.out.println("in if");
			System.out.println("rolename: in role" + roleName);

			this.permissionsDTOList = roleService.getAllPermissionsOfARoleNoQuerry(roleName);

			for (final PermissionDTO permissionDTO : permissionsDTOList) {
				System.out.println("permissionDTO: " + permissionDTO.toString());
			}
			return "roles";
		}
		System.out.println("rolename: " + roleName);
		System.out.println("before null");
		return "users";
	}

}
