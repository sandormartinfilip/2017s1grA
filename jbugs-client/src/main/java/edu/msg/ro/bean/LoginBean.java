package edu.msg.ro.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import edu.msg.ro.business.user.dto.UserDTO;

@Named
@RequestScoped
public class LoginBean {

	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

	public String doLogin() {

		if (user.getUsername().equals("test")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("iei, I logged in"));
			return "users";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username", new FacesMessage("NOO"));
			return "login";
		}
	}

}
