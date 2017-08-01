package edu.msg.ro.persistence.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @author petred
 *
 */

@NamedQueries({
		@NamedQuery(name = LoginHistory.FIND_LOGINHISTORY_BY_USERNAME, query = "SELECT l from LoginHistory l WHERE l.username = :userName ORDER BY l.loginDate DESC"), })

@Entity
public class LoginHistory {

	public static final String FIND_LOGINHISTORY_BY_USERNAME = "LoginHistory.findLoginHistoryByUserName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String username;

	@Column
	private Timestamp loginDate;

	public Timestamp getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}

	@Column
	private boolean succes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isSucces() {
		return succes;
	}

	public void setSucces(boolean succes) {
		this.succes = succes;
	}

}
