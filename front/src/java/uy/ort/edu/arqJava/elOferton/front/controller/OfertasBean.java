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
import uy.edu.ort.arqJava.elOferton.businessEntities.ListaOfertas;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;
import uy.ort.edu.arqJava.elOferton.front.webserviceclient.OfertasServiceClient;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "ofertas")
@RequestScoped
public class OfertasBean {

    @EJB
    private IBusinessLogicFacade _bl;
    
    private List<Oferta> listaOfertas;
    
    public OfertasBean() {
        listaOfertas = new ArrayList<Oferta>();
    }

    public List<Oferta> getOfertasDia() {
        OfertasServiceClient cliente = new OfertasServiceClient();
        ListaOfertas listaO = null;
        try {
            listaO = cliente.getJson(ListaOfertas.class);
            
        } catch (Exception ex) {
           // throw new ComunicacionException(ex, "Ocurrio un error al intentar comunicarse con el servicio.");
        } finally {
           // cliente.close();
        };
        return listaO.getOfertas();
    }
}
