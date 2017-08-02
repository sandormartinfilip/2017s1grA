package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.mapper.PermissionDTOMapper;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.dao.PermissionDao;
import edu.msg.ro.persistence.user.dao.RoleDao;
import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.PermissionManagementType;

@Stateless
public class PermissionService {

	@EJB
	PermissionDao permissionDao;

	@EJB
	private PermissionDTOMapper permissionMapper;

	@EJB
	RoleDao roleDao;

	@EJB
	private RoleService roleService;

	@EJB
	private RoleDTOMapper roleMapper;

	public void addNewPermission(final String description, final PermissionManagementType permissionType) {

		// de fapt aici trebuie sa verific rolul userului logat!
		// pot sa adaug permission din cele existente in db?
		final Permission newPermission = new Permission();

		// newPermission.setPermissionName(permissionName);
		newPermission.setDescription(description);
		newPermission.setPermissionType(permissionType);
		// newPermission.setPermissionName(permissionName);
		permissionDao.persistPermission(newPermission);
	}

	public List<PermissionDTO> getAllPermisions() {
		final List<Permission> permissions = permissionDao.getAllPermissions();
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());
	}

	public List<PermissionDTO> getAllPermissionNames() {
		final List<Permission> permissions = permissionDao.getAllPermissionNames();
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());
	}

	public List<PermissionDTO> getAllPermissionTypes() {
		final List<Permission> permissions = permissionDao.getAllPermissionTypes();
		return permissions.stream().map(permissionEntity -> permissionMapper.mapToDTO(permissionEntity))
				.collect(Collectors.toList());
	}

}
