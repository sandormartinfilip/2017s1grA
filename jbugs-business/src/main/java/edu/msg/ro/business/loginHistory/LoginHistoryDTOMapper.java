package edu.msg.ro.business.loginHistory;

import javax.ejb.Stateless;

import edu.msg.ro.persistence.entity.LoginHistory;

/**
 * 
 * @author petred
 *
 */
@Stateless
public class LoginHistoryDTOMapper {

	public LoginHistoryDTO mapToDTO(final LoginHistory loginHistoryEntity) {
		final LoginHistoryDTO loginHistoryDTO = new LoginHistoryDTO();

		loginHistoryDTO.setId(loginHistoryEntity.getId());
		loginHistoryDTO.setLoginDate(loginHistoryEntity.getLoginDate());
		loginHistoryDTO.setUsername(loginHistoryEntity.getUsername());
		loginHistoryDTO.setSucces(loginHistoryEntity.isSucces());

		return loginHistoryDTO;
	}

	public LoginHistory mapToEntity(final LoginHistoryDTO loginHistoryDTO, final LoginHistory loginHistoryEntity) {
		loginHistoryEntity.setLoginDate(loginHistoryDTO.getLoginDate());
		loginHistoryEntity.setUsername(loginHistoryDTO.getUsername());
		loginHistoryEntity.setSucces(loginHistoryDTO.isSucces());

		return loginHistoryEntity;
	}

}
