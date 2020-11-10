package com.udea.session;

import com.udea.modelo.Tarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TarjetaManager implements TarjetaManagerLocal {

    @PersistenceContext(unitName = "com.udea_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public Tarjeta BuscarTarjeta(long numerotarjeta) {
        Query query = em.createNamedQuery("Tarjeta.findByNumeroTarjeta");
        query.setParameter("numeroTarjeta", numerotarjeta);

        try {
            return (Tarjeta) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void CrearTarjeta(Tarjeta tarjeta) {
        em.persist(tarjeta);
    }

    @Override
    public boolean comprobarTarjeta(Tarjeta tarjeta) {
        Tarjeta tarjetaBD = BuscarTarjeta(tarjeta.getNumeroTarjeta());
        if(tarjetaBD==null) return false; 
        return tarjetaBD.equals(tarjeta);
    }

    @Override
    public String identificarTipo(long nroTarjeta) {

        String nroTarjetaSt = String.valueOf(nroTarjeta);
        int a = Integer.parseInt(nroTarjetaSt.substring(0, 5));
        if ((a >= 11111) && (a <= 22222)) {
            return "American Express";
        }

        if ((a >= 33334) && (a <= 44444)) {
            return "Diners";
        }

        if ((a >= 55555) && (a <= 66666)) {
            return "Visa";
        }

        if ((a >= 77777) && (a <= 88888)) {
            return "Mastercard";
        }

        return "No valido";

    }

}
