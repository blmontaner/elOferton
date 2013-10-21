///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package uy.ort.edu.arqJava.elOferton.backend.serviceAgent;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.GenericType;
//import com.sun.jersey.api.client.UniformInterfaceException;
//import com.sun.jersey.api.client.WebResource;
//
///**
// *
// * @author Rodrigo
// */
//public class OfertasServiceClient {
//
//    private WebResource webResource;
//    private Client client;
//    private static final String BASE_URI = "http://localhost:8080/ElOfertonWS/webresources";
//
//    public OfertasServiceClient() {
//        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
//        client = Client.create(config);
//        webResource = client.resource(BASE_URI).path("ofertas");
//    }
//
//    public <T> T getJson(GenericType<T> responseType) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void close() {
//        if (client != null) {
//            client.destroy();
//        }
//    }
//}
