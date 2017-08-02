package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.PermissionDTOMapper;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.dao.PermissionDao;
import edu.msg.ro.persistence.user.dao.RoleDao;
import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.Role;

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
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());
	}

}
