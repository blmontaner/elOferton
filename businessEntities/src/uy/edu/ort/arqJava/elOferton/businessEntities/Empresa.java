/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodrigo
 */
@XmlRootElement
@Entity
@Table(name = "T_EMPRESA")
public class Empresa {

    @Id
    @Column(name = "ID")
    private long id;
    
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;

    public Empresa() {
    }

    public Empresa(long id) {
        this.id = id;
    }

    public Empresa(long id, String nombre, String telefono, String direccion, String email) {
        this.id = id;
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (telefono != null) {
            this.telefono = telefono.trim();
        }
        if (direccion != null) {
            this.direccion = direccion.trim();
        }
        if (email != null) {
            this.email = email.trim();
        }
    }

    public Empresa(String nombre, String telefono, String direccion, String email) {
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (telefono != null) {
            this.telefono = telefono.trim();
        }
        if (direccion != null) {
            this.direccion = direccion.trim();
        }
        if (email != null) {
            this.email = email.trim();
        }
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null) {
            this.telefono = telefono.trim();
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null) {
            this.direccion = direccion.trim();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email.trim();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Empresa other = (Empresa) obj;
        if (this.id != other.id) {
            return false;
        }

        return (this.getNombre().equals(other.getNombre())) || (this.getId() == other.getId());
    }

    @Override
    public String toString() {

        String xml = "<Empresa>";
        xml += "<Id>" + getId() + "</Id>";
        xml += "<Nombre>" + getNombre() + "<Nombre>";
        xml += "<Telefono>" + getTelefono() + "</Telefono>";
        xml += "<Direccion>" + getDireccion() + "</Direccion>";
        xml += "<Email>" + getEmail() + "</Email>";

        return xml;
    }
}
