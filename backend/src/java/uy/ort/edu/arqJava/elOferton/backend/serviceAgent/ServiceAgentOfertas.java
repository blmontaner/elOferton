///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package uy.ort.edu.arqJava.elOferton.backend.serviceAgent;
//
//import com.sun.jersey.api.client.GenericType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.Stateless;
//import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
//
///**
// *
// * @author Rodrigo
// */
//@Stateless
//public class ServiceAgentOfertas implements IServiceAgentOfertas {
//
//    @Override
//    public List<Oferta> ObtenerOfertasDelDia() throws ComunicacionException {
//
//        OfertasServiceClient cliente = new OfertasServiceClient();
//
//        List<Oferta> listaOfertas = null;
// 
//        try {
//            listaOfertas = cliente.getJson(new GenericType<ArrayList<Oferta>>(new ArrayList<Oferta>().getClass()));
//        } catch (Exception ex) {
//            throw new ComunicacionException(ex, "Ocurrio un error al intentar comunicarse con el servicio.");
//        } finally {
//            cliente.close();
//        }
//
//        return listaOfertas;
//
//    }
//}
