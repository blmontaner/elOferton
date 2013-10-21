/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
public class Utils {

    public static HttpSession getSession(boolean create) {
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(create);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    public static String getNombreUsuarioLogueado() {
        HttpSession session = getSession(false);

        if (session != null) {
            Object nombreUsuario = session.getAttribute("nombreUsuario");

            if (nombreUsuario != null) {
                return nombreUsuario.toString();
            } else {
                return null;
            }
        }

        return null;
    }

    public static String getIdUsuarioLogueado() {
        HttpSession session = getSession(false);

        if (session != null) {
            Object nombreUsuario = session.getAttribute("idUsuario");

            if (nombreUsuario != null) {
                return nombreUsuario.toString();
            } else {
                return null;
            }
        }

        return null;
    }
}