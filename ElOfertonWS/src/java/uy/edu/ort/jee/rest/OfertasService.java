/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.jee.rest;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import uy.edu.ort.arqJava.elOferton.businessEntities.ListaOfertas;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.jee.constantes.Constantes;

/**
 * REST Web Service
 *
 * @author Bruno
 */
@Path("ofertas")
@RequestScoped
public class OfertasService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OfertasService
     */
    public OfertasService() {
    }

    /**
     * Retrieves representation of an instance of ort.jee.rest.OfertasService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public ListaOfertas getJson() {
        ListaOfertas ret = new ListaOfertas();
        ret.setOfertas(Constantes.getOfertas());
        return ret;
    }

    /**
     * PUT method for updating or creating an instance of OfertasService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
