/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import uy.edu.ort.arqJava.elOferton.businessEntities.ListaOfertas;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.webserviceclient.OfertasServiceClient;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "ofertas")
@SessionScoped
public class OfertasBean {

    @EJB
    IBusinessLogicFacade _bl;
    private static List<Oferta> listaOfertas;
    private final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(getClass());

    public OfertasBean() {
        listaOfertas = new ArrayList<>();
    }

    public List<Oferta> getOfertasDia() {
        if (listaOfertas == null || listaOfertas.size() == 0) {

            ListaOfertas listaO = null;

            //listaOfertas = new ArrayList<Oferta>();
            
            try {
                if (_bl.consultaOfertas()) {
                    OfertasServiceClient cliente = new OfertasServiceClient();

                    try {
                        _logger.info("Se obtienen las ofertas del día del servicio externo");
                        listaO = cliente.getJson(ListaOfertas.class);
                        _bl.agregarOfertas(listaO.getOfertas());
                    } catch (Exception ex) {
                        _logger.error("Ocurrió un error al intentar obtener la lista de ofertas.\n[EXCEPTION] " + ex.getStackTrace());

                        listaO = new ListaOfertas();
                        listaO.setOfertas(new ArrayList<Oferta>());
                        FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Ocurrió un error al obtener las ofertas del día. Por favor visitenos mas tarde.",
                                null));
                    } finally {
                        cliente.close();
                    };
                }
                
                listaOfertas = _bl.obtenerOfertasVigentes();
            } catch (NegocioException ex) {
                _logger.error("Ocurrió un error al intentar obtener la lista de ofertas.\n[EXCEPTION] " + ex.getStackTrace());
            }
        }
        return listaOfertas;
    }
}
