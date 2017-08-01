package edu.msg.ro.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * 
 * @author petred
 *
 */
@ManagedBean
@RequestScoped
public class LocaleBean {

	private static String locale = "en";

	public void setLocale(String locale1) {
		LocaleBean.locale = locale1;
	}

	public synchronized String getLocale() {
		return locale;
	}

	public synchronized String changeLanguage() {
		if (!locale.contains("ro")) {
			setLocale("ro");
		} else {
			setLocale("en");
		}
		return "login";
	}

}
