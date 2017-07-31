package edu.msg.ro.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.JBugsException;
import edu.msg.ro.business.exception.JBugsTechnicalException;

public class JBugsBean {

	public void handleException(JBugsException e) {
		if (e instanceof JBugsTechnicalException) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		if (e instanceof JBugsBusinessException) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		}
	}

	public void handleMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, null));
	}

}
