package edu.msg.ro.business.exception;

public class JBugsException extends Exception {

	private static final long serialVersionUID = 67783889987374141L;

	private String errorMessage;

	public JBugsException(String message) {
		this.errorMessage = message;
	}

	public JBugsException(String message, Exception e) {
		this.errorMessage = message;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

}
