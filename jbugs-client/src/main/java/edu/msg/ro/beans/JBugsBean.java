package edu.msg.ro.beans;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.JBugsException;
import edu.msg.ro.business.exception.JBugsTechnicalException;

public class JBugsBean {

	public void handleException(JBugsException e) {
		ResourceBundle rb = ResourceBundle.getBundle("jbugs/messages");
		if (e instanceof JBugsTechnicalException) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString(e.getMessageKey()), null));
		}
		if (e instanceof JBugsBusinessException) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, rb.getString(e.getMessageKey()), null));
		}
	}

	public void handleMessage(String messageKey) {
		ResourceBundle rb = ResourceBundle.getBundle("jbugs/messages");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(rb.getString(messageKey)));
	}

}
