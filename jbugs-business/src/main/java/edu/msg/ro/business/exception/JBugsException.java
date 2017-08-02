package edu.msg.ro.business.exception;

public class JBugsException extends Exception {

	private static final long serialVersionUID = 67783889987374141L;

	private String errorMessageKey;

	public JBugsException(String message) {
		this.errorMessageKey = message;
	}

	public JBugsException(String message, Exception e) {
		this.errorMessageKey = message;
	}

	public String getMessageKey() {
		return this.errorMessageKey;
	}
}
