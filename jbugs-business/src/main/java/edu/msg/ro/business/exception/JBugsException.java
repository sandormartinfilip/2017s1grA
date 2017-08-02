package edu.msg.ro.business.exception;

/**
 * 
 * @author nemesc
 *
 */
public class JBugsException extends Exception {

	private static final long serialVersionUID = 67783889987374141L;

	private String errorMessageKey;

	public JBugsException(String message) {
		this.errorMessageKey = message;
	}

	public JBugsException(String message, Exception e) {
		super(e);
		this.errorMessageKey = message;
	}

	@Override
	public String getMessage() {
		return errorMessageKey;
	}

}
