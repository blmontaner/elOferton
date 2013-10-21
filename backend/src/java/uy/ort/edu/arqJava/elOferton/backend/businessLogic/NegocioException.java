/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.businessLogic;

/**
 *
 * @author Bruno
 */
public class NegocioException extends Exception {

    private String localizedMessage;

    public NegocioException() {
    }

    public NegocioException(String message) {
        super(message);
        localizedMessage = message;
    }

    public NegocioException(Exception ex) {
        super(ex);
    }

    public NegocioException(Exception ex, String message) {
        super(message);
        localizedMessage = message;
    }

    @Override
    public String getLocalizedMessage() {
        return localizedMessage;
    }
}
