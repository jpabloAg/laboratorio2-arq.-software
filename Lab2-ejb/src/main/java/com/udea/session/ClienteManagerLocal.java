/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface ClienteManagerLocal {

    public List<Cliente> BuscarTodos();

    public Cliente BuscarCliente(String id);

    public void CrearCliente(Cliente cliente);

    boolean comprobarCliente(Cliente cliente);
    
}
