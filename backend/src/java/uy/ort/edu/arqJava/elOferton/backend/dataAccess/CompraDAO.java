/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class CompraDAO implements ICompraDAO {

    public CompraDAO() {
    }
    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Compra entity) throws DatosException {
        em.persist(entity);
    }

    @Override
    public void delete(Compra entity) throws DatosException {
        throw new NotImplementedException();
    }

    @Override
    public Compra getByPK(Object id) throws DatosException {
        throw new NotImplementedException();
    }

    @Override
    public List<Compra> getAll() throws DatosException {
        List<Compra> listaCompras = new ArrayList<Compra>();

        listaCompras = em.createQuery(
                "SELECT c FROM Compra c", Compra.class).getResultList();

        return listaCompras;
    }

    @Override
    public List<Compra> getByProperty(String prop, Object val) throws DatosException {
        List<Compra> compras = new ArrayList<Compra>();
        
        if (prop.trim().toUpperCase().equals("IDUSUARIO")) {
            Usuario usuario = em.find(Usuario.class, val);
            compras = usuario.getCompras();
        } else {
            throw new NotImplementedException();
        }

        return compras;
    }
}
