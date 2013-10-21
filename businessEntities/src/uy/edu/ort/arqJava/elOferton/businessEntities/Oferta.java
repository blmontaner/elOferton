/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodrigo
 */
@XmlRootElement
public class Oferta {

    private long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Empresa empresa;

    public Oferta() {
    }

    public Oferta(long id, String nombre, String descripcion, double precio, Empresa empresa) {
        this.id = id;
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        }
        this.precio = precio;
        this.empresa = empresa;
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
