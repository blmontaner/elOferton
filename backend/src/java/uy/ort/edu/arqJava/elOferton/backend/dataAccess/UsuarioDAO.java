/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Bruno
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO {
    
    public UsuarioDAO() {
    }
    
    @Override
    public void save(Usuario entity) throws DatosException {
        List<Usuario> listaUsuarios = Repositorio.getInscatnce().getUsuarios();
        
        boolean update = listaUsuarios.contains(entity);
        
        long nuevoId = Long.MIN_VALUE;
        
        if (update) {
            listaUsuarios.remove(entity);
        } else {
            for (Usuario u : listaUsuarios) {
                if (u.getId() > nuevoId) {
                    nuevoId = u.getId();
                }
            }
            
            nuevoId = nuevoId + 1;
            entity.setId(nuevoId);
        }
        
        listaUsuarios.add(entity);
    }
    
    @Override
    public void delete(Usuario entity) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario getByPK(Object id) throws DatosException {
        List<Usuario> listaUsuarios = Repositorio.getInscatnce().getUsuarios();
        
        Iterator<Usuario> iter = listaUsuarios.iterator();
        
        while (iter.hasNext()) {
            Usuario u = iter.next();
            if (u.getId() == id) {
                return u;
            }
        }
        
        throw new DatosException("El usuario con id especificado no existe.");
    }
    
    @Override
    public List<Usuario> getAll() throws DatosException {
        List<Usuario> listaUsuarios = Repositorio.getInscatnce().getUsuarios();
        
        return listaUsuarios;
    }
    
    @Override
    public List<Usuario> getByProperty(String prop, Object val) throws DatosException {
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        if (prop.trim().toUpperCase().equals("NOMBREUSUARIO")) {
            
            Iterator<Usuario> iter = Repositorio.getInscatnce().getUsuarios().iterator();
            
            while (iter.hasNext()) {
                Usuario u = iter.next();
                if (u.getNombreUsuario().trim().equals((String) val)) {
                    listaUsuarios.add(u);
                }
            }
            
        } else {
            throw new NotImplementedException();
        }
        
        return listaUsuarios;
    }
}
