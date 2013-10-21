/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class Compra {

    private Date fecha;
    private long id;
    private long idUsuario;
    private long idOferta;

    public Compra(Date fecha, long idUsuario, long idOferta) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idOferta = idOferta;
    }

    public Compra(Date fecha, long idUsuario, long idOferta, long id) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idOferta = idOferta;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(long idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.fecha);
        hash = 79 * hash + (int) (this.idUsuario ^ (this.idUsuario >>> 32));
        hash = 79 * hash + (int) (this.idOferta ^ (this.idOferta >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idOferta != other.idOferta) {
            return false;
        }

        return (other.getIdOferta() == this.getIdOferta()
                && other.getIdUsuario() == this.getIdUsuario()
                && other.getFecha().equals(this.getFecha()))
                || other.getId() == this.getId();
    }

    @Override
    public String toString() {

        String xml = "<Compra>";
        xml += "<Id>" + getId() + "</Id>";
        xml += "<IdOferta>" + getIdOferta() + "</IdOferta>";
        xml += "<IdUsuario>" + getIdUsuario() + "</IdUsuario>";
        xml += "<Fecha>" + getFecha() + "</Fecha>";
        xml += "</Compra>";

        return xml;
    }
}
