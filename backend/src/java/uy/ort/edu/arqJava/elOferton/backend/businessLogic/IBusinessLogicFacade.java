/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.businessLogic;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Rodrigo
 */
@Local
public interface IBusinessLogicFacade {

    long registrarUsuario(Usuario usuario) throws NegocioException;

    Usuario validarLogin(String nombreUsuario, String contrasenia) throws NegocioException;

    Usuario obtenerUsuario(long idUsuario) throws NegocioException;

    void enviarEmailRecomendacion(String emailDestinatario, String nombreDestinatario) throws NegocioException;

    void actualizarDatosUsuario(Usuario usuario) throws NegocioException;

    void registrarCompra(long idUsuario, long idOferta, String nombreOferta,double precio, long idEmpresa) throws NegocioException;

    List<Compra> obtenerComprasPorUsuario(long idUsuario) throws NegocioException;
    
    //List<Oferta> obtenerOfertasDelDia() throws NegocioException;
}
