/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Cliente;
import com.entity.Tarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarlosMedina
 */
@Stateless
public class TransaccionFachada implements TransaccionFachadaLocal {

    @PersistenceContext(unitName = "com.mycompany_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public boolean registrar(Cliente cliente, Tarjeta tarjeta, double valor) {
        try {
            em.createNativeQuery("INSERT INTO Transaccion (cliente_id, tarjeta_id, valor) values (?,?,?)").
                    setParameter(1, cliente.getIdentificacion())
                    .setParameter(2, tarjeta.getNumero())
                    .setParameter(3, valor)
                    .executeUpdate();
                     return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
