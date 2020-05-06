package com.entity;

import com.entity.Cliente;
import com.entity.Tarjeta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-30T19:18:30")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Cliente> clienteId;
    public static volatile SingularAttribute<Transaccion, Double> valor;
    public static volatile SingularAttribute<Transaccion, Date> fechaCreacion;
    public static volatile SingularAttribute<Transaccion, Tarjeta> tarjetaId;
    public static volatile SingularAttribute<Transaccion, Integer> id;

}