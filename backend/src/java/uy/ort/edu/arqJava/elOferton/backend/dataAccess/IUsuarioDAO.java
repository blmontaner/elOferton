/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import javax.ejb.Local;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Bruno
 */
@Local
public interface IUsuarioDAO extends IDAO<Usuario> {

    Usuario validarLogin(String nombreUsuario, String contrasenia) throws DatosException;
}
