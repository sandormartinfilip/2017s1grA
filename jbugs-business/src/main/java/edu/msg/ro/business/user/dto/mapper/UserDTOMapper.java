package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.entity.User;

@Stateless
public class UserDTOMapper {

	public UserDTO mapToDTO(final User userEntity) {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setActive(userEntity.isActive());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setUsername(userEntity.getUsername());

		return userDTO;
	}

	public User mapToEntity(final UserDTO userDTO, final User userEntity) {
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userEntity.getLastName());
		userEntity.setActive(userDTO.isActive());
		userEntity.setPhoneNumber(userDTO.getPassword());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPhoneNumber(userDTO.getPhoneNumber());
		userEntity.setPassword(userDTO.getPassword());
		return userEntity;
	}

}
