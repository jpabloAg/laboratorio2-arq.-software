/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByNumeroTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.numeroTarjeta = :numeroTarjeta"),
    @NamedQuery(name = "Tarjeta.findByCodigoSeguridad", query = "SELECT t FROM Tarjeta t WHERE t.codigoSeguridad = :codigoSeguridad"),
    @NamedQuery(name = "Tarjeta.findByFechaVencimiento", query = "SELECT t FROM Tarjeta t WHERE t.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Tarjeta.findByTipo", query = "SELECT t FROM Tarjeta t WHERE t.tipo = :tipo")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroTarjeta")
    private long numeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CodigoSeguridad")
    private String codigoSeguridad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroTarjeta")
    private Collection<Transaccion> transaccionCollection;
    @JoinColumn(name = "IdCliente", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Tarjeta() {
    }

    public Tarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Tarjeta(Integer numeroTarjeta, String codigoSeguridad, Date fechaVencimiento, String tipo) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ( !(this.numeroTarjeta==other.numeroTarjeta)
                || (this.codigoSeguridad != null && !this.codigoSeguridad.equals(other.codigoSeguridad))
                || (this.fechaVencimiento != null && !compararFechasVencimiento(other.fechaVencimiento))
                || (this.idCliente != null && !this.idCliente.equals(other.idCliente))
                || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }

        return true;
    }

    private boolean compararFechasVencimiento(Date date) {
        DateFormat formatter = new SimpleDateFormat("MM/yyyy");
        return formatter.format(this.fechaVencimiento).equals(formatter.format(date));
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Tarjeta[ numeroTarjeta=" + numeroTarjeta + " ]";
    }

}
