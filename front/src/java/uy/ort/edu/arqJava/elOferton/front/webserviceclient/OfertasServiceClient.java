/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.webserviceclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import uy.ort.edu.arqJava.elOferton.front.utils.Configuracion;

/**
 * Jersey REST client generated for REST resource:OfertasService [ofertas]<br>
 * USAGE:
 * <pre>
 *        OfertasServiceClient client = new OfertasServiceClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Bruno
 */
public class OfertasServiceClient {
    
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = Configuracion.getInstancia().getPropiedad("urlOfertasService");
    private final Logger _logger = Logger.getLogger(getClass());
    
    public OfertasServiceClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("ofertas");
    }
    
    public void putJson(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }
    
    public <T> T getJson(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
       
    public void close() {
        if (client != null) {
            try {
                client.destroy();
            } catch (Exception ex) {
                _logger.error("Ocurrió un error al intentar cerrar la conexión con el servicio de ofertas.");
            }
        }
    }
}
