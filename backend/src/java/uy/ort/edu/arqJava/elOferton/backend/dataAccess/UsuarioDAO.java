/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Bruno
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO {

    @PersistenceContext
    EntityManager em;

    public UsuarioDAO() {
    }

    @Override
    public void save(Usuario entity) throws DatosException {
        Usuario usuario = em.merge(entity);
        em.flush();
        entity.setId(usuario.getId());
    }

    @Override
    public void delete(Usuario entity) throws DatosException {
        throw new NotImplementedException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getByPK(Object id) throws DatosException {

        Usuario usuario = em.find(Usuario.class, id);

        if (usuario == null) {
            throw new DatosException("El usuario con id especificado no existe.");
        }

        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws DatosException {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        listaUsuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

        return listaUsuarios;

    }

    @Override
    public List<Usuario> getByProperty(String prop, Object val) throws DatosException {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        if (prop.trim().toUpperCase().equals("NOMBREUSUARIO")) {

            listaUsuarios = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nombreUsuario = :pNombreUsuario", Usuario.class)
                    .setParameter("pNombreUsuario", val)
                    .getResultList();

        } else {
            throw new NotImplementedException();
        }

        return listaUsuarios;
    }

    @Override
    public Usuario validarLogin(String nombreUsuario, String contrasenia) throws DatosException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        usuarios = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nombreUsuario = :pNombreUsuario AND u.contrasenia = :pContrasenia", Usuario.class)
                .setParameter("pNombreUsuario", nombreUsuario)
                .setParameter("pContrasenia", contrasenia)
                .getResultList();

        if (usuarios.size() == 1) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }
}
