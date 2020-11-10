/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import com.udea.modelo.Cliente;
import com.udea.modelo.Tarjeta;
import com.udea.modelo.Transaccion;
import com.udea.session.ClienteManagerLocal;
import com.udea.session.TarjetaManagerLocal;
import com.udea.session.TrasaccionManagerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author user
 */
@Named(value = "controlador")
@SessionScoped
public class Controlador implements Serializable {

    @EJB
    private TrasaccionManagerLocal trasaccionManager;

    @EJB
    private TarjetaManagerLocal tarjetaManager;

    @EJB
    private ClienteManagerLocal clienteManager;

    private Transaccion transaccion = new Transaccion();

    private Cliente cliente = new Cliente();

    private Tarjeta tarjeta = new Tarjeta();

    public Controlador() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String comprobar() {

        identificarTipo();
        tarjeta.setIdCliente(cliente);
        if (tarjetaManager.comprobarTarjeta(tarjeta)) {
            return "CONFIRMAR";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos erroneos", ""));
        return "vistaFormulario";

    }

    public String pagar() {

        transaccion.setNumeroTarjeta(tarjeta);
        trasaccionManager.CrearTransaccion(transaccion);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "TRANSACCIÓN EXITOSA", ""));
        return "INFO";
    }

    public void identificarTipo() {
        String tipoTarjeta = tarjetaManager.identificarTipo(tarjeta.getNumeroTarjeta());
        if ("No valido".equals(tipoTarjeta)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nro tarjeta erroneo", ""));
            return;
        }
        tarjeta.setTipo(tipoTarjeta);
    }

    public String cancelar() {
        tarjeta = new Tarjeta();
        cliente = new Cliente();
        return "CANCELAR";
    }

    public String salir() {
        tarjeta = new Tarjeta();
        cliente = new Cliente();
        transaccion = new Transaccion();
        return "SALIR";
    }

}
