/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "login")
@RequestScoped
public class LoginBean implements Serializable {

    private String contrasenia;
    private String nombreUsuario;
    @EJB
    private IBusinessLogicFacade _bl;

    public LoginBean() {
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void login() {

        Usuario usuario = null;
        boolean loginValido = false;

        //Pasar esto a .properties
        String urlRedireccion = "http://localhost" + ":" + Utils.getRequest().getLocalPort() + Utils.getRequest().getContextPath();

        try {
            usuario = _bl.validarLogin(nombreUsuario, contrasenia);
            loginValido = true;

            HttpSession session = Utils.getSession(true);
            session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
            session.setAttribute("idUsuario", usuario.getId());

            RequestContext.getCurrentInstance().addCallbackParam("loginValido", loginValido);
            RequestContext.getCurrentInstance().addCallbackParam("urlRedireccion", urlRedireccion);
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getLocalizedMessage(),
                    null));
        }
    }

    public String logout() {
        HttpSession session = Utils.getSession(false);
        session.setAttribute("nombreUsuario", null);
        session.setAttribute("idUsuario", null);
        session.invalidate();
        return "/index.xhtml?facesRedirect=true";
    }
}
