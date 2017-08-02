package edu.msg.ro.business.loginHistory;

import java.time.LocalDateTime;

import edu.msg.ro.business.dto.AbstractDTO;

/**
 *
 * @author petred
 *
 *         UNUSED CLASS
 */

// AbstractoDTO should be AbstractDTO ( without o )
public class LoginHistoryDTO extends AbstractDTO {

	private String username;

	private LocalDateTime loginDate;

	private boolean succes;

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(final LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public boolean isSucces() {
		return succes;
	}

	public void setSucces(final boolean succes) {
		this.succes = succes;
	}

	@Override
	public String toString() {
		return "LoginHistoryDTO [username=" + username + ", loginDate=" + loginDate + ", succes=" + succes + "]";
	}

}
