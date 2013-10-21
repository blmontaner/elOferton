/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.List;
import javax.ejb.Stateless;
import uy.edu.ort.arqJava.elOferton.businessEntities.Empresa;

/**
 *
 * @author Bruno
 */
@Stateless
public class EmpresaDAO implements IEmpresaDAO {

    public EmpresaDAO() {
    }

    @Override
    public void save(Empresa entity) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Empresa entity) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa getByPK(Object id) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empresa> getAll() throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empresa> getByProperty(String prop, Object val) throws DatosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
