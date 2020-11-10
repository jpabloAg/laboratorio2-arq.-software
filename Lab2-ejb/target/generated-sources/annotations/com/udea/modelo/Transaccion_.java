package com.udea.modelo;

import com.udea.modelo.Tarjeta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2020-11-09T12:39:39")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Integer> codigo;
    public static volatile SingularAttribute<Transaccion, Date> marcaTiempo;
    public static volatile SingularAttribute<Transaccion, Integer> valor;
    public static volatile SingularAttribute<Transaccion, Tarjeta> numeroTarjeta;

}