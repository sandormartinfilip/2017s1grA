package edu.msg.ro.beans;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

@ManagedBean
@RequestScoped
public class LoginBean extends JBugsBean {

	@EJB
	private UserService userService;

	private UserDTO user = new UserDTO();

	private String lang = "";

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String doLogin() {
		if (userService.isValidUser(user)) {

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			session.setAttribute("username", user.getUsername());
			session.setAttribute("lang", this.lang);
			getFacesContext().getViewRoot().setLocale(new Locale(this.lang));
			return "users";
		} else {
			ResourceBundle rb = ResourceBundle.getBundle("jbugs/messages");
			this.handleException(
					new JBugsBusinessException(rb.getString(JBugsBusinessException.JBUGS_LOGIN_WRONG_PASSWORD)));
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
