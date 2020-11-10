package com.udea.modelo;

import com.udea.modelo.Cliente;
import com.udea.modelo.Transaccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2020-11-09T12:39:39")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, String> tipo;
    public static volatile SingularAttribute<Tarjeta, String> codigoSeguridad;
    public static volatile SingularAttribute<Tarjeta, Cliente> idCliente;
    public static volatile SingularAttribute<Tarjeta, Date> fechaVencimiento;
    public static volatile SingularAttribute<Tarjeta, Long> numeroTarjeta;
    public static volatile CollectionAttribute<Tarjeta, Transaccion> transaccionCollection;

}