/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import uy.ort.edu.arqJava.elOferton.backend.mail.MailHandler;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "mail")
@RequestScoped
public class MailBean implements Serializable {
    
    private String mailTo;

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailTo() {
        return mailTo;
    }    
    
    public void sendEmail(){
        MailHandler.sendEmail(mailTo);
    }
         
}
