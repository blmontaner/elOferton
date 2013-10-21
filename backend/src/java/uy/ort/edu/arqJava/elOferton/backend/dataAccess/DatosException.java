/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

/**
 *
 * @author Bruno
 */
public class DatosException extends Exception {

    private String localizedMessage;

    public DatosException() {
    }

    public DatosException(String message) {
        super(message);
        localizedMessage = message;
    }

    public DatosException(Exception ex) {
        super(ex);
    }

    public DatosException(Exception ex, String message) {
        super(message);
        localizedMessage = message;
    }

    @Override
    public String getLocalizedMessage() {
        return localizedMessage;
    }
}
