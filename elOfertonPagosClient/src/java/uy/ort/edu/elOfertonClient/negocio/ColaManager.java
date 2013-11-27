/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.elOfertonClient.negocio;

import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author 151770
 */
@Named
@ApplicationScoped
public class ColaManager {
    @Resource(lookup ="jms/colaPagosFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "colaPagos")
    private Queue queue;
    
    public void sendMessage(String listaOfertas){
        try (JMSContext context = connectionFactory.createContext();) {

            context.createProducer().send((Destination) queue, listaOfertas);
       }
    }
    
 
 
}
