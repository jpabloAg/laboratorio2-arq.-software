/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByCodigo", query = "SELECT t FROM Transaccion t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Transaccion.findByValor", query = "SELECT t FROM Transaccion t WHERE t.valor = :valor"),
    @NamedQuery(name = "Transaccion.findByMarcaTiempo", query = "SELECT t FROM Transaccion t WHERE t.marcaTiempo = :marcaTiempo")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private int valor;
    @Basic(optional = false)
    @Column(name = "MarcaTiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcaTiempo;
    @JoinColumn(name = "NumeroTarjeta", referencedColumnName = "NumeroTarjeta")
    @ManyToOne(optional = false)
    private Tarjeta numeroTarjeta;

    public Transaccion() {
    }

    public Transaccion(Integer codigo) {
        this.codigo = codigo;
    }

    public Transaccion(Integer codigo, int valor, Date marcaTiempo) {
        this.codigo = codigo;
        this.valor = valor;
        this.marcaTiempo = marcaTiempo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getMarcaTiempo() {
        return marcaTiempo;
    }

    public void setMarcaTiempo(Date marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public Tarjeta getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Tarjeta numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Transaccion[ codigo=" + codigo + " ]";
    }
    
}
