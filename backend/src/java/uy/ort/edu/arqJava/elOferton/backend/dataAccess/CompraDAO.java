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
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class CompraDAO implements ICompraDAO {

    public CompraDAO() {
    }

    @Override
    public void save(Compra entity) throws DatosException {
        if(entity.getId() == 0){
            entity.setId(Repositorio.getDBId());
        }
        Repositorio.getInscatnce().getCompras().add(entity);
    }

    @Override
    public void delete(Compra entity) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra getByPK(Object id) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compra> getAll() throws DatosException {
        return Repositorio.getInscatnce().getCompras();
    }

    @Override
    public List<Compra> getByProperty(String prop, Object val) throws DatosException {
        List<Compra> listaCompras = new ArrayList<Compra>();

        if (prop.trim().toUpperCase().equals("IDUSUARIO")) {

            Iterator<Compra> iter = Repositorio.getInscatnce().getCompras().iterator();

            while (iter.hasNext()) {
                Compra c = iter.next();
                if (c.getUsuario().getId() == (long) val) {
                    listaCompras.add(c);
                }
            }

        } else {
            throw new NotImplementedException();
        }

        return listaCompras;
    }
}
