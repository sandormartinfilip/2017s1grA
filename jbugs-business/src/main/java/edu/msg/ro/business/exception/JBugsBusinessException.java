package edu.msg.ro.business.exception;

/**
 * 
 * @author nemesc
 *
 */
public class JBugsBusinessException extends JBugsException {

	private static final long serialVersionUID = 8830941244115504817L;

	public static final String JBUGS_LOGIN_USERNAME_NOT_FOUND = "";
	public static final String JBUGS_LOGIN_WRONG_PASSWORD = "login.wrong_password";
	public static final String JBUGS_LOGIN_NOT_LOGGED_IN = "";

	public JBugsBusinessException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
