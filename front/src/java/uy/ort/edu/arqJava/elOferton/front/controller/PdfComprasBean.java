/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.ICompraDAO;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "pdfCompras")
@RequestScoped
public class PdfComprasBean {

    @ManagedProperty(value = "#{param.compraId}")
    private String compraId;
    @EJB
    private ICompraDAO _compraDAO;
    
    
    private Compra compra;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * Creates a new instance of PdfComprasBean
     */
    public PdfComprasBean() {
    }

    public String getCompraId() {
        return compraId;
    }

    public void setCompraId(String val) {
        this.compraId = val;
    }

    @PostConstruct
    public void init() {
         
        try {
            if(compraId != null && !compraId.equals("")){
                this.compra = _compraDAO.getByPK(Long.valueOf(compraId));
            }            
        } catch (Exception ex) {
            Logger.getLogger(PdfComprasBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage( null, new FacesMessage( ex.getMessage()));
        }
    }

}
