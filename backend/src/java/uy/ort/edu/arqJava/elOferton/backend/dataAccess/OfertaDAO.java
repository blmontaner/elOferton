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
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Bruno
 */
@Stateless
public class OfertaDAO implements IOfertaDAO {

    @PersistenceContext
    EntityManager em;

    public OfertaDAO() {
    }

    @Override
    public void save(Oferta entity) throws DatosException {
        /*Repositorio.getInscatnce().getOfertas().add(entity);

         if (!Repositorio.getInscatnce().getEmpresas().contains(entity.getEmpresa())) {
         Repositorio.getInscatnce().getEmpresas().add(entity.getEmpresa());
         }*/

        Oferta oferta = em.merge(entity);
        em.flush();
        entity.setId(oferta.getId());

    }

    @Override
    public void delete(Oferta entity) throws DatosException {
        throw new NotImplementedException();
    }

    @Override
    public Oferta getByPK(Object id) throws DatosException {
        /*Oferta ret = new Oferta();
         for (Oferta o : Repositorio.getInscatnce().getOfertas()) {
         if (o.getId() == id) {
         return o;
         }
         }
         return ret;*/

        Oferta oferta = em.find(Oferta.class, id);

        if (oferta == null) {
            throw new DatosException("La oferta con id especificado no existe.");
        }

        return oferta;
    }

    @Override
    public List<Oferta> getAll() throws DatosException {
         List<Oferta> listaOfertas = new ArrayList<Oferta>();

        listaOfertas = em.createQuery(
                "SELECT o FROM Oferta o", Oferta.class).getResultList();

        return listaOfertas;
    }

    @Override
    public List<Oferta> getByProperty(String prop, Object val) throws DatosException {
        throw new NotImplementedException();
    }
}
