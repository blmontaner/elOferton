/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "compras")
@RequestScoped
public class ComprasBean {

    @EJB
    private IBusinessLogicFacade _bl;
    
    private List<Compra> listaCompras;
    
    public ComprasBean() {
        listaCompras = new ArrayList<>();
    }
    
    public void realizarCompra(long idOferta, String nombreOferta,double precio,long idEmpresa){
        try {
            long idUsuario = Long.parseLong(Utils.getIdUsuarioLogueado());
            _bl.registrarCompra(idUsuario, idOferta, nombreOferta,precio,idEmpresa);
        } catch (NegocioException ex) {
            Logger.getLogger(OfertasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Compra> getListaCompras(){
        listaCompras = new ArrayList<>();
        try {
            long idUsuario = Long.parseLong(Utils.getIdUsuarioLogueado());
            listaCompras = _bl.obtenerComprasPorUsuario(idUsuario);
        } catch (NegocioException ex) {
            Logger.getLogger(OfertasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompras;
    }
    
}
