/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Transaccion;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface TrasaccionManagerLocal {

    public void CrearTransaccion(Transaccion transaccion);
    
}
