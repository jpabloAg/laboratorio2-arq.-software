/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Tarjeta;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface TarjetaManagerLocal {


    public void CrearTarjeta(Tarjeta tarjeta);

    public boolean comprobarTarjeta(Tarjeta tarjeta);

    public String identificarTipo(long nroTarjeta);

    public Tarjeta BuscarTarjeta(long numerotarjeta);
    
}
