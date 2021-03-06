/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uy.edu.ort.arqJava.elOferton.businessEntities.utils.DateAdapter;

/**
 *
 * @author Rodrigo
 */
@XmlRootElement
@Entity
@Table(name = "T_OFERTA")
public class Oferta implements Serializable {

    @Id
    @Column(name = "ID")
    private long id;
    private String nombre;
    
    private String descripcion;
    private double precio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    private boolean porElDia;
    
    @ManyToOne
    private Empresa empresa;

    public Oferta() {
    }

    public Oferta(long id) {
        this.id = id;
    }

    public Oferta(long id, String nombre, String descripcion, double precio, Date fechaInicio, Date fechaFin, Empresa empresa) {
        this.id = id;
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        }
        this.precio = precio;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Oferta(String nombre, String descripcion, double precio, Empresa empresa) {
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        }
        this.precio = precio;
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isPorElDia() {
        return porElDia;
    }

    public void setPorElDia(boolean porElDia) {
        this.porElDia = porElDia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Oferta other = (Oferta) obj;

        return (other.getNombre().equals(this.getNombre())) || (other.getId() == this.getId());
    }

    @Override
    public String toString() {

        String xml = "<Oferta>";
        xml += "<Id>" + getId() + "</Id>";
        xml += "<Nombre>" + getNombre() + "<Nombre>";
        xml += "<Descripcion>" + getDescripcion() + "</Descripcion>";
        xml += "<Precio>" + getPrecio() + "</Precio>";

        return xml;
    }
}
