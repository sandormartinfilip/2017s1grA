package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.dto.AbstractoDTO;

public class UserDTO extends AbstractoDTO {

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private String phoneNumber;

	private String email;

	private boolean active;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [getId()=" + getId() + "]";
	}

}
