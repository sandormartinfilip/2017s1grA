package edu.msg.ro.bean;

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
		if (userService.isValidUser(user)) {

			// facesContext.addMessage(null, new FacesMessage("We logged in,
			// yey"));

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			final HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			// HttpSession session = (HttpSession)
			// facesContext.getExternalContext().getSession(false);

			// sessionMap.put("username", user.getUserName());

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