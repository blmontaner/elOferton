/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;
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
    private final Logger _logger = Logger.getLogger(getClass());

    public ComprasBean() {
        listaCompras = new ArrayList<>();
    }

    public void realizarCompra(Oferta oferta) {
        _logger.info("El usuario " + Utils.getNombreUsuarioLogueado() + " realizó una compra de la oferta " + oferta.getNombre());
        try {
            long idUsuario = Long.parseLong(Utils.getIdUsuarioLogueado());
            _bl.registrarCompra(idUsuario, oferta.getId());
        } catch (NegocioException ex) {
            _logger.error("Ocurrió un error al realizar una compra.\n[EXCEPTION] " + ex.getStackTrace());
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al realizar una compra.\n[EXCEPTION] " + ex.getStackTrace());
        }
    }
    
    public List<Compra> getListaCompras() {
        _logger.info("Se obtiene la lista de compras del usuario " + Utils.getNombreUsuarioLogueado());
        listaCompras = new ArrayList<>();
        try {
            long idUsuario = Long.parseLong(Utils.getIdUsuarioLogueado());
            listaCompras = _bl.obtenerComprasPorUsuario(idUsuario);
            _logger.info("COMPRAS: "+ listaCompras.size());
        } catch (NegocioException ex) {
            _logger.error("Ocurrió un error al intentar obtener la lista de compras de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al intentar obtener la lista de compras de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        }
        return listaCompras;
    }
}
