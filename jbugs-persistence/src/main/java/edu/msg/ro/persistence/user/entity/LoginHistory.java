package edu.msg.ro.persistence.user.entity;

import java.time.LocalDateTime;

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
		@NamedQuery(name = User.FIND_USER_BY_LASTNAME, query = "SELECT u from User u WHERE u.lastName = :lastName"),
		@NamedQuery(name = User.FIND_USER_BY_USERNAME, query = "SELECT u from User u WHERE u.username = :username"),
		@NamedQuery(name = User.FIND_ALL_USERS, query = "SELECT u from User u"), })

@Entity
public class LoginHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String username;

	@Column
	private LocalDateTime loginDate;

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

}
