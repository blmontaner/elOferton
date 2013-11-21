/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.elOfertonClient.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import uy.ort.edu.elOfertonClient.negocio.ColaManager;

/**
 *
 * @author 151770
 */
@Named(value = "pagos")
@RequestScoped
public class PagosBean {

    private String pagosString;

    @Inject
    private ColaManager colaManager;
    
    public String getPagosString() {
        return pagosString;
    }

    public void setPagosString(String pagosString) {
        this.pagosString = pagosString;
    }
    /**
     * Creates a new instance of PagosBean
     */
    public PagosBean() {
    }
    
    public void enviarPagos(){
        colaManager.sendMessage(pagosString);
    }
    
}
