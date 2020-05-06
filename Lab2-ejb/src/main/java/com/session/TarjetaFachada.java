/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Tarjeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CarlosMedina
 */
@Stateless
public class TarjetaFachada implements TarjetaFachadaLocal {

    @PersistenceContext(unitName = "com.mycompany_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public Tarjeta find(String numero) {
        try {
            List<Tarjeta> tarjetas = null;
            Query q = em.createQuery("SELECT t FROM Tarjeta t WHERE t.numero = :numero");
            q.setParameter("numero", numero);
            tarjetas = q.getResultList();
            return tarjetas.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean registrar(Tarjeta tarjeta) {
        try {
            em.createNativeQuery("INSERT INTO Tarjeta (numero, cvv, fecha_vencimiento, tipo_de_tarjeta) values (?,?,?,?)").
                    setParameter(1, tarjeta.getNumero())
                    .setParameter(2, tarjeta.getCvv())
                    .setParameter(3, tarjeta.getFechaVencimiento())
                    .setParameter(4, tarjeta.getTipoDeTarjeta())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
