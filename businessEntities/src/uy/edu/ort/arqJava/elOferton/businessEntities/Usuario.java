/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

/**
 *
 * @author Rodrigo
 */
public class Usuario {

    private long id;
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String email;
    private String direccion;
    private String apellido;
    private String telefono;

    public Usuario() {
    }

    public Usuario(long id, String nombreUsuario, String contrasenia, String nombre,
            String email, String direccion, String apellido, String telefono) {
        this.id = id;

        if (nombreUsuario != null) {
            this.nombreUsuario = nombreUsuario.trim();
        }
        if (contrasenia != null) {
            this.contrasenia = contrasenia.trim();
        }
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (email != null) {
            this.email = email.trim();
        }

        if (direccion != null) {
            this.direccion = direccion.trim();
        }
        if (telefono != null) {
            this.telefono = telefono.trim();
        }
        if (apellido != null) {
            this.apellido = apellido.trim();
        }
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombre,
            String email, String direccion, String apellido, String telefono) {

        if (nombreUsuario != null) {
            this.nombreUsuario = nombreUsuario.trim();
        }
        if (contrasenia != null) {
            this.contrasenia = contrasenia.trim();
        }
        if (nombre != null) {
            this.nombre = nombre.trim();
        }
        if (email != null) {
            this.email = email.trim();
        }

        if (direccion != null) {
            this.direccion = direccion.trim();
        }
        if (telefono != null) {
            this.telefono = telefono.trim();
        }
        if (apellido != null) {
            this.apellido = apellido.trim();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null) {
            this.nombreUsuario = nombreUsuario.trim();
        }
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia != null) {
            this.contrasenia = contrasenia;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null) {
            this.direccion = direccion;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null) {
            this.telefono = telefono;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null) {
            this.apellido = apellido;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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

        final Usuario other = (Usuario) obj;

        return (this.getId() == other.getId()) || (this.getNombreUsuario().equals(other.getNombreUsuario()));
    }

    @Override
    public String toString() {

        String xml = "<Usuario>";
        xml += "<Id>" + getId() + "</Id>";
        xml += "<NombreUsuario>" + getNombreUsuario() + "<NombreUsuario>";
        xml += "<Contrasenia>" + getContrasenia() + "</Contrasenia>";
        xml += "<Nombre>" + getNombre() + "</Nombre>";
        xml += "<Email>" + getEmail() + "</Email>";
        xml += "<Direccion>" + getDireccion() + "<Direccion>";
        xml += "<Apellido>" + getApellido() + "</Apellido>";
        xml += "<Telefono>" + getTelefono() + "</Telefono>";
        xml += "</Usuario>";

        return xml;
    }
}
