package edu.msg.ro.bean;

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

	private UserDTO user = new UserDTO();

	@EJB
	private UserService userService;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String doLogin() {
		if (userService.isValidUser(user)) {

			// facesContext.addMessage(null, new FacesMessage("We logged in,
			// yey"));

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			// HttpSession session = (HttpSession)
			// facesContext.getExternalContext().getSession(false);

			// sessionMap.put("username", user.getUserName());

			session.setAttribute("username", user.getUsername());
			return "users";
		} else {
			getFacesContext().addMessage("loginForm:username", new FacesMessage("Password or Username wrong!"));
			return "login";
		}
	}

	public String doLogout() {
		HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);
		session.invalidate();
		// facesContext.getExternalContext().invalidateSession();
		return "login";
	}

	/**
	 * Sadly FacesContext is not injectable. For Consistency's sake the
	 * recommended way of getting it is with a producer.
	 * 
	 * @return {@link FacesContext}
	 */
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
