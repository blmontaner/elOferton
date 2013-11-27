/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.DatosException;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.ICompraDAO;

/**
 *
 * @author Rodrigo
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName =
            "destinationLookup",
            propertyValue = "colaPagos"),
    @ActivationConfigProperty(propertyName =
            "destinationType",
            propertyValue = "javax.jms.Queue")})
public class ListenerPagos implements MessageListener {
    
    @EJB
    private ICompraDAO _daoCompras;
    
    public ListenerPagos() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        List<UUID> identificadores = new ArrayList<UUID>();
        
        if (message instanceof TextMessage) {
            String xml = null;
            
            try {
                xml = message.getBody(String.class);
                
                String[] identificadoresAux = xml.split(";");
                
                for (String i : identificadoresAux) {
                    identificadores.add(UUID.fromString(i));
                }
                
            } catch (JMSException ex) {
                //Loggear
                System.out.println("Error al intentar obtener un mensaje de la cola.");
            }
            
            System.out.println(xml);
        } else {
            //Loggear
            System.out.println("El tipo del mensaje recibido es incorrecto.");
        }
        
        try {
            _daoCompras.marcarComprasComoPagas(identificadores);
        } catch (DatosException ex) {
            //Loggear
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
