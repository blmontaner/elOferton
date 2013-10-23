/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import uy.ort.edu.arqJava.elOferton.backend.mail.MailHandler;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "mail")
@RequestScoped
public class MailBean implements Serializable {

    private String mailTo;
    private final Logger _logger = Logger.getLogger(getClass());

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void sendEmail() {
        String usuario = Utils.getSession(false) != null ? Utils.getNombreUsuarioLogueado() : "[no autenticado]";
        _logger.info("El usuario " + usuario + " ha enviado un email de recomendacion con destino a " + mailTo);

        try {
            MailHandler.sendEmail(mailTo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail Enviado"));
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al intentar enviar un email de recomendación.\n[EXCEPTION] " + ex.getStackTrace());
        }
    }
}
