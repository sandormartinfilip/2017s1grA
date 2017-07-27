package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class UserDTOMapper {

	public UserDTO mapToDTO(final User userEntity) {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setActive(userEntity.isActive());
		userDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setUsername(userEntity.getUsername());

		return userDTO;
	}

	public User mapToEntity(final UserDTO userDTO, final User userEntity) {
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setActive(userDTO.isActive());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPhoneNumber(userDTO.getPhoneNumber());

		return userEntity;
	}

}
