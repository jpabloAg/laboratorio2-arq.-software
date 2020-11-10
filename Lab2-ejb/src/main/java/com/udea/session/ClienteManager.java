package com.udea.session;

import com.udea.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteManager implements ClienteManagerLocal {

    @PersistenceContext(unitName = "com.udea_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public void CrearCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public Cliente BuscarCliente(String id) {
        Query query = em.createNamedQuery("Cliente.findById");
        query.setParameter("id", id);
        return (Cliente) query.getSingleResult();
    }

    @Override
    public List<Cliente> BuscarTodos() {
        Query query = em.createNamedQuery("Cliente.findAll");
        return query.getResultList();
    }

    @Override
    public boolean comprobarCliente(Cliente cliente) {
        Cliente clienteDB = BuscarCliente(cliente.getId().toString());
        return clienteDB.equals(cliente);
    }

}
