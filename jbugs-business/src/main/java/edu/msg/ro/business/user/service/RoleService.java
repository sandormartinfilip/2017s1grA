package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.PermissionDTOMapper;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.entity.Permission;
import edu.msg.ro.persistence.entity.Role;
import edu.msg.ro.persistence.user.dao.PermissionDao;
import edu.msg.ro.persistence.user.dao.RoleDao;

@Stateless
public class RoleService {

	@EJB
	private RoleDao roleDao;

	@EJB
	private RoleDTOMapper roleMapper;

	@EJB
	private PermissionDao permissionDao;

	@EJB
	private PermissionDTOMapper permissionMapper;

	public List<RoleDTO> getAllRoles() {
		final List<Role> roles = roleDao.getAllRoles();
		return roles.stream().map(roleEntity -> roleMapper.mapToDTO(roleEntity)).collect(Collectors.toList());
	}

	public List<PermissionDTO> getAllPermissionsOfRole(final String roleName) {
		final List<Permission> permissions = roleDao.getAllPermissionsOfARole(roleName);
		for (final Permission permission : permissions) {
			System.out.println("Permission: " + permission.toString());
		}
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());
	}

	public RoleDTO getRoleByRoleName(final String roleName) {

		final Role role = roleDao.getRoleByRoleName(roleName);
		if (role != null) {
			return roleMapper.mapToDTO(role);
		} else
			return null;
	}

	/**
	 *
	 * @param roleName
	 * @return TODO: return type better be a RoleDTO!
	 */
	public List<PermissionDTO> getAllPermissionsOfARoleNoQuerry(final String roleName) {

		// final Role role = roleDao.getRoleByRoleName(roleDTO.getRoleName());
		final Role role = roleDao.getRoleByRoleName(roleName);
		final List<Permission> permissions = role.getPermissions();
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());

	}

}
