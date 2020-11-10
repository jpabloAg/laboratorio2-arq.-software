package com.udea.session;

import com.udea.modelo.Transaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TrasaccionManager implements TrasaccionManagerLocal {

    @PersistenceContext(unitName = "com.udea_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public void CrearTransaccion(Transaccion transaccion) {
        Date date=null;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
             date = formatter.parse(formatter.format(new Date()));
        } catch (ParseException ex) {
            System.out.println(ex);
        }
              
        transaccion.setMarcaTiempo(date);
        em.persist(transaccion);
    }

}
