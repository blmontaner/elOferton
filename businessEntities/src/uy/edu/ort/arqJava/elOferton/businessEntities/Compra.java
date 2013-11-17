/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Table(name = "T_COMPRA")
@Entity
public class Compra {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="USUARIO_ID",nullable=false)
    private Usuario usuario;
    @ManyToOne
    private Oferta oferta;
    private boolean paga;
    private UUID identificador;

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public Compra() {
        this.paga = false;
        this.identificador = UUID.randomUUID();
    }

    public Compra(Date fecha, Usuario usuario, Oferta oferta) {
        this.paga = false;
        this.fecha = fecha;
        this.usuario = usuario;
        this.oferta = oferta;
        this.identificador = UUID.randomUUID();
    }

    public Compra(Date fecha, Usuario usuario, Oferta oferta, long id) {
        this.paga = false;
        this.fecha = fecha;
        this.usuario = usuario;
        this.oferta = oferta;
        this.id = id;
        this.identificador = UUID.randomUUID();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oferta getOferta() {
        return this.oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.fecha);
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
        if (this.usuario.getId() != other.usuario.getId()) {
            return false;
        }
        if (this.oferta.getId() != other.oferta.getId()) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {

        String xml = "<Compra>";
        xml += "<Id>" + getId() + "</Id>";
        xml += "<IdOferta>" + this.oferta.getId() + "</IdOferta>";
        xml += "<IdUsuario>" + this.usuario.getId() + "</IdUsuario>";
        xml += "<Fecha>" + getFecha() + "</Fecha>";
        xml += "</Compra>";

        return xml;
    }
}
