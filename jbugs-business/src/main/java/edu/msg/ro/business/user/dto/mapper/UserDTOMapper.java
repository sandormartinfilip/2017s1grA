package edu.msg.ro.business.user.dto.mapper;

import javax.enterprise.context.Dependent;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

@Dependent
public class UserDTOMapper {

	public UserDTO mapToDTO(final User userEntity) {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setUsername(userEntity.getPassword());
		userDTO.setActive(userEntity.isActive());

		return userDTO;
	}

	public User mapToEntity(final UserDTO userDTO, final User userEntity) {
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userEntity.getLastName());
		userEntity.setActive(userDTO.isActive());

		return userEntity;
	}

}
