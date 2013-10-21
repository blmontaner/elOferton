package uy.ort.edu.arqJava.elOferton.backend.businessLogic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.utils.InputValidations;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.DatosException;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.ICompraDAO;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.IEmpresaDAO;
import uy.ort.edu.arqJava.elOferton.backend.dataAccess.IUsuarioDAO;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class BusinessLogicFacade implements IBusinessLogicFacade {

    //Logger
    //private final Logger _logger = Logger.getLogger(getClass());
    private static final String MSJ_ERROR_GENERICO = "Ocurrió un error al procesar la solicitud.";
    @EJB
    private IEmpresaDAO _daoEmpresas;
    @EJB
    private IUsuarioDAO _daoUsuarios;
    @EJB
    private ICompraDAO _daoCompras;

    //@EJB
    //private IServiceAgentOfertas _saOfertas;
    //@EJB
    //private IOfertaDAO _daoOfertas;
    @Override
    public long registrarUsuario(Usuario usuario) throws NegocioException {
        // _logger.debug("==> registrarUsuario [" + usuario.toString() + "]");

        try {
            List<Usuario> listaUsuarios = _daoUsuarios.getByProperty("nombreUsuario", usuario.getNombreUsuario());

            //Valido que no exista un usuario con el mismo nombre de usuario registrado en el sistema
            if (listaUsuarios.contains(usuario)) {
                throw new NegocioException("El usuario ingresado ya existe en el sistema.");
            }

            //Lanza excepcion si alguno de los campos de la entidad no cumple con las reglas de negocio
            validarDatosUsuario(usuario);

            _daoUsuarios.save(usuario);

            return usuario.getId();
        } catch (NegocioException ex) {
            throw ex;
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
        //_logger.debug("<== registrarUsuario");
    }

    @Override
    public Usuario validarLogin(String nombreUsuario, String contrasenia) throws NegocioException {
        // _logger.debug("==> validarLogin(" + nombreUsuario + "," + contrasenia + ")");
        try {

            List<Usuario> listaUsuarios = _daoUsuarios.getAll();

            Iterator<Usuario> iter = listaUsuarios.iterator();

            while (iter.hasNext()) {
                Usuario u = iter.next();
                if (u.getNombreUsuario().equals(nombreUsuario.trim()) && u.getContrasenia().equals(contrasenia.trim())) {
                    //         _logger.debug("<== validarLogin");
                    return u;
                }
            }

            throw new NegocioException("El nombre de usuario y/o contraseña ingresados no son válidos.");

        } catch (NegocioException ex) {
            throw ex;
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
    }

    @Override
    public Usuario obtenerUsuario(long idUsuario) throws NegocioException {
        try {
            Usuario usuario = _daoUsuarios.getByPK(idUsuario);

            return usuario;
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
    }

    @Override
    public void enviarEmailRecomendacion(String emailDestinatario, String nombreDestinatario) throws NegocioException {
        throw new NotImplementedException();
    }

    @Override
    public void actualizarDatosUsuario(Usuario usuario) throws NegocioException {
        try {

            //Lanza excepcion si alguno de los campos de la entidad no cumple con las reglas de negocio
            validarDatosUsuario(usuario);

            _daoUsuarios.save(usuario);
        } catch (NegocioException ex) {
            throw ex;
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
    }

    @Override
    public void registrarCompra(long idUsuario, long idOferta) throws NegocioException {

        //Aca deberia verificar que existe el id de la compra ya que viene desde el fron (puede ser manipulado)
        //El id de usuario se guarda en la sesion asi que en principio no habria como cambiarlo

        Compra compra = new Compra(new Date(), idUsuario, idOferta);

        try {
            _daoCompras.save(compra);
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
    }

    @Override
    public List<Compra> obtenerComprasPorUsuario(long idUsuario) throws NegocioException {
        try {
            List<Compra> listaCompras = _daoCompras.getByProperty("idUsuario", idUsuario);

            return listaCompras;
        } catch (DatosException ex) {
            throw new NegocioException(ex, ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new NegocioException(ex, MSJ_ERROR_GENERICO);
        }
    }

    /* @Override
     public List<Oferta> obtenerOfertasDelDia() throws NegocioException {
     try {
     return _saOfertas.ObtenerOfertasDelDia();
     } catch (ComunicacionException ex) {
     throw new NegocioException(ex, "No se pudieron obtener las ofertas.");
     }
     } */
    //Métodos privados auxiliares
    private void validarDatosUsuario(Usuario usuario) throws NegocioException {
        //Valido que el email sea valido
        if (!InputValidations.emailValido(usuario.getEmail())) {
            throw new NegocioException("El formato del email no es válido.");
        }
        //Valido que el nombre de usuario tenga entre 5 y 10 caracteres
        if (usuario.getNombreUsuario().length() < 5 || usuario.getNombreUsuario().length() > 15) {
            throw new NegocioException("El nombre de usuario debe tener entre 5 y 15 caracteres.");
        }
        //Valido que la contraseña tenga entre 5 y 15 caracteres
        if (usuario.getContrasenia().length() < 5 || usuario.getContrasenia().length() > 15) {
            throw new NegocioException("La contrasenia debe tener entre 5 y 15 caracteres.");
        }
    }
}