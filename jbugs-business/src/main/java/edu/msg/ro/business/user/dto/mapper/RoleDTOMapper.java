package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

@Stateless
public class RoleDTOMapper {

	public RoleDTO mapToDTO(final Role role) {
		final RoleDTO roleDTO = new RoleDTO();

		roleDTO.setId(role.getId());
		roleDTO.setRoleName(role.getRoleName());

		return roleDTO;
	}

	public Role mapToEntity(final RoleDTO roleDTO, final Role roleEntity) {
		roleEntity.setRoleName(roleDTO.getRoleName());

		return roleEntity;
	}

	public Role toEntity(final RoleDTO roleDTO) {
		final Role role = new Role();
		role.setRoleName(roleDTO.getRoleName());
		return role;
	}

}
