/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.List;
import javax.ejb.Stateless;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;

/**
 *
 * @author Bruno
 */
@Stateless
public class OfertaDAO implements IOfertaDAO {

    public OfertaDAO() {
    }

    @Override
    public void save(Oferta entity) throws DatosException {
        Repositorio.getInscatnce().getOfertas().add(entity);

        if (!Repositorio.getInscatnce().getEmpresas().contains(entity.getEmpresa())) {
            Repositorio.getInscatnce().getEmpresas().add(entity.getEmpresa());
        }
    }

    @Override
    public void delete(Oferta entity) throws DatosException {
        Repositorio.getInscatnce().getOfertas().remove(entity);
    }

    @Override
    public Oferta getByPK(Object id) throws DatosException {
        Oferta ret = new Oferta();
        for (Oferta o : Repositorio.getInscatnce().getOfertas()) {
            if (o.getId() == id) {
                return o;
            }
        }
        return ret;
    }

    @Override
    public List<Oferta> getAll() throws DatosException {
        return Repositorio.getInscatnce().getOfertas();
    }

    @Override
    public List<Oferta> getByProperty(String prop, Object val) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
