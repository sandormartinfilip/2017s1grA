package edu.msg.ro.beans;

import java.util.Locale;

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

		// getFacesContext().getViewRoot().setLocale(Locale.ITALY);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		String gRecaptchaResponse = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("g-recaptcha-response");
		try {
			boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
			FacesContext context = FacesContext.getCurrentInstance();

			// trebuie adaugat si verify de la Captcha
			if (userService.isActiveUser(user)) {
				if (userService.isValidUser(user)) {

					getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

					session.setAttribute("username", user.getUsername());
					return "users";
				} else {
					loginFailed++;
					context.addMessage(null, new FacesMessage("Select Captcha"));
					context.addMessage("loginForm:username", new FacesMessage("Password or Username wrong!"));

					if (loginFailed >= 4) {
						System.out.println(loginFailed);
						userService.changeUserStatus(user.getUsername(), false);
					}

					return "login";
				}
			} else {
				context.addMessage("loginForm:username", new FacesMessage("Your account is deactivated!"));
				return "login";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "login";
		}

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

		return "login";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	// included in doLogin
	public String submit_form() {
		try {
			String gRecaptchaResponse = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("g-recaptcha-response");
			boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
			if (verify) {
				return "Success";
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Select Captcha"));
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
