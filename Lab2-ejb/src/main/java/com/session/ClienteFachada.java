/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Cliente;
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
public class ClienteFachada implements ClienteFachadaLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "com.mycompany_Lab2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public Cliente find(String id) {
        try {
            List<Cliente> clientes = null;
            Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.identificacion = :identificacion");
            q.setParameter("identificacion", id);
            clientes = q.getResultList();
            return clientes.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public boolean registrar(Cliente cliente) {
        try {
            em.createNativeQuery("INSERT INTO Cliente (identificacion, nombre, direccion, telefono, correo) values (?,?,?,?,?)").
                    setParameter(1, cliente.getIdentificacion())
                    .setParameter(2, cliente.getNombre())
                    .setParameter(3, cliente.getDireccion())
                    .setParameter(4, cliente.getTelefono())
                    .setParameter(5, cliente.getCorreo())
                    .executeUpdate();
                     return true;
        } catch (Exception e) {
            return false;
        }
    }
     
     
    
}
