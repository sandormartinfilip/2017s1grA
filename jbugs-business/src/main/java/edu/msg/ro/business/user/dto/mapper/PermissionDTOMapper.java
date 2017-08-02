package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.persistence.entity.Permission;

@Stateless
public class PermissionDTOMapper {

	public PermissionDTO mapToDTO(final Permission permissionEntity) {
		final PermissionDTO permissionDTO = new PermissionDTO();

		permissionDTO.setId(permissionEntity.getId());
		permissionDTO.setPermissionName(permissionEntity.getPermissionName());
		permissionDTO.setDescription(permissionEntity.getDescription());

		return permissionDTO;
	}

	public Permission mapToEntity(final PermissionDTO permissionDTO, final Permission permissionEntity) {
		permissionEntity.setPermissionName(permissionDTO.getPermissionName());
		permissionEntity.setDescription(permissionDTO.getDescription());

		return permissionEntity;
	}
}
