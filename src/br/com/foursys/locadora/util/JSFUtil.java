package br.com.foursys.locadora.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	public static void addInfoMessage(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(msg, facesMessage);
	}
}
