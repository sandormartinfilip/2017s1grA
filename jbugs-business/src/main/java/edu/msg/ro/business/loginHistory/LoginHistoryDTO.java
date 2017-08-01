package edu.msg.ro.business.loginHistory;

import java.time.LocalDateTime;

import edu.msg.ro.business.dto.AbstractoDTO;

/**
 * 
 * @author petred
 *
 */

// AbstractoDTO should be AbstractDTO ( without o )
public class LoginHistoryDTO extends AbstractoDTO {

	private String username;

	private LocalDateTime loginDate;

	private boolean succes;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public boolean isSucces() {
		return succes;
	}

	public void setSucces(boolean succes) {
		this.succes = succes;
	}

	@Override
	public String toString() {
		return "LoginHistoryDTO [username=" + username + ", loginDate=" + loginDate + ", succes=" + succes + "]";
	}

}
