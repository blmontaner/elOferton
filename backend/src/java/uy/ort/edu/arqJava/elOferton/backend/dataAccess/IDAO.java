/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bruno
 */

public interface IDAO<T> {

    /**
     *
     * @param entity
     * @throws DatosException
     */
    void save(T entity) throws DatosException;

    /**
     *
     * @param entity
     * @throws DatosException
     */
    void delete(T entity) throws DatosException;

    /**
     *
     * @param id
     * @return
     * @throws DatosException
     */
    T getByPK(Object id) throws DatosException;

    /**
     *
     * @return @throws DatosException
     */
    List<T> getAll() throws DatosException;

    /**
     *
     * @param prop
     * @param val
     * @return
     * @throws DatosException
     */
    List<T> getByProperty(String prop, Object val) throws DatosException;
}
