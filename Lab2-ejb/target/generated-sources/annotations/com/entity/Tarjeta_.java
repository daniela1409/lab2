package com.entity;

import com.entity.Transaccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-30T19:18:30")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, String> cvv;
    public static volatile SingularAttribute<Tarjeta, String> numero;
    public static volatile SingularAttribute<Tarjeta, String> fechaVencimiento;
    public static volatile SingularAttribute<Tarjeta, String> tipoDeTarjeta;
    public static volatile SingularAttribute<Tarjeta, String> fechaCreacion;
    public static volatile CollectionAttribute<Tarjeta, Transaccion> transaccionCollection;

}