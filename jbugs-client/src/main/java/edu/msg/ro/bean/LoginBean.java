package edu.msg.ro.bean;

import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

@Named
@RequestScoped
public class LoginBean {

	private UserDTO user = new UserDTO();

	@Inject
	private UserService userService;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

	public String doLoginDeprecated() {

		if (user.getUsername().equals("test")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("YAY, we logged in!"));
			return "users";
		}
		FacesContext.getCurrentInstance().addMessage("loginForm:username", new FacesMessage("FAILED TO LOG IN"));
		return "login";
	}

	public String doLogin() {

		getFacesContext().getViewRoot().setLocale(Locale.ITALY);
		// merge la baza de date si verifica daca e usenameul
		if (userService.isValidUser(user)) {

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			final HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			session.setAttribute("username", user.getUsername());
			return "users";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage("Password or Username wrong!"));
			return "login";
		}
	}

	public String doLogout() {
		final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.invalidate();
		// facesContext.getExternalContext().invalidateSession();
		return "login";
	}

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
