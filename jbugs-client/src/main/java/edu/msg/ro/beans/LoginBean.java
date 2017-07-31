package edu.msg.ro.beans;

import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

@ManagedBean
@RequestScoped
public class LoginBean {

	@EJB
	private UserService userService;

	private UserDTO user = new UserDTO();

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String doLogin() {

		getFacesContext().getViewRoot().setLocale(Locale.ITALY);

		if (userService.isValidUser(user)) {

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			session.setAttribute("username", user.getUsername());
			return "users";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage("Password or Username wrong!"));
			return "login";
		}
	}

	public String doLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		// facesContext.getExternalContext().invalidateSession();
		return "login";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
