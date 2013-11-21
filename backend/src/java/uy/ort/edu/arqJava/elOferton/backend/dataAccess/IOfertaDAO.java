/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.List;
import java.util.UUID;
import javax.ejb.Local;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;

/**
 *
 * @author Bruno
 */
@Local
public interface IOfertaDAO extends IDAO<Oferta> {
    
    boolean consultaOfertas() throws DatosException;
    
    List<Oferta> obtenerOfertasVigentes() throws DatosException;
    
    void agregarOfertas(List<Oferta> ofertas) throws DatosException;
    
}
