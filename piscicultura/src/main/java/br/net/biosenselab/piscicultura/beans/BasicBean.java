package br.net.biosenselab.piscicultura.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Francisco Adriano da Silva
 */
public abstract class BasicBean {

    public void showException(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("exceptions", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado", e.toString()));
        System.out.println(e.toString());
    }

}
