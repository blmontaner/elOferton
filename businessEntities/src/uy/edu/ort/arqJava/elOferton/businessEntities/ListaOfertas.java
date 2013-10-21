/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruno
 */
@XmlRootElement
public class ListaOfertas {
    
    private List<Oferta> ofertas;

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    
}
