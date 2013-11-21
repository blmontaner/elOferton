/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.List;
import java.util.UUID;
import javax.ejb.Local;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;

/**
 *
 * @author Rodrigo
 */
@Local
public interface ICompraDAO extends IDAO<Compra> {
    
     public void marcarComprasComoPagas(List<UUID> identificadores) throws DatosException;
    
}
