/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.IBusinessLogicFacade;
import uy.ort.edu.arqJava.elOferton.backend.businessLogic.NegocioException;
import uy.ort.edu.arqJava.elOferton.front.utils.Configuracion;
import uy.ort.edu.arqJava.elOferton.front.utils.Utils;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "usuarios")
@RequestScoped
public class UsuariosBean {

    @EJB
    private IBusinessLogicFacade _bl;
    private String nombreUsuario;
    private String contrasenia;
    private String confContrasenia;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
    private final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(getClass());

    public UsuariosBean() {
    }

    public String getConfContrasenia() {
        return confContrasenia;
    }

    public void setConfContrasenia(String confContrasenia) {
        this.confContrasenia = confContrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String obtenerMisDatos() {
        _logger.info("El usuario " + Utils.getNombreUsuarioLogueado() + " ingresa a la sección Mis Datos.");
        try {
            Usuario u = _bl.obtenerUsuario(Long.parseLong(Utils.getIdUsuarioLogueado()));

            this.apellido = u.getApellido();
            this.contrasenia = u.getContrasenia();
            this.confContrasenia = u.getContrasenia();
            this.direccion = u.getDireccion();
            this.nombre = u.getNombre();
            this.email = u.getEmail();
            this.telefono = u.getTelefono();

            return "/Private/misDatos.xhtml";
        } catch (NegocioException ex) {
            _logger.error("Ocurrió un error al intentar obtener los datos de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al intentar obtener los datos de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        }
        return null;
    }

    public void actualizarMisDatos() {

        _logger.info("El usuario " + Utils.getNombreUsuarioLogueado() + " actualiza sus datos.");

        Usuario u = new Usuario(Long.parseLong(Utils.getIdUsuarioLogueado()),
                Utils.getNombreUsuarioLogueado(), contrasenia, nombre,
                email, direccion, apellido, telefono);

        try {
            _bl.actualizarDatosUsuario(u);

            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Los datos se han actualizado correctamente!",
                    null));
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getLocalizedMessage(),
                    null));
            _logger.error("Ocurrió un error al intentar actualizar los datos de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al intentar actualizar los datos de un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        }
    }

    public void registrarUsuario() {

        _logger.info("Se intenta registrar el usuario " + this.nombreUsuario);

        boolean registroExitoso = false;

        //Sacar esto de .properties
        String urlRedireccion = Configuracion.getInstancia().getPropiedad("urlRedireccionRegUsuarioExitoso");

        Usuario u = new Usuario(nombreUsuario, contrasenia, nombre,
                email, direccion, apellido, telefono);

        try {
            long id = _bl.registrarUsuario(u);

            registroExitoso = true;

            HttpSession session = Utils.getSession(true);
            session.setAttribute("nombreUsuario", u.getNombreUsuario());
            session.setAttribute("idUsuario", id);

            /*Cargo estos parametros para poder saber del lado del cliente si el registro fue exitoso
             * si lo fue hago una redirección al index con en el usuario logueado */

            RequestContext.getCurrentInstance().addCallbackParam("registroExitoso", registroExitoso);
            RequestContext.getCurrentInstance().addCallbackParam("urlRedireccion", urlRedireccion);
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getLocalizedMessage(),
                    null));
            _logger.error("Ocurrió un error al intentar registrar un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        } catch (Exception ex) {
            _logger.error("Ocurrió un error al intentar registrar un usuario.\n[EXCEPTION] " + ex.getStackTrace());
        }
    }
}
