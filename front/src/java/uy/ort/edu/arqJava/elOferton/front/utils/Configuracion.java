/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.utils;

import java.util.ResourceBundle;

/**
 *
 * @author Rodrigo
 */
public class Configuracion {

    ResourceBundle properties = null;
    public final static String ARCHIVO_CONFIG = "config";
    private final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(getClass());

    /**
     * constructor sin parámetros
     *
     */
    private Configuracion() {
        try {
            properties = ResourceBundle.getBundle(ARCHIVO_CONFIG);
            _logger.debug("Nombre archivo config: " + ARCHIVO_CONFIG);
        } catch (Exception e) {
            _logger.debug("Ocurrió un error al intentar leer el archivo de configuración de la ruta: " + ARCHIVO_CONFIG);
        }

    }

    /**
     *
     * @return Configuracion
     */
    public static Configuracion getInstancia() {
        return Configuracion.HolderConfiguracion.INSTANCE;
    }

    /**
     *
     */
    private static class HolderConfiguracion {

        private static final Configuracion INSTANCE = new Configuracion();
    }

    /**
     *
     * @param key
     * @return obtengo el string que contiene la clave pasada por parámetro
     */
    public String getPropiedad(String key) {
        return this.properties.getString(key);
    }
}
