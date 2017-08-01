package edu.msg.ro.business.exception;

public class JBugsBusinessException extends JBugsException {

	private static final long serialVersionUID = 8830941244115504817L;

	public static final String JBUGS_LOGIN_WRONG_USERNAME_PASSWORD = "login.wrong_username_password";
	public static final String JBUGS_LOGIN_ACCOUNT_DEACTIVATED = "login.account_deactivated";
	public static final String JBUGS_LOGIN_NOT_LOGGED_IN = "";

	public JBugsBusinessException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
