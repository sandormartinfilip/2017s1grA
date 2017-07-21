package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.dto.AbstractoDTO;

public class UserDTO extends AbstractoDTO {

	private String firstName;

	private String lastName;

	private boolean active;

	private String phone;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	@Override
	public String toString() {
		return "UserDTO [getId()=" + getId() + "]";
	}

}
