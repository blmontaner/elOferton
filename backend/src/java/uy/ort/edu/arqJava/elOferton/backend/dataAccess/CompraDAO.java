/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class CompraDAO implements ICompraDAO {

    @PersistenceContext
    EntityManager em;

    public CompraDAO() {
    }

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
         Compra ret = em.find(Compra.class, id);

        if (ret == null) {
            throw new DatosException("La Compra con id especificado no existe.");
        }

        return ret;
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

        if (prop.trim().toUpperCase().equals("IDUSUARIO")) {

            Query q = em.createQuery("SELECT c"
                    + "       FROM Compra c"
                    + "      WHERE c.usuario.id = :usuarioID");

            q.setParameter("usuarioID", val);

            return q.getResultList();
        } else {
            throw new NotImplementedException();
        }
    }

    @Override
    public void marcarComprasComoPagas(List<UUID> identificadores) throws DatosException {

        for (UUID i : identificadores) {

            Compra compra = em.createQuery(
                    "SELECT c FROM Compra c WHERE c.identificador = :pIdentificador", Compra.class)
                    .setParameter("pIdentificador", i).getSingleResult();

            compra.setPaga(true);
        }

    }
}
