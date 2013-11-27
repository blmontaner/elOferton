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
import javax.servlet.http.HttpSession;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.ListaOfertas;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;
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
    //private static List<Oferta> listaOfertas;
    private final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(getClass());
    private List<Oferta> ofertas;

    public OfertasBean() {
        //listaOfertas = new ArrayList<>();
    }

    public List<Oferta> getOfertas() {
        if (ofertas != null) {
            return ofertas;
        } else {
            ofertas = getOfertasDia();
        }

        return ofertas;
    }

    public List<Oferta> getOfertasDia() {
        //if (listaOfertas == null) {

        ListaOfertas listaO = null;
        List<Oferta> listaOfertas = new ArrayList<Oferta>();

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
        //}
        return listaOfertas;
    }

    public boolean getOfertaComprada(String idOferta) {
        HttpSession session = Utils.getSession(true);
        if (session.getAttribute("usuario") != null) {
            Usuario u = (Usuario) session.getAttribute("usuario");
            return u.isOfertaComprada(Long.parseLong(idOferta));
        }
        return false;
    }

    public String getIdCompraPorOfertaDeSesion(String idOferta) {
        HttpSession session = Utils.getSession(true);
        if (session.getAttribute("usuario") != null) {
            Usuario u = (Usuario) session.getAttribute("usuario");
            return u.getIdCompraOfertaComprada(Long.parseLong(idOferta)) + "";
        }
        return "";
    }
}
