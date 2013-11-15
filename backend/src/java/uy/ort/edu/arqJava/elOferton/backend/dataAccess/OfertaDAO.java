/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Parametro;
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
    
    @Override
    public boolean consultaOfertas() {
        boolean consulta = false;
        
        Date fechaActual = new Date();
        
        Parametro parametro = em.find(Parametro.class, "FECHA_ULTIMA_CONSULTA_OFERTAS");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Date fechaUltimaConsulta = null;
        
        try {            
            fechaUltimaConsulta = df.parse(parametro.getValor());
        } catch (ParseException ex) {
            Logger.getLogger(OfertaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Calendar cFechaActual = Calendar.getInstance();
        cFechaActual.set(fechaActual.getYear(), fechaActual.getMonth(), fechaActual.getDay(), 0, 0, 0);
        
        Calendar cFechaUltimaConsulta = Calendar.getInstance();
        cFechaUltimaConsulta.set(fechaUltimaConsulta.getYear(), fechaUltimaConsulta.getMonth(), fechaUltimaConsulta.getDay(), 0, 0, 0);
        
        if (cFechaUltimaConsulta.compareTo(cFechaActual) < 0) {
            consulta = true;
            parametro.setValor(fechaActual.toString());
        }
        
        return consulta;
    }
    
    @Override
    public List<Oferta> obtenerOfertasVigentes() {
 
        List<Oferta> listaOfertas = new ArrayList<Oferta>();

        listaOfertas = em.createQuery(
                "SELECT o FROM Oferta o WHERE :pFechaActual >= fechaInicio and :pFechaActual <= fechaFin", Oferta.class)
                .setParameter(":pFechaActual", new Date())
                .getResultList();

        return listaOfertas;
    }
    
    @Override
    public void agregarOfertas(List<Oferta> ofertas) {
        for (Oferta o : ofertas) {
            if (em.find(Oferta.class, o.getId()) == null) {
                em.persist(o);
            }
        }
    }
}
