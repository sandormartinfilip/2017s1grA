package edu.msg.ro.beans;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

	@ManagedProperty(value = "#{captcha}")
	private CaptchaBean captchaBean;

	public CaptchaBean getCaptchaBean() {
		return captchaBean;
	}

	public void setCaptchaBean(CaptchaBean captchaBean) {
		this.captchaBean = captchaBean;
	}

	private String lang = "en";

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	/*
	 * public String getLanguage() { if
	 * (getFacesContext().getViewRoot().getLocale().equals(Locale.ENGLISH)) {
	 * getFacesContext().getViewRoot().setLocale(Locale.ITALY); } if
	 * (getFacesContext().getViewRoot().getLocale().equals(Locale.ITALY)) {
	 * getFacesContext().getViewRoot().setLocale(Locale.ENGLISH); }
	 * 
	 * return "login"; }
	 */
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String doLogin() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		FacesContext context = FacesContext.getCurrentInstance();

		if (userService.isActiveUser(user)) {
			if (userService.isValidUser(user) && (userService.checkNoOfFails(user.getUsername()) < 5)) {

				getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

				session.setAttribute("username", user.getUsername());
				session.setAttribute("lang", this.lang);

				getFacesContext().getViewRoot().setLocale(new Locale(this.lang));

				userService.tryToLogin(user.getUsername(), true);

				return "users";
			} else {

				ResourceBundle rb = ResourceBundle.getBundle("jbugs/messages");
				this.handleException(
						new JBugsBusinessException(rb.getString(JBugsBusinessException.JBUGS_LOGIN_WRONG_PASSWORD)));

				context.addMessage(null, new FacesMessage("Select Captcha"));
				context.addMessage("loginForm:username", new FacesMessage("Password or Username wrong!"));

				userService.tryToLogin(user.getUsername(), false);

				if (userService.checkNoOfFails(user.getUsername()) == 5) {
					userService.changeUserStatus(user.getUsername(), false);
					System.out.println("s-a schimbat statusul");
				} else {
					System.out.println("nu se schimba statusul");
				}

				return "login";
			}
		} else {
			context.addMessage("loginForm:username", new FacesMessage("Your account is deactivated!"));
			return "login";
		}
	}

	public String doLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();

		return "login";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public String doLoginWithCaptcha() {
		captchaBean.submit();
		return doLogin();
	}

}
