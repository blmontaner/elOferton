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
import javax.persistence.TemporalType;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Parametro;

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

    @Override
    public boolean consultaOfertas() throws DatosException {
        boolean consulta = false;

        LocalDate today = LocalDate.now();

        DateTime fechaActual = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0);

        Parametro parametro = em.find(Parametro.class, "FECHA_ULTIMA_CONSULTA_OFERTAS");

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime fechaUltimaConsulta = formatter.parseDateTime(parametro.getValor());

        if (fechaUltimaConsulta.isBefore(fechaActual)) {
            consulta = true;
            parametro.setValor(fechaActual.getDayOfMonth() + "/" + fechaActual.getMonthOfYear() + "/" + fechaActual.getYear());
        }

        return consulta;
    }

    @Override
    public List<Oferta> obtenerOfertasVigentes() throws DatosException {

        List<Oferta> listaOfertas = new ArrayList<Oferta>();

        LocalDate today = LocalDate.now();

        DateTime fechaActual = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0);

        listaOfertas = em.createQuery(
                "SELECT o FROM Oferta o WHERE :pFechaActual between o.fechaInicio AND o.fechaFin", Oferta.class)
                .setParameter("pFechaActual", fechaActual.toDate(), TemporalType.DATE)
                .getResultList();

        return listaOfertas;
    }

    @Override
    public void agregarOfertas(List<Oferta> ofertas) throws DatosException {
        for (Oferta o : ofertas) {
            if (em.find(Oferta.class, o.getId()) == null) {
                em.persist(o);
            }
        }
    }
}
