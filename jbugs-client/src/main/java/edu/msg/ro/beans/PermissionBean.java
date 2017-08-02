package edu.msg.ro.beans;

import java.io.Serializable;
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

/**
 *
 * @author Alexa G, msg systems
 *
 */
@Named
@SessionScoped
public class PermissionBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6629110201735115445L;

	@EJB
	private PermissionService permissionService;

	private PermissionDTO permissionDTO = new PermissionDTO();

	private RoleDTO roleDTO = new RoleDTO();

	private Map<String, PermissionDTO> yourItems;

	@PostConstruct
	public void init() {
		yourItems = new HashMap<String, PermissionDTO>();
	}

	public PermissionDTO getPermissionDTO() {
		return permissionDTO;
	}

	public void setPermissionDTO(final PermissionDTO permissionDTO) {
		this.permissionDTO = permissionDTO;
	}

	public String doAddPermission() {
		permissionService.addNewPermission(permissionDTO.getDescription(), permissionDTO.getPermissionType());
		return "users";
	}

	public List<PermissionDTO> getAllPermissions() {
		final List<PermissionDTO> permissions = permissionService.getAllPermisions();
		return permissions;
	}

	public List<PermissionDTO> getAllPermissionNames() {
		final List<PermissionDTO> permissionNames = permissionService.getAllPermissionNames();
		return permissionNames;
	}

	public Map<String, PermissionDTO> getYourPermissionNames() {

		final List<PermissionDTO> permissionNames = permissionService.getAllPermissionNames();

		System.out.println("size of permission type list: " + permissionNames.size());
		for (final PermissionDTO permissionDTO : permissionNames) {
			yourItems.put(permissionDTO.getPermissionType().toString(), permissionDTO);
		}
		return yourItems;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(final RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

}
